'use strict';

socialNetworkApp.factory('dialogService',
    function dialogService($http, $q, BASE_URL) {


        

        var serviceUrl = BASE_URL + '/groups/';

        return {
            getDialogs: function (groupId) {
                var url = serviceUrl + groupId + '/dialogs/';

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

            getDialog: function (groupId,dialogId) {
                var url = serviceUrl + groupId + '/dialogs/'+dialogId;

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


            addDialog: function (groupId,dialogData) {
                var url = serviceUrl + groupId + '/dialogs/';

                var deferred = $q.defer();
                $http.post(url, dialogData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            editDialog: function (groupId,dialogId,messageId,dialogData) {
                var url = serviceUrl + groupId + '/dialogs/'+ dialogId ;

                var deferred = $q.defer();
                $http.put(url, dialogData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            deleteDialog: function (groupId,dialogId,messageId) {
                var url = serviceUrl + groupId + '/dialogs/'+ dialogId ;

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