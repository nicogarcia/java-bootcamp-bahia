'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:LoginctrlCtrl
 * @description
 * # LoginctrlCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('LoginCtrl', [ '$scope', 'LoginService', '$location', function ($scope, LoginService, $location) {

        $scope.isAuthenticated = function () {
            return LoginService.isAuthenticated();
        };

        $scope.login = function (user) {
            LoginService.login(user);
        };

        $scope.logout = function() {
            LoginService.logout();

            $location.path('#/home');
        };

        $scope.register = function(user) {
            LoginService.register(user);
        };

    }]);
