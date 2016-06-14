/**
 * 
 */

app.factory('RegistrationService', function($http, $q, userData) {
	return {
		registersimple : function(userData) {
			return $http.post('/register', userData).success(function(data,status,headers,config) {
				 console.error('status');
			}).error(function(){
				 console.error('status');
			});
		},
  /*     
   * $http.get(url,[config]);
   * $http.post(url,data,[config]);
   * $http.put(url,data,[config]);
   * $http.patch(url,data,[config]);
   * $http.delete(url,[config]);
   * $http.head(url,[config]);
   * $http.jsonp(url,[config]);
   * */
		
		
		register: function(userData){
            return $http.post('http://localhost:8080/restController/register', user)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while creating user');
                                return $q.reject(errResponse);
                            }
                    );
    },
    
    
    
    registerq: function(){
        var deferred = $q.defer();
        $http.post( 'http://localhost:8080/restController/register', data).
         success(function(data, status, headers, config) {
            deferred.resolve(data.question);
        }).
        error(function(data, status, headers, config) {
            deferred.reject(status);
        });
         
        return deferred.promise;
    }
}
    
    
    
	registerAnotherOne: function(){
		var req = {
				 method: 'POST',
				 url: 'http://localhost:8080/restController/register',
				 headers: {
				   'Content-Type': undefined
				 },
				 data: { test: 'test' }
				}

				$http(req).then(function(){...}, function(){...});
}
	
	
    
    
		

	};
})
