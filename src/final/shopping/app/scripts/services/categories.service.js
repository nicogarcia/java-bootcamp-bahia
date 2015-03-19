'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.Categories.Service
 * @description
 * # Categories.Service
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
  .service('CategoryService', function ($resource, ServerService) {
        this.query = function (callback) {
            return $resource(ServerService.getBaseUrl() + "/category").query({}, callback);
        };
  });
