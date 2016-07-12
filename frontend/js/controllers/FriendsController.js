'use strict';

socialNetworkApp.controller('FriendsController',
  function FriendsController($scope, friendsService, PAGE_SIZE,Notification,$route) {


   $scope.friendsList=[];
   var lastFriendId = '0';
   $scope.currentPageFriends = 1; 
   $scope.friendsCount=0;
   $scope.maxSize = PAGE_SIZE; 
   
   
   $scope.getFollowers = function () {
    if ($scope.isScrollPaused) return;
    $scope.isScrollPaused = true;
    friendsService.getMyFollowers($scope.maxSize,  lastFriendId)
    .then(function (data) {
      if(!data.responseEntity){
        if(data.message){
         Notification.error(data.message);
       }
     }else
     { 
      $scope.friendsCount=data.count;
      $scope.friendsList = $scope.friendsList.concat(data.responseEntity);
      if (data.responseEntity.length > 0) {
        lastFriendId = ($scope.currentPageFriends)*$scope.maxSize; 
        $scope.currentPageFriends= $scope.currentPageFriends+1; 
        $scope.isScrollPaused = false;
      } else { 
        $scope.isScrollPaused = true;
      }
    }
  }, function (error) {
    Notification.error(error.message);
  })
  };
  

  $scope.getFollowings = function () {
    if ($scope.isScrollPaused) return;
    $scope.isScrollPaused = true;
    friendsService.getMyFollowings($scope.maxSize,  lastFriendId)
    .then(function (data) {
      $scope.debug=data;
      if(!data.responseEntity){
        if(data.message){
         Notification.error(data.message);
       }
     }else
     {
      $scope.friendsCount=data.count;
      $scope.friendsList = $scope.friendsList.concat(data.responseEntity);
      if (data.responseEntity.length > 0) {
        lastFriendId = ($scope.currentPageFriends)*$scope.maxSize; 
        $scope.currentPageFriends= $scope.currentPageFriends+1; 
        $scope.isScrollPaused = false;
      } else { 
        $scope.isScrollPaused = true;
      }
    }
  }, function (error) {
    Notification.error(error.message);
  })
  };
});