'use strict';

var DialogMessagesController=socialNetworkApp.controller('DialogMessagesController',
    function($scope,  dialogMessagesService,PAGE_SIZE, Notification, $route) {

        $scope.dialogMessages =[];
        $scope.dialogMessageData ='';
        var lastDialogMessageId = '0';
        $scope.currentPageDialogMessage = 1; 
        $scope.maxSize = PAGE_SIZE; 
        $scope.dialogMessagesCount=0;

        $scope.getDialogMessages = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            dialogMessagesService.getDialogMessages($scope.maxSize,  lastDialogMessageId)
            .then(function (data) {
                if(!data.responseEntity){
                    if(data.message){
                     Notification.error(data.message);
                 }
             }else
             {
                 $scope.dialogMessagesCount=data.count;
                 $scope.dialogMessages= $scope.dialogMessages.concat(data.responseEntity);
                 if (data.responseEntity.length > 0) {
                    lastDialogMessageId= ($scope.currentPageDialogMessage)*$scope.maxSize; 
                    $scope.currentPageDialogMessage = $scope.currentPageDialogMessage+1; 
                    $scope.isScrollPaused = false;
                } else { 
                    $scope.isScrollPaused = true;
                }
            }
        }, function (error) {
            Notification.error(error.message);
        }) 
        };


        $scope.addDialogMessage = function (dialogMessageData) {
            dialogMessagesService.addDialogMessage(dialogMessageData)
            .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
            }, function (error) {
                Notification.error('Failed to add dialog message. Please try again.')
            })
        };


        $scope.deleteDialogMessage = function (dialogMessage) {
            dialogMessagesService.deleteDialogMessage(dialogMessage.id)
            .then(function (data) {
               if(!data.responseEntity){
                Notification.success(data.message);
                $scope.dialogMessages.splice($scope.dialogMessages.indexOf(dialogMessage), 1);
                $scope.dialogMessagesCount= $scope.dialogMessagesCount-1;
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            Notification.error('Failed delete deilog message. Please try again.')
        })
        };

        $scope.editDialogMessage = function (dialogMessageData) {
            dialogMessagesService.editDialogMessage(dialogMessageData)
            .then(function (data) {
               if(!data.responseEntity){
                Notification.success(data.message);
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            Notification.error('Failed to update dialog message. Please try again.')
        })
        };
    });




 










