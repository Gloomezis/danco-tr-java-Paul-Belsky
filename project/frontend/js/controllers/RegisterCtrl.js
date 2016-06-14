/**
 * 
 */
'use strict';

myApp.controller('RegisterController', function ($scope, $rootScope, RegisterService) {
	  $scope.confirmdPassword='';
	  $scope.userData = {
	    login:'',
	    password:'',
	    email: '',
	    registrationDate:'new Date()'
	    userDetails: {
	    	          lastName:'',
	               	  firstName:'',
	    	          gender:'',
	    	          dateOfBirth:'',
	    	          phoneNumber:'',
	    	          location:{
	    	        	         city: '',
	    	        	         state:'',
	    	        	         country:'',
	    	                    }
	                   }
	                 };
	  
	 /* var promiseObj=RegisterService.register(userData);
	  * promiseObj.then(function(value) { $scope.register=value; });  =succesCallback
	  * parametr  polniy promize objecta :then(successCallback, errorCallback, notifyCallback)
	  */
	  
	  $scope.register = function (userData) {
	    RegisterService.register(userData).then(function () {
	    
	    }, function () {
	     
	    });
	  };
	})

