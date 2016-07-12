'use strict';

socialNetworkApp.controller('CommentsController',
    function CommentsController($scope, commentsService,PAGE_SIZE, Notification,$route) {

        

        $scope.comments = [];
        $scope.count=0;

        var lastMessageId = '0';
        $scope.currentPage = 1; 
        $scope.maxSize = PAGE_SIZE; 

        $scope.showAllComments = function () {
         if ($scope.isScrollPaused) return;
         $scope.isScrollPaused = true;
         commentsService.getPostComments($scope.maxSize,  lastMessageId)
         .then(function (data) {
            if(!data.responseEntity){
                if(data.message){
                 Notification.error(data.message);
             }
         }else
         {
             $scope.comments = $scope.comments.concat(data.responseEntity);
             $scope.count = data.count;
             if (data.responseEntity.length > 0) {
                lastMessageId = ($scope.currentPage)*$scope.maxSize; 
                $scope.currentPage = $scope.currentPage+1; 
                $scope.isScrollPaused = false;
            } else { $scope.isScrollPaused = true;
            }
        }

    }, function (error) {
        Notification.error(error);
    })
     };

     $scope.addComment = function (commentData) {
        commentsService.addComment(commentData)
        .then(function (data) {
            if(!data.responseEntity){
                Notification.success(data.message);
                $route.reload();
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            Notification.error('Failed to add comment. Please try again.')
        })
    };

    $scope.editComment = function (comment) {
        commentsService.editComment(comment)
        .then(function (data) {
           if(!data.responseEntity){
            Notification.success(data.message);
        }else{
            Notification.error(data.message);
        }
    }, function (error) {
        Notification.error('Failed to edit comment.')
    })
    };

    $scope.deleteComment = function (comment) {
        commentsService.deleteComment( comment.id)
        .then(function (data) {
          if(!data.responseEntity){
            $scope.comments.splice($scope.comments.indexOf(comment), 1);
            $scope.count= $scope.count-1;
            Notification.success(data.message);
        }else{
            Notification.error(data.message);
        }
    }, function (error) {
        Notification.error('Failed to delete comment.')
    })
    };
});