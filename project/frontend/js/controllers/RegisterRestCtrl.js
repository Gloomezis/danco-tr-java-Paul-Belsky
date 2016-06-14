/**
 * 
 */
/**
 * 
 */
'use strict';

myApp.controller('RegisterController', function ($scope, $rootScope, RegisterRestService) {
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
	  
	  $scope.register =RegisterRestService.save();
	  
	/*  { 'get':    {method:'GET'},                 RegisterRestService.get(params,succescb, errorcb)   for single result
		  'save':   {method:'POST'},                RegisterRestService.save(params,payloadData,succescb, errorcb)  
		  'query':  {method:'GET', isArray:true},   RegisterRestService.query(params,succescb, errorcb)  for array results
		  'remove': {method:'DELETE'},              RegisterRestService.get(params,succescb, errorcb)  
		  'delete': {method:'DELETE'} };            RegisterRestService.get(params,succescb, errorcb) equald remove  */    
	  
	  
	  
	  $scope.entry = new RegisterRestService(); //You can instantiate resource class

	  $scope.entry.data = userData;

	  Entry.save($scope.entry, function() {
	  
	  /* succesfull saved

	})
