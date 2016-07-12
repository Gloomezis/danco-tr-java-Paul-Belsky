'use strict';

socialNetworkApp.factory('messagesService',['$http', '$q', 'BASE_URL','$routeParams',
    function messagesService($http, $q, BASE_URL,$routeParams) {


        return {
            getMyMessagesList: function (pageSize, lastMessageId) {
                var url = BASE_URL+'/me/messages?StartMessageId='+lastMessageId+'&PageSize=' + pageSize;

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

            getMyMessagesOneByOne: function (pageSize, lastMessageId) {
                var url = BASE_URL +'/me/messages/user/'+ $routeParams.userid +'?StartMessageId='+lastMessageId+'&PageSize=' + pageSize;;
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

            addMessage: function (messageData) {
                var url = BASE_URL + '/me/messages/'+$routeParams.userid ;
                var deferred = $q.defer();
                $http.post(url,messageData)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            editMessage: function (messageData) {
                var url = BASE_URL +'/me/messages/'+ messageData.id  ;

                var deferred = $q.defer();
                $http.put(url, messageData)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            deleteMessage: function (messageId) {
                var url = BASE_URL +'/me/messages/'+ messageId  ;

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
    }]);