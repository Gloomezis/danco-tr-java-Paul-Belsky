'use strict';

socialNetworkApp.controller('ChangePasswordController',
    function ChangePasswordController($scope, $location, userService, Notification,userData) {

        $scope.userData = userData;
        
        $scope.changePassword = function (userData) {
            userService.changePassword(userData)
            .then(function (data) {
                if(!data.responseEntity){
                 Notification.success(data.message);
                 $location.path('/');
             }else{
                Notification.error(data.message);
                $location.path('/');
            }    
        }, function (error) {
            var errorMsg = error.modelState[Object.keys(error.modelState)[0]][0];
            Notification.error(errorMsg);
        })
        }
    });