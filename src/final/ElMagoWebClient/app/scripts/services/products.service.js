'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.products
 * @description
 * # products
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('Products', [ '$resource', 'ServerService', function ($resource, ServerService) {
        this.query = function (callback) {
            return $resource(ServerService.getBaseUrl() + '/products').query({}, callback);
        };

        this.search = function (name, callback) {
            if (name.length == 0)
                return this.query(callback);

            return $resource(ServerService.getBaseUrl() + '/products/search/' + name).query({}, callback);
        };

        this.searchByCategory = function (category, callback) {
            if (!category)
                return this.query(callback);

            return $resource(ServerService.getBaseUrl() + '/products/search/category/' + category.name).query({}, callback);
        };
    }])
    .service('Offers', [ '$resource', 'ServerService', function ($resource, ServerService) {
        this.query = function (callback) {
            return $resource(ServerService.getBaseUrl() + '/offers').query({}, callback);
        };

        this.search = function (name, callback) {
            if (name.length == 0)
                return this.query(callback);

            return $resource(ServerService.getBaseUrl() + '/offers/search/' + name).query({}, callback);
        };

        this.searchByCategory = function (category, callback) {
            if (!category)
                return this.query({}, callback);

            return $resource(ServerService.getBaseUrl() + '/offers/search/category/' + category.name).query({}, callback);
        };

    }]);

