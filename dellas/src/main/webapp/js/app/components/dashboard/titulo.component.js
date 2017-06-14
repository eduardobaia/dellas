angular.
  module('cnv-web').
  component('titulo', {
    templateUrl:'templates/titulo.html',
    controller: function TituloController() {
    },
    bindings: {
        param: '@'
    }
  });