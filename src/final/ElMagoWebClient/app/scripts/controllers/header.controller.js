'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:HeaderCtrl
 * @description
 * # HeaderCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('HeaderCtrl', function ($scope, $location) {
        $scope.isActive = function (viewLocation) {
            return viewLocation === $location.path();
        };
    });
