'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:CartctrlCtrl
 * @description
 * # CartctrlCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
  .controller('CartCtrl', function ($scope, CartService, PaymentService) {

        $scope.cart = CartService.getCart();

        $scope.availablePaymentMethods = PaymentService.getPaymentMethods();

        $scope.paymentType = '';

        $scope.addOffer = function (id) {
            CartService.addOffer(id);
        };

        $scope.removeOffer = function (id) {
            CartService.removeOffer(id);
        };

        $scope.addProduct = function (id) {
            CartService.addProduct(id);
        };

        $scope.removeProduct = function (id) {
            CartService.removeProduct(id);
        };

        $scope.saveCart = function () {
            CartService.save();
        };

        $scope.loadCart = function () {
            CartService.get();
        };

        $scope.sendOrder = function () {
            CartService.sendOrder($scope.paymentType.type);
        };

    });
