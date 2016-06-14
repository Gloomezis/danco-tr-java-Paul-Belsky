
var myApp = angular.module('myApp', [/*ui.router*/'ngRoute'/*,'ngResource'*/]);


myApp.config(function ($httpProvider) {
	  $httpProvider.interceptors.push([
	    '$injector',
	    function ($injector) {
	      return $injector.get('AuthInterceptor');
	    }
	  ]);
	})	
	
	
	myApp.constant('AUTH_EVENTS', {
  loginSuccess: 'auth-login-success',
  loginFailed: 'auth-login-failed',
  logoutSuccess: 'auth-logout-success',
  sessionTimeout: 'auth-session-timeout',
  notAuthenticated: 'auth-not-authenticated',
  notAuthorized: 'auth-not-authorized'
})

myApp.constant('USER_ROLES', {
  all: '*',
  admin: 'admin',
  user: 'user',
  guest: 'guest'
})

myApp.config(['$routeProvider','$locationProvider',
    function ($routeProvider,$locationProvider) {
	
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: false
	})
        $routeProvider

          .when('/', {
                    templateUrl: 'index.html',
                    controller: 'IndexController'
                })
                
                
                	 /*<a ui-sref=".list" ></a>
                	  * <div ui-view></div>
                	  ['ui.router']
                	  *  
                	  *  routerApp.config(function($stateProvider, $urlRouterProvider) {
                       $urlRouterProvider.otherwise('/home');
                       $stateProvider
                	 
                	    .state('home', {
                          url: '/home',
                          templateUrl: 'views/home.html', 
                          controller: 'HomeController',
                           data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })*/
                
                .when('/home', {
                    templateUrl: 'views/home.html',
                    controller: 'HomeController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                .when('/register', {
                    templateUrl: 'views/register.html',
                    controller: 'RegisterController'
                    	
               
                })
                
                .when('/login', {
                    templateUrl: 'views/login.html',
                    controller: 'LoginController'
                })
                
                .when('/settings', {
                    templateUrl: 'views/settings.html',
                    controller: 'SettingsController',
                    	data: {
                            authorizedRoles: [USER_ROLES.user]
                     }
                })
                
                .when('/events', {
                    templateUrl: 'views/others/eventList.html',
                    controller: 'EventController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
               
                })
                
                .when('/messages', {
                    templateUrl: 'views/message/messageList.html',
                    controller: 'MessageController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
        
                 .when('/messages/:id', {
                    templateUrl: 'views/message/messageOneUser.html',
                    controller: 'MessageController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
       
                .when('/friendlist', {
                    templateUrl: 'views/others/friendList.html',
                    controller: 'FriendControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                .when('/friendlist/:id', {
                    templateUrl: 'views/others/friendPage.html',
                    controller: 'FriendControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                .when('/groups', {
                    templateUrl: 'views/group/groupList.html',
                    controller: 'GroupControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                .when('/groups/:groupId', {
                    templateUrl: 'views/group/groupPage.html',
                    controller: 'GroupControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                 .when('/groups/:groupId/dialogs', {
                    templateUrl: 'views/group/groupDialogList.html',
                    controller: 'GroupControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                .when('/groups/:groupId/dialogs/:dialogId', {
                    templateUrl: 'views/group/groupDialogMessages.html',
                    controller: 'GroupControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                .when('/groups/:groupId/dialogs/:dialogId', {
                    templateUrl: 'views/group/groupDialogMessages.html',
                    controller: 'GroupControler',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                 .when('/search/group', {
                    templateUrl: 'views/group/searchGroup.html',
                    controller: 'SearchController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
                
                
                 .when('/search/users', {
                    templateUrl: 'views/group/searchUsers.html',
                    controller: 'SearchController',
                    data: {
                        authorizedRoles: [USER_ROLES.user]
                 }
                })
            
                .otherwise({
                	 redirectTo: '/home'
                });
    }]);
        /*  $stateChangeStart - ui-router    $locationChangeStart  - ng-route   */
myApp.run(function ($rootScope, AUTH_EVENTS, AuthService) {
	  $rootScope.$on('$locationChangeStart', function (event, next) {
	    var authorizedRoles = next.data.authorizedRoles;
	    if (!AuthService.isAuthorized(authorizedRoles)) {
	      event.preventDefault();
	      if (AuthService.isAuthenticated()) {
	        // user is not allowed
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
	      } else {
	        // user is not logged in
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
	      }
	    }
	  });
	})   
	

	

