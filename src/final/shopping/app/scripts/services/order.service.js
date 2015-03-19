'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.order
 * @description
 * # order
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('OrderService', ['$resource', 'ServerService', function ($resource, ServerService) {

        this.getOrder = function(orderId, callback) {
            $resource(ServerService.getBaseUrl() + '/orders/' + orderId).get({}, callback);
        };

        this.buildOrder = function (cart, paymentType) {
            var order = {};

            order['cart'] = cart;

            order['paymentType'] = paymentType;

            return order;
        };

        this.getOrders = function (callback) {
            $resource(ServerService.getBaseUrl() + '/orders').query({}, callback);
        };


    }]);
