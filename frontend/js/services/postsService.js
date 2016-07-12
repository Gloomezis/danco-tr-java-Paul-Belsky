'use strict';

socialNetworkApp.factory('postsService',
    function postsService($http, $q, BASE_URL) {

        return {

            getPostsNewsEvents:function (pageSize, lastPostId) {
                var url = BASE_URL + '/me/news?StartPostId='+lastPostId+'&PageSize=' + pageSize;

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
            
            getPosts: function (pageSize, lastPostId) {
                var url = BASE_URL + '/me/feed?StartPostId=' + lastPostId +
                '&PageSize=' + pageSize;

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

            getUserPosts: function (pageSize, lastPostId, username) {
                var url = BASE_URL + '/users/' + username + '/wall?StartPostId=' + lastPostId +
                '&PageSize=' + pageSize;

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

            addPost: function (postData, userId) {
                var url = BASE_URL +/users/+userId+'/posts';

                var deferred = $q.defer();
                $http.post(url, postData)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            editPost: function (post) {
                var url = BASE_URL + '/posts/' + post.id;

                var deferred = $q.defer();
                $http.put(url, post)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            deletePost: function (post) {
                var url = BASE_URL + '/posts/' + post.id;

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