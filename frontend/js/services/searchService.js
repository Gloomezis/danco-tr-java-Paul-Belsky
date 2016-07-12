'use strict';

socialNetworkApp.factory('searchService',
    function searchService($http, $q, BASE_URL) {
        

        return {
            searchUser: function (searchData) {
                var deferred = $q.defer();
                $http.post(BASE_URL +'/users/search',searchData, {
                    ignoreLoadingBar: true
                })
                .success(function (data) {
                    deferred.resolve(data)
                })
                .error(function (error) {
                    deferred.reject(error)
                });
                return deferred.promise;
            },

        }
    });


