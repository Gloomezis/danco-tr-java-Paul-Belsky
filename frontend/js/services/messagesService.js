'use strict';

socialNetworkApp.factory('messageService',
    function messageService($http, $q, BASE_URL) {


        

        

        return {
            getMyMessagesList: function () {
                var url = BASE_URL+'/me/messages';

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

            getMyMessagesOneByOne: function (userId) {
                var url = BASE_URL +'/me/messages/user/'+ userId ;
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
                
                var url = BASE_URL + '/me/messages' ;

                var deferred = $q.defer();
                $http.post(url, messageData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            editMessage: function (messageId,messageData) {
                var url = BASE_URL +'/me/messages/'+ messageId  ;

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
    });