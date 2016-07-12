'use strict';

socialNetworkApp.controller('UserProfileController',
    function UserProfileController($scope, authService, getUserFullData, $routeParams, $location, friendsService, Notification, $timeout,$route) {

        $scope.userFullData = getUserFullData;
        if ($scope.userFullData) {
            $scope.isFriend = $scope.userFullData.isFriend;
        }
        if ($scope.userFullData.user.username == authService.getCurrentUser().username) {
            $scope.isFriend = true;
        }

         $scope.subscribe = function (userId) {
            friendsService.subscribe(userId)
                .then(function (data) {
                if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
                }, function (error) {
                    Notification.error(error.message);
                })
        };


        $scope.unsubscribe = function (userId) {
            friendsService.unsubscribe(userId)
                .then(function (data) {
                   if(!data.responseEntity){
                    Notification.success(data.message);
                    $route.reload();
                }else{
                    Notification.error(data.message);
                }
                }, function (error) {
                    Notification.error(error.message);
                })
        };
    });