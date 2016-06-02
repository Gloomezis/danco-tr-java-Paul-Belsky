/**
 * 
 */
angular.module('loginApp', ['common',  'editableTableWidgets'])  
    .controller('LoginCtrl', function ($scope, LoginService) {
 
        $scope.onLogin = function () {
            console.log('Attempting login with username ' + $scope.vm.username + ' and password ' + $scope.vm.password);
 
            if ($scope.form.$invalid) {
                return;
            }
 
            LoginService.login($scope.vm.userName, $scope.vm.password);
 
        };
 
    });