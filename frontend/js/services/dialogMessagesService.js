'use strict';

socialNetworkApp.factory('dialogMessageService',
    function dialogMessageService($http, $q, BASE_URL) {


        

        var serviceUrl = BASE_URL + '/groups/';

        return {
            getDialogMessages: function (groupId,dialogId) {
                var url = serviceUrl + groupId + '/dialogs/'+dialogId+'/messages';

                var deferred = $q.defer();
                $http.get(url)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            getDialogMessage: function (groupId,dialogId,messageId) {
                var url = serviceUrl + groupId + '/dialogs/'+dialogId+'/messages/'+messageId;

                var deferred = $q.defer();
                $http.get(url)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },


            addDialogMessage: function (groupId,dialogId,dialogMessageData) {
                var url = serviceUrl + groupId + '/dialogs/'+dialogId+'/messages';

                var deferred = $q.defer();
                $http.post(url, dialogMessageData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            editDialogMessage: function (groupId,dialogId,messageId,dialogMessageData) {
                var url = serviceUrl + groupId + '/dialogs/'+ dialogId +'/messages/'+messageId;

                var deferred = $q.defer();
                $http.put(url, dialogMessageData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            deleteDialogMessage: function (groupId,dialogId,messageId) {
                var url = serviceUrl + groupId + '/dialogs/'+ dialogId +'/messages/'+messageId;

                var deferred = $q.defer();
                $http.delete(url)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            }

            
        }
    });