'use strict';

socialNetworkApp.factory('dialogsService',['$http', '$q', 'BASE_URL','$routeParams',
    function dialogsService($http, $q, BASE_URL,$routeParams) {


        

        var serviceUrl = BASE_URL + '/groups/';

        return {
            getDialogs: function (pageSize, lastDialogId) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs?StartDialogId='+lastDialogId+'&PageSize=' + pageSize;

                var deferred = $q.defer();
                $http.get(url)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },
            


            addDialog: function (dialogData) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs';

                var deferred = $q.defer();
                $http.post(url, dialogData)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            },
            deleteDialog: function (dialogId) {
                var url = serviceUrl + $routeParams.groupId + '/dialogs/'+ dialogId ;

                var deferred = $q.defer();
                $http.delete(url)
                .success(function (data) {
                    deferred.resolve(data);
                })
                .error(function (error) {
                    deferred.reject(error)
                });

                return deferred.promise;
            }
        }

    }]);




