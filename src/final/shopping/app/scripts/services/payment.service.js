'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.Payment.Service
 * @description
 * # Payment.Service
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('PaymentService',['$resource', 'ServerService', function ($resource, ServerService) {

        this.getPaymentMethods = function() {
            return $resource(ServerService.getBaseUrl() + '/payment').query();
        };

        this.pay = function(order, success, error) {
            $resource(ServerService.getBaseUrl() + '/payment/' + order.id)
                .save(order.paymentMethod, success, error);
        };

    }]);
