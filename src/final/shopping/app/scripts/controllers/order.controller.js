'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:OrderCtrl
 * @description
 * # OrderCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('OrderCtrl', ['$scope', 'OrderService', 'PaymentService', '$routeParams',
        function ($scope, OrderService, PaymentService, $routeParams) {

            $scope.order = {};

            var setOrder = function (order) {
                $scope.order = order;
            };

            OrderService.getOrder($routeParams.orderId, setOrder);

            $scope.pay = function () {
                var success = function (response) {
                    alert('Payment successful! Payment ID: ' + response.id);
                };

                var error = function (response) {
                    alert('Payment failed!');
                };

                PaymentService.pay($scope.order, success, error);
            };

        }]);
