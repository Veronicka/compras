angular.module("myApp").factory("carrinhoService", function($http, config, AppApi){
	
	var getProduto = function (nome){
		AppApi.getByName(nome).then(function(response) {
			console.log(response.data);
			return response;
        }, function (error) {
        	console.log(error.data);
        }).finally(function () {});
	};
	
	return getProduto;
});