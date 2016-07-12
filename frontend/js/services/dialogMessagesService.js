'use strict';

socialNetworkApp.factory('dialogMessagesService',['$http', '$q', 'BASE_URL','$routeParams',
    function dialogMessagesService($http, $q, BASE_URL,$routeParams) {


        

        var serviceUrl = BASE_URL + '/groups/';

        return {
            getDialogMessages: function (pageSize, lastDialogMessageId) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs/'+$routeParams.dialogId+'/messages?StartDialogMessageId='+lastDialogMessageId+'&PageSize=' + pageSize;
                ;

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



            addDialogMessage: function (dialogMessageData) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs/'+$routeParams.dialogId+'/messages';

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

            
            deleteDialogMessage: function (messageId) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs/'+ $routeParams.dialogId +'/messages/'+messageId;

                var deferred = $q.defer();
                $http.delete(url)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            editDialogMessage: function (dialogMessageData) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs/'+ $routeParams.dialogId +'/messages/'+dialogMessageData.id;

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

            
        }
    }]);

