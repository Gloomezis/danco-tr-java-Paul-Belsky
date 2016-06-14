/**
 * 
 */

myApp.factory('RegisterRestService',['$resource',function($resource){
	/*   $resource('/register/:id.:format')    */
return $resource('/register',{
/*	id:'@user',           @ for dinamics params  
	format:'json'
	someKey:'someKey'   this patams go after url upper after ?    
*/
	},{update:{method:'PUT',params:{ id:'@id'}, isArray:false}
	})	 ;
	



/*var User = $resource('/user/:userId', {userId:'@id'});
var user = User.get({userId:123}, function() {
  user.abc = true;
  user.$save();
});
*/
	
	
	
}]);
