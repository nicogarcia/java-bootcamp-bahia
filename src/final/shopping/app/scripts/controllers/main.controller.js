'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('MainCtrl', function ($scope) {
        $scope.products = [
            'product1',
            'product2',
            'product3'
        ];
    });
