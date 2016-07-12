'use strict';

var DialogsController=socialNetworkApp.controller('DialogsController',
    function($scope,  dialogsService,PAGE_SIZE, Notification ,$route) {

        $scope.dialogs = [];
        var lastDialogId = '0';
        $scope.currentPageDialog = 1; 
        $scope.dialogsCount=0;
        $scope.maxSize = PAGE_SIZE; 
        

        $scope.getDialogs = function () {
            if ($scope.isScrollPaused) return;
            $scope.isScrollPaused = true;
            dialogsService.getDialogs($scope.maxSize,  lastDialogId)
            .then(function (data) {
                if(!data.responseEntity){
                    if(data.message){
                       Notification.error(data.message);
                   }
               }else
               {
                 $scope.dialogsCount=data.count;
                 $scope.dialogs = $scope.dialogs.concat(data.responseEntity);
                 if (data.responseEntity.length > 0) {
                    lastDialogId = ($scope.currentPageDialog)*$scope.maxSize; 
                    $scope.currentPageDialog = $scope.currentPageDialog+1; 
                    $scope.isScrollPaused = false;
                } else { 
                    $scope.isScrollPaused = true;
                }
            } 
        }, function (error) {
            Notification.error(error.message);
        })
        };


        $scope.addDialog = function (dialogData) {
            dialogsService.addDialog(dialogData)
            .then(function (data) {
             if(!data.responseEntity){
                Notification.success(data.message);
                $route.reload();
            }else{
                Notification.error(data.message);
            }
        }, function (error) {
            Notification.error('Failed to add dialog. Please try again.')
        })
        };

        $scope.deleteDialog = function (dialog) {
            dialogsService.deleteDialog(dialog.id)
            .then(function (data) {
             if(!data.responseEntity){
                $scope.dialogs.splice($scope.dialogs.indexOf(dialog), 1);
                $scope.dialogsCount= $scope.dialogsCount-1;
                Notification.success(data.message);
            }else{
                Notification.error(data.message);
            }
        }, function (error) {  
            $route.reload();
        })
        };
    });



