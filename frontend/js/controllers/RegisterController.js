'use strict';

socialNetworkApp.controller('RegisterController',
    function RegisterController($scope, $http, authService, Notification, $route) {

        $scope.register = function (userData) {
            authService.register(userData)
            .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
            }, function (error) {
                var errorMsg = error.modelState[Object.keys(error.modelState)[0]][0];
                Notification.error(errorMsg);
            })
        }
    });