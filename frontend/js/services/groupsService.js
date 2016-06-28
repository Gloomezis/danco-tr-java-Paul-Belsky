'use strict';

socialNetworkApp.factory('groupService',
    function groupService($http, $q, BASE_URL) {


        

        var serviceUrl = BASE_URL + '/groups/';

        return {
            getGrops: function () {
                var url = serviceUrl;

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

            getGroup: function (groupId) {
                var url = serviceUrl + groupId ;

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

            

            getUserGroupList: function (userId) {
                var url = BASE_URL+'/users/'+userId+'/groups';

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

                

           
           getMyGroupList: function (userId) {
                var url = BASE_URL+'/me/groups';

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


            addGroup: function (groupData) {
                var url = serviceUrl ;

                var deferred = $q.defer();
                $http.post(url, groupData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            editGroup: function (groupId,groupData) {
                var url = serviceUrl + groupId  ;

                var deferred = $q.defer();
                $http.put(url, groupData)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },

            deleteGroup: function (groupId) {
                var url = serviceUrl + groupId  ;

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

           
             getGroupMembers: function (groupId) {
                var url = serviceUrl + groupId +'/members' ;

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

            


             //not have entity for request
             subscribeGroup: function (groupId) {
                var url = serviceUrl + groupId +'/subscribe';

                var deferred = $q.defer();
                $http.post(url)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });

                return deferred.promise;
            },
            //not have entity for request
            deleteSubscribeGroup: function (groupId) {
                var url = serviceUrl + groupId +'/deleteSubscribe' ;

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