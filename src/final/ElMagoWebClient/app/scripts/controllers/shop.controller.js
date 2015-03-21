'use strict';

/**
 * @ngdoc function
 * @name shoppingApp.controller:ShopctrlCtrl
 * @description
 * # ShopctrlCtrl
 * Controller of the shoppingApp
 */
angular.module('shoppingApp')
    .controller('ShopCtrl', [ '$scope', 'Offers', 'Products', 'CartService', 'CategoryService',
        function ($scope, Offers, Products, CartService, CategoryService) {

            var setProducts = function (products) {
                $scope.products = products;
            };

            var setOffers = function (offers) {
                $scope.offers = offers;
            };

            var setCategories = function (categories){
                $scope.categories = categories;
            };

            Products.query(setProducts);

            Offers.query(setOffers);

            CategoryService.query(setCategories);

            $scope.addProductToCart = function (id) {
                CartService.addProduct(id);
            };

            $scope.addOfferToCart = function (id) {
                CartService.addOffer(id)
            };

            $scope.getCartOffer = function (offer) {
                return CartService.getCart().offers['' + offer.id];
            };

            $scope.getCartProduct = function (product) {
                return CartService.getCart().products['' + product.id];
            };

            $scope.name = '';

            $scope.search = function (name) {
                Products.search(name, setProducts);

                Offers.search(name, setOffers);
            };

            $scope.searchByCategory = function (category) {
                Offers.searchByCategory(category, setOffers);

                Products.searchByCategory(category, setProducts);
            };

        }]);
