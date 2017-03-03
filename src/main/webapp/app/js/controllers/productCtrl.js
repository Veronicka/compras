angular.module("myApp").controller("productCtrl", function($scope, $http, AppApi, $route, $location, $sessionStorage){
	
	$scope.m={
		id: '',
		img: '',
		description: '',
		price: ''
	}
	
	function getProduto (){
		AppApi.getByName($route.current.params.name).then(function(response) {
			var product = response.data;
			$scope.m.id = product.id;
			$scope.m.img = product.img;
			$scope.m.description = product.descricao;
			$scope.m.price = product.preco;
			
        }, function (error) {
        	console.log(error.data);
        }).finally(function () {});
	};
	
	$scope.addCar = function(){
		if($sessionStorage.list === undefined){
			$sessionStorage.list = [];
		}
		$sessionStorage.list.push($scope.m);
		$location.path('/car');
	}	
	
	getProduto();
 
});