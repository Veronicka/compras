angular.module("myApp").controller("homeCtrl", function($scope, $http, AppApi){
	
	$scope.m = {
		list: [],
		hi: 'Bem Vindo',
		error: '',
	}
	
	
	function findList() {
		AppApi.getAll().then(function(response) {
    		if(response.data === []){
    			$scope.m.error = "Não há produtos.";
    		}
    		$scope.m.list = response.data;
    		console.log(response.data);
        }, function (error) {
        	$scope.m.error = error.data;
        }).finally(function () {});
	};
	
	findList();
 
});