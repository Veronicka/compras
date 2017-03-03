angular.module("myApp").controller("carCtrl", function($scope, $http, AppApi, $location, $sessionStorage){
	$scope.m='';
	$scope.total=0;
	$scope.products = $sessionStorage.list;
	var p;
	
	function sum(){
		var t = 0
		for (var i = 0; i < $scope.products.length; i++) {
			t = t + ($scope.products[i].price);
		}
		$scope.total = t;
	}
	
	function init(){
		console.log($scope.products);
		if($scope.products === [] || $scope.products === undefined){
			$scope.m.error = "Seu carrinho está vazinho";
		}
		$scope.m.error = '';
		
		sum();
	}
	
	$scope.buy = function(){
		for (var i = 0; i < $scope.products.length; i++) {
			AppApi.remove($scope.products[i].id).then(function(response) {
				$location.path('/buy');
	        }, function (error) {
	        	return error.data;
	        }).finally(function () {});
		}
	}
	
	$scope.removeCar = function(produto){
		console.log(produto);
		if($scope.products === [] || $scope.products === undefined){
			$scope.m.error = "Seu carrinho está vazinho";
		}
		for (var i = 0; i < $scope.products.length; i++) {
			if(produto.id === $scope.products[i].id)
				$scope.products.splice(i, 1);
		}
		
		sum();
	}
	
	function getById(id){
		AppApi.getById(id).then(function(response) {
			p = response.data;
        }, function (error) {
        	return error.data;
        }).finally(function () {});
	};
	
	
	$scope.addQ = function(produto){
		$scope.m.quant = 80;
		console.log(p);
	}
	
	$scope.removeQ = function(produto){
		getById(produto.id);
		console.log(p);
	}
	
	init();
});