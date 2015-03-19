'use strict';

describe('Controller: OrderlistControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('shoppingApp'));

  var OrderlistControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    OrderlistControllerCtrl = $controller('OrderlistControllerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
