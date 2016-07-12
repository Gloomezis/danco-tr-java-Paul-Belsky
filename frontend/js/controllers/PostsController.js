'use strict';

socialNetworkApp.controller('PostsController',
    function PostsController($scope, $routeParams, PAGE_SIZE, postsService, Notification,$route) {


        var lastPostId = '0';
        $scope.currentPagePosts = 1; 
        $scope.maxSize = PAGE_SIZE; 
        $scope.postsMessage = 'Loading posts...';
        $scope.count=0;
        $scope.posts = [];
        

        $scope.newsEventPosts = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            postsService.getPostsNewsEvents($scope.maxSize,  lastPostId)
            .then(function (data) {
                if(!data.responseEntity){
                    $scope.postsMessage = 'No more posts.';
                    Notification.error(data.message);
                }else{
                    $scope.posts = $scope.posts.concat(data.responseEntity);
                    if (data.responseEntity.length > 0) {
                        lastPostId = ($scope.currentPagePosts)*$scope.maxSize; 
                        $scope.currentPagePosts = $scope.currentPagePosts+1; 
                        $scope.isScrollPaused = false;
                    } else { 
                        $scope.isScrollPaused = true;
                    }
                }
            }, function (error) {
                Notification.error(error.message);
            })
        };


        $scope.newsFeedPosts = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            postsService.getPosts( $scope.maxSize,  lastPostId)
            .then(function (data) {
               $scope.debug=data;
               if(!data.responseEntity){
                  $scope.postsMessage = 'No more posts.';
                  if(data.message){
                   Notification.error(data.message);
               }
           }else{
             $scope.count = data.count;
              $scope.posts = $scope.posts.concat(data.responseEntity);
              if (data.responseEntity.length > 0) {
                lastPostId = ($scope.currentPagePosts)*$scope.maxSize; 
                $scope.currentPagePosts = $scope.currentPagePosts+1; 
                $scope.isScrollPaused = false;
            } else { $scope.isScrollPaused = true;
            }
        }
    }, function (error) {
        Notification.error(error.message);
    })
    };

        $scope.userPosts = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            postsService.getUserPosts($scope.maxSize, lastPostId, $routeParams.username)
            .then(function (data) {
               $scope.debug=data;
               if(!data.responseEntity){
                $scope.postsMessage = 'No more posts.';
                if(data.message){
                   Notification.error(data.message);
               }
           }else
           {
              $scope.count = data.count;
              $scope.posts = $scope.posts.concat(data.responseEntity);
              if (data.responseEntity.length > 0) {
                lastPostId = ($scope.currentPagePosts)*$scope.maxSize; 
                $scope.currentPagePosts = $scope.currentPagePosts+1; 
                $scope.isScrollPaused = false;
            } else {
                $scope.isScrollPaused = true;
            }
        }
    }, function (error) {
        Notification.error(error.message);
    });
    };


        $scope.addPost = function (postData, userId) {
            postsService.addPost(postData, userId)
            .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
            }, function (error) {
                Notification.error('Failed creating post.');
            })
        };

        $scope.editPost = function (post) {
            postsService.editPost(post)
            .then(function (data) {
             if(!data.responseEntity){
                Notification.success(data.message);
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            console.log(error);
            Notification.error('Failed editing post.');
        })
        };

        $scope.deletePost = function (post) {
            postsService.deletePost(post)
            .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $scope.posts.splice($scope.posts.indexOf(post), 1);
                }else{
                    Notification.error(data.message);
                }
            }, function (error) {
                console.log(error);
                Notification.error('Failed deleting post.');
            })
        };

        
        $scope.dateFromNow = function (date) {
            return moment(date).add(1, 'minut').fromNow();
        };


    });