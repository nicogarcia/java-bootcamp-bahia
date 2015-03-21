'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.Login.Service
 * @description
 * # Login.Service
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('LoginService', [ '$resource', '$http', 'ServerService', '$sessionStorage', 'CartService',
        function ($resource, $http, ServerService, $sessionStorage, CartService) {

            this.$storage = $sessionStorage;

            this.isAuthenticated = function () {
                var token = $sessionStorage.token;

                if(!token)
                    return false;

                $http.defaults.headers.common['Authorization'] = 'Bearer ' + token;

                return true;
            };

            var self = this;

            this.login = function (user) {

                var loginResource = $resource(ServerService.getBaseUrl() + '/oauth/token', {},
                    {
                        login: {
                            method: 'POST',
                            params: {
                                'username': user.username,
                                'password': user.password,
                                'client_id': 'CLIENT_ID',
                                'grant_type': 'password'
                            }
                        }
                    });

                loginResource.login(
                    function (response) {
                        var token = response['access_token'];

                        if (token) {
                            self.$storage.token = token;
                        }
                    }
                );
            };

            this.logout = function () {
                delete this.$storage.token;

                $http.defaults.headers.common['Authorization'] = '';

                CartService.initializeCart();
            };

            this.register = function (user) {
                var callback = function (response) {
                    alert(response);
                };

                $resource(ServerService.getBaseUrl() + '/customer/register').save(user, callback);
            };
        }]);
