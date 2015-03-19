'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:OrderlistControllerCtrl
 * @description
 * # OrderlistControllerCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('OrderListCtrl', [ '$scope', 'OrderService', function ($scope, OrderService) {
        $scope.orders = [];

        var setOrders = function (orders) {
            $scope.orders = orders;
        };

        OrderService.getOrders(setOrders);

    }]);
