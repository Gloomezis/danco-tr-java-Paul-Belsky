'use strict';

socialNetworkApp.factory('searchService',
    function searchService($http, $q, BASE_URL) {
        var serviceUrl = BASE_URL ;

        return {
            searchUser: function (searchData) {
                var deferred = $q.defer();
                $http.get(serviceUrl +'/users/search?searchTerm='+ searchData, {
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

            searchGroup: function (searchData) {
                var deferred = $q.defer();
                $http.get(serviceUrl +'/groups/search?searcTerms='+ searchData, {
                    ignoreLoadingBar: true
                })
                    .success(function (data) {
                        deferred.resolve(data)
                    })
                    .error(function (error) {
                        deferred.reject(error)
                    });
                return deferred.promise;
            }
        }
    });