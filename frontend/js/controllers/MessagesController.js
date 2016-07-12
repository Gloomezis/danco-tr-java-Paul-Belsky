'use strict';

var MessagesController=socialNetworkApp.controller('MessagesController',
    function($scope, messagesService, PAGE_SIZE,Notification,$log,$route) {

        $scope.messages=[];
        $scope.message;
        $scope.messagesMessage = 'Loading message...';
        var lastMessageId = '0';
        $scope.currentPageMessage = 1; 
        $scope.maxSize = PAGE_SIZE; 


        $scope.getMyMessagesList= function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            messagesService.getMyMessagesList($scope.maxSize,  lastMessageId)
            .then(function (data) {
                if(!data.responseEntity){
                 Notification.error(data.message);
                 $scope.messagesMessage = 'No more messages.';
             }else{
                $scope.messages = $scope.messages.concat(data.responseEntity);
                if (data.responseEntity.length > 0) {
                    lastMessageId = ($scope.currentPageMessage)*$scope.maxSize; 
                    $scope.currentPageMessage = $scope.currentPageMessage+1; 
                    $scope.isScrollPaused = false;
                } else { $scope.isScrollPaused = true;
                }
            }
        }, function (error) {
            Notification.error(error.message);
        })
        };


        $scope.getMyMessagesOneByOne = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            messagesService.getMyMessagesOneByOne($scope.maxSize,  lastMessageId)
            .then(function (data) {
                $scope.debug=data;
                if(!data.responseEntity){
                    Notification.error(data.message);
                    $scope.messagesMessage = 'No more messages.';
                }else{
                    $scope.messages = $scope.messages.concat(data.responseEntity);
                    if (data.responseEntity.length > 0) {
                        lastMessageId = ($scope.currentPageMessage)*$scope.maxSize; 
                        $scope.currentPageMessage = $scope.currentPageMessage+1; 
                        $scope.isScrollPaused = false;
                    } else { $scope.isScrollPaused = true;
                    }
                }
            }, function (error) {
                Notification.error(error.message);
            })
        };


        $scope.addMessage = function (messageData) {
            messagesService.addMessage(messageData)
            .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
            }, function (error) {
             Notification.error('Failed to add message. Please try again.')
         })
        };

        

        $scope.editMessage = function (messageData) {
            messagesService.editMessage(messageData)
            .then(function (data) {
             if(!data.responseEntity){
                Notification.success(data.message);
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            Notification.error('Failed to update message. Please try again.')
        })
        };
        

        $scope.deleteMessage = function (message) {
            messagesService.editMessage(message)
            .then(function (data) {
             if(!data.responseEntity){
                $scope.messages.splice($scope.messages.indexOf(message), 1);
                Notification.success("message delete successfull!");
            }else{
              Notification.error(data.message);
          }
      }, function (error) {
        Notification.error('Failed delete message. Please try again.')
    })
};

});