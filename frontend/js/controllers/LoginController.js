'use strict';

socialNetworkApp.controller('LoginController',
    function LoginController($scope, authService, Notification, $route) {

        $scope.login = function (userData) {
            authService.login(userData)
            .then(function (data) {
                if (data.responseEntity) {
                    authService.setCredentials(data.responseEntity);
                    Notification.success(data.message);
                    $route.reload();
                }else{
                   Notification.error(data.message);  
               }
           }, function (error) {
            Notification.error(error.error_description);
        })
        }
    });