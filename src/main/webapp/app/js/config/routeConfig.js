angular.module("myApp").config(function($routeProvider){
	$routeProvider.when("/home", {
		templateUrl: "app/view/home.html",
		controller: "homeCtrl"
	});
	$routeProvider.when("/car", {
		templateUrl: "app/view/car.html",
		controller: "carCtrl"
	});
	$routeProvider.when("/buy", {
		templateUrl: "app/view/buy.html",		
	});
	$routeProvider.when("/product/:name", {
		templateUrl: "app/view/product.html",
		controller: "productCtrl"		
	});
	
	$routeProvider.otherwise({redirectTo: "/home"});
});