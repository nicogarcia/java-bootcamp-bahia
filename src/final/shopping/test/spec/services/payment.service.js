'use strict';

describe('Service: Payment.Service', function () {

  // load the service's module
  beforeEach(module('shoppingApp'));

  // instantiate service
  var Payment.Service;
  beforeEach(inject(function (_Payment.Service_) {
    Payment.Service = _Payment.Service_;
  }));

  it('should do something', function () {
    expect(!!Payment.Service).toBe(true);
  });

});
