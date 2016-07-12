'use strict';

socialNetworkApp.factory('commentsService',['$http', '$q', 'BASE_URL','$routeParams',
    function commentsService($http, $q, BASE_URL,$routeParams) {


        

        var serviceUrl = BASE_URL + '/posts/';

        return {
            getPostComments: function (pageSize, lastMessageId) {
                var url = serviceUrl + $routeParams.postId + '/comments?StartCommentId='+lastMessageId+'&PageSize=' + pageSize;;

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

            addComment: function (commentData) {
                var url = serviceUrl + $routeParams.postId + '/comments';

                var deferred = $q.defer();
                $http.post(url, commentData)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            editComment: function (comment) {
                var url = serviceUrl + $routeParams.postId + '/comments/' + comment.id;

                var deferred = $q.defer();
                $http.put(url, comment)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },

            deleteComment: function (commentId) {
                var url = serviceUrl + $routeParams.postId + '/comments/' + commentId;

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