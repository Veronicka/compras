angular.module('myApp').factory('AppApi', function(RestApi, config) {
    var api;
    api = {
      getAll: function() {
        return RestApi.get(config.baseUrl + '/getAll');
      },
      getById: function(id) {
        return RestApi.get(config.baseUrl + '/getById?id='+id);
      },
      getByName: function(nome) {
          return RestApi.get(config.baseUrl + '/getByName?nome='+nome);
        },
      remove: function(produto) {
          return RestApi.post(config.baseUrl + '/delete', produto);
        }
    };
    return api;
  });