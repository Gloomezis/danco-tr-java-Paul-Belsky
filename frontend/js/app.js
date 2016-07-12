'use strict';

var socialNetworkApp = angular
    .module('socialNetworkApp', ['ngRoute', 'ui.bootstrap','pascalprecht.translate','angular-loading-bar', 'ui-notification', 'infinite-scroll', 'angularMoment'])
    .constant({
        'BASE_URL': 'http://localhost:8080/restController',
        'PAGE_SIZE': '5'
    })
    .config(function ($routeProvider, cfpLoadingBarProvider) {

        cfpLoadingBarProvider.includeSpinner = false;

        $routeProvider
            .when('/', {
                templateUrl: 'templates/home.html',
               
                }
            )
            .when('/me', {
                templateUrl: 'templates/userProfile.html',
                controller: 'UserProfileController',
                resolve: {
                    isLoggedIn: isLoggedIn,
                    getUserFullData: function (authService, userService, $route) {
                        if (authService.isLoggedIn()) {
                            return userService.getDataAboutUser(authService.getCurrentUser().id)
                        }
                    }
                }
            })

            .when('/users/:username', {
                templateUrl: 'templates/userProfile.html',
                controller: 'UserProfileController as uc',
                resolve: {
                    isLoggedIn: isLoggedIn,
                    getUserFullData: function (authService, userService, $route) {
                        if (authService.isLoggedIn()) {
                            return userService.getDataAboutUser($route.current.params.username)
                        }
                    }
                }
            })
            .when('/profile', {
                templateUrl: 'templates/editProfileForm.html',
                controller: 'EditProfileController',
                resolve: {
                    isLoggedIn: isLoggedIn,
                    userData: function (authService, userService) {
                        if (authService.isLoggedIn()){
                            return userService.getDataAboutMe();
                        }
                    }
                }
            })
            .when('/profile/password', {
                templateUrl: 'templates/changePasswordForm.html',
                controller: 'ChangePasswordController',
                resolve: {
                    isLoggedIn: isLoggedIn,
                    userData: function (authService, userService) {
                        if (authService.isLoggedIn()){
                            return userService.getDataAboutMe();
                        }
                    }
                }
            })
            .when('/followers', {
                templateUrl: 'templates/followers.html',
                controller: 'FriendsController',
                resolve: {
                    isLoggedIn: isLoggedIn
                }
            })
            .when('/followings', {
                templateUrl: 'templates/followings.html',
                controller: 'FriendsController',
                resolve: {
                    isLoggedIn: isLoggedIn
                }
            })
            .when('/messages', {
                templateUrl: 'templates/messages.html',
                controller: 'MessagesController',
                resolve: {
                    isLoggedIn: isLoggedIn
                }
            })
             .when('/messages/:userid', {
                templateUrl: 'templates/messagesOneUser.html',
                controller: 'MessagesController',
                resolve: {
                    isLoggedIn: isLoggedIn
                }
            })
           
            .when('/news', {
                templateUrl: 'templates/news.html',
                controller: 'PostsController',
                resolve: {
                    isLoggedIn: isLoggedIn
                }
            })
             .when('/settings', {
                templateUrl: 'templates/settings.html',
            })
              .when('/groups/:groupId/dialogs', {
                templateUrl: 'templates/dialogs.html',
                controller: 'DialogsController',
                resolve: {
                 isLoggedIn: isLoggedIn//,
                }
            })
            .when('/groups', {
                templateUrl: 'templates/groups.html',
                controller: 'GroupsController',
                resolve: {
                    isLoggedIn: isLoggedIn,
                    dataGroups: function (authService, groupsService) {
                       if (authService.isLoggedIn()){
                          return groupsService.getGroups();
                        }
                   }
                }
            })

            .when('/posts/:postId/comments', {
                templateUrl: 'templates/comment.html',
                controller: 'CommentsController',
                resolve: {
                    isLoggedIn: isLoggedIn     
                }
            })
            .when('/groups/:groupId/dialogs/:dialogId/messages', {
                templateUrl: 'templates/dialogMessages.html',
                controller: 'DialogMessagesController',
                resolve: {
                    isLoggedIn: isLoggedIn     
                }
            })
            .otherwise({
                redirectTo: '/'
            });
    });

var isLoggedIn = function ($location, authService, Notification) {
    if (!authService.isLoggedIn()) {
        $location.path('/');
        Notification.info("You don't have access here.");
    }
};