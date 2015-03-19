'use strict';

describe('Controller: PaysuccessControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('shoppingApp'));

  var PaysuccessControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaysuccessControllerCtrl = $controller('PaysuccessControllerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
