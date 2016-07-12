'use strict';

socialNetworkApp.factory('friendsService',
    function friendsService($http, $q, BASE_URL) {

        return {
           getMyFollowers: function (pageSize,  lastFollowersId) {
            var deferred = $q.defer();

            $http.get(BASE_URL + '/me/followers?StartFollowersId='+lastFollowersId+'&PageSize=' + pageSize)
            .success(function (data) {
                deferred.resolve(data);
            })
            .error(function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        },

        getMyFollowings: function (pageSize,  lastFollowingsId) {
            var deferred = $q.defer();

            $http.get(BASE_URL + '/me/followings?StartFollowingsId='+lastFollowingsId+'&PageSize=' + pageSize)
            .success(function (data) {
                deferred.resolve(data);
            })
            .error(function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        },






        subscribe: function (friendId) {
            var deferred = $q.defer();

            $http.post(BASE_URL + '/me/requests/' + friendId)
            .success(function (data) {
                deferred.resolve(data);
            })
            .error(function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        },

        unsubscribe: function (friendId) {
            var deferred = $q.defer();

            $http.delete(BASE_URL + '/me/requests/' + friendId )
            .success(function (data) {
                deferred.resolve(data);
            })
            .error(function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        },
    };
});