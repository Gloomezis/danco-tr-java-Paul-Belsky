'use strict';

socialNetworkApp.controller('EditProfileController',
    function EditProfileController($scope, $location, userService, Notification, userData) {

        $scope.userData = userData;

   

        $scope.editProfile = function (userData) {
            userService.editProfile(userData)
                .then(function (data) {
                    Notification.success(data.message);
                    $location.path('/');
                }, function (error) {
                    var errorMsg = error.modelState[Object.keys(error.modelState)[0]][0];
                    Notification.error(errorMsg);
                })
        };
    });