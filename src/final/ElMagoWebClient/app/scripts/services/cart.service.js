'use strict';

/**
 * @ngdoc service
 * @name shoppingApp.cart
 * @description
 * # cart
 * Service in the shoppingApp.
 */
angular.module('shoppingApp')
    .service('CartService', [ '$resource', '$location', 'ServerService', 'OrderService', '$sessionStorage',
        function ($resource, $location, ServerService, OrderService, $sessionStorage) {

            this.$storage = $sessionStorage.$default({
                cart : {
                    'offers': {},
                    'products': {},
                    'total': 0
                }
            });

            this.initializeCart = function () {
                this.$storage.cart = {
                    'offers': {},
                    'products': {},
                    'total': 0
                };
            };

            this.getCart = function () {
                return this.$storage.cart;
            };

            var self = this;
            this.setCart = function (cart) {
                self.$storage.cart = cart;
            };

            this.get = function () {
                $resource(ServerService.getBaseUrl() + '/customer/cart').get({}, this.setCart);
            };

            this.save = function () {
                $resource(ServerService.getBaseUrl() + '/customer/cart').save(this.convertCart(this.$storage.cart));
            };

            this.sendOrder = function (paymentType) {
                var order = OrderService.buildOrder(this.convertCart(this.getCart()), paymentType);

                console.log('Order sent: ', order);

                $resource(ServerService.getBaseUrl() + '/orders').save(order,
                    function (confirmedOrder) {
                        $location.path('/checkout/' + confirmedOrder.id);
                    });

            };

            this.addProduct = function (product) {
                var productId = '' + product.id;

                if (this.$storage.cart.products[productId])
                    this.$storage.cart.products[productId].quantity++;
                else {
                    this.$storage.cart.products[productId] = product;
                    this.$storage.cart.products[productId].quantity = 1;
                }

                this.updateCartTotal();
            };

            this.addOffer = function (offer) {
                var offerId = '' + offer.id;

                if (this.$storage.cart.offers[offerId])
                    this.$storage.cart.offers[offerId].quantity++;
                else {
                    this.$storage.cart.offers[offerId] = offer;
                    this.$storage.cart.offers[offerId].quantity = 1;
                }

                this.updateCartTotal();
            };

            this.removeProduct = function (product) {
                var productId = '' + product.id;

                if (this.$storage.cart.products[productId])
                    this.$storage.cart.products[productId].quantity =
                        Math.max(this.$storage.cart.products[productId].quantity - 1, 0);

                this.updateCartTotal();
            };

            this.removeOffer = function (offer) {
                var offerId = '' + offer.id;

                if (this.$storage.cart.offers[offerId])
                    this.$storage.cart.offers[offerId].quantity = Math.max(this.$storage.cart.offers[offerId].quantity - 1, 0);

                this.updateCartTotal();
            };

            this.updateCartTotal = function () {
                var total = 0;

                angular.forEach(this.$storage.cart.products, function (value, i) {
                    total += value.price * value.quantity;
                });


                angular.forEach(this.$storage.cart.offers, function (value, i) {
                    total += value.price * value.quantity;
                });

                this.$storage.cart.total = total;
            };


            this.convertCart = function (cart) {
                var newCart = {
                    'offers': [],
                    'products': []
                };

                // Convert products to id -> qty
                angular.forEach(cart.products, function (value, index) {
                    for (var i = 0; i < value.quantity; i++)
                        newCart.products.push({ "id": parseInt(index) });
                });

                // Convert offers to id -> qty
                angular.forEach(cart.offers, function (value, index) {
                    for (var i = 0; i < value.quantity; i++)
                        newCart.offers.push({ "id": parseInt(index) });
                });

                return newCart;
            };

        }]);
