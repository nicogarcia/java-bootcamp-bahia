'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.server
 * @description
 * # server
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('ServerService', function () {
        var BASE_URL = 'http://localhost:8080';

        this.getBaseUrl = function () {
            return BASE_URL;
        };
    });
