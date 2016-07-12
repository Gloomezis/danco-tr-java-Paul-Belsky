'use strict';

socialNetworkApp.controller('GroupsController',
  function GroupsController($scope, groupsService, Notification,dataGroups) {


   $scope.dataGroups=dataGroups;
   
   $scope.getGrops= function () {
    groupsService.getGroups()
    .then(function (data) {
      if(!data.responseEntity){
        if(data.message){
         Notification.error(data.message);
       }
     }else
     {
       $scope.groups = data;
       Notification.success(data.message);
     }
   }, function (error) {
    Notification.error(error.message);
  })
  };
}); 

