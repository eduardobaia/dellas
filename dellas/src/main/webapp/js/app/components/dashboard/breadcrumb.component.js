angular.
  module('cnv-web').
  component('breadcrumb', {
    templateUrl:'templates/breadcrumb.html',
    controller: function BreadcrumbController() {
    },
    bindings: {
        param: '@'
    }
  });