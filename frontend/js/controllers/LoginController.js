'use strict';

socialNetworkApp.controller('LoginController',
    function LoginController($scope, authService, Notification, $route) {

        $scope.login = function (userData) {
            authService.login(userData)
                .then(function (data) {
                    if (data.errorCode==200) {
                    authService.setCredentials(data.responseEntity);
                    Notification.success('Successfully logged in!');
                    $route.reload();
                    }else{
                     Notification.error(data.errorCode+' '+data.errorMsg);  
                    }
                   
                }, function (error) {
                    Notification.error(error.error_description);
                })
        }
    });