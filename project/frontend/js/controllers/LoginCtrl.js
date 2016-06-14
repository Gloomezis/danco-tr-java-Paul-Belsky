/**
 * done
 */
'use strict';


myApp.controller('LoginController', function ($scope, $rootScope, AUTH_EVENTS, AuthService) {
	  $scope.credentials = {
	    login: '',
	    password: ''
	  };
	  $scope.login = function (credentials) {
	    AuthService.login(credentials).then(function () {
	      $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
	    }, function () {
	      $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
	    });
	  };
	})
	
	






/*
socialNetworkApp.controller('LoginController',
    function LoginController($scope, authService, Notification, $route) {

        $scope.login = function (userData) {
            authService.login(userData)
                .then(function (data) {
                    authService.setCredentials(data);
                    Notification.success('Successfully logged in!');
                    $route.reload();
                }, function (error) {
                    Notification.error(error.error_description);
                })
        }
    });

*/






