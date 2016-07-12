'use strict';

socialNetworkApp.factory('groupsService',
    function groupsService($http, $q, BASE_URL) {


        

        var serviceUrl = BASE_URL + '/groups';

        return {
            getGroups: function () {
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
        }
    });


