'use strict';

socialNetworkApp.controller('SearchController',
    function SearchController($scope, searchService, $timeout) {

        $scope.searchGroup = function (searchGroup) {

            if (searchGroup != undefined) {
                searchService.searchGroup(searchGroup)
                    .then(function (data) {
                        $scope.searchObj = data;
                    }, function (error) {
                        console.log(error);
                    })
            } else {
                $scope.searchObj = '';
            }
            
        };

        $scope.searchUser = function (searchUser) {
            if (searchUser != undefined) {
                searchService.searchUser(searchUser)
                    .then(function (data) {
                        $scope.searchObj = data;
                    }, function (error) {
                        console.log(error);
                    })
            } else {
                $scope.searchObj = '';
            }
        };

        

        $scope.showHideResults = function () {
            $timeout(function () {
                $scope.showSearchResults = !$scope.showSearchResults;
            }, 750);
        };
    });