'use strict';

/**
 * @ngdoc overview
 * @name shoppingApp
 * @description
 * # shoppingApp
 *
 * Main module of the application.
 */
angular
    .module('shoppingApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ngStorage'
    ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/home', {
                title: 'Inicio',
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/cart', {
                title: 'Carrito',
                templateUrl: 'views/cart.html',
                controller: 'CartCtrl'
            })
            .when('/shop', {
                title: 'Productos',
                templateUrl: 'views/shop.html',
                controller: 'ShopCtrl'
            })
            .when('/login', {
                title: 'Iniciar sesión',
                templateUrl: 'views/login.html',
                controller: 'LoginCtrl'
            })
            .when('/checkout/:orderId', {
                title: 'Orden',
                templateUrl: 'views/order.html',
                controller: 'OrderCtrl'
            })
            .when('/orderList', {
                title: 'Órdenes',
                templateUrl: 'views/orderlist.html',
                controller: 'OrderListCtrl'
            })
            .otherwise({
                redirectTo: '/home'
            });
    })
    .run(['$location', '$rootScope', function ($location, $rootScope) {
        $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
            $rootScope.title = current.$$route.title;
        });
    }]);