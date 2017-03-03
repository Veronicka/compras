angular.module("myApp").directive("carouselDir", function(){
	return{
		templateUrl: "app/view/carousel.html",
		replace: true,
		restrict: "E",
		transclude: true,
		controller: function($scope, AppApi){
			var list = [];
			$scope.m ={
					carousel: [],
					item: "item"
			}
			function addSlide(){
			  for (var i = 0; i < 3; i++) {
				    $scope.m.carousel = list[i];
				}
			};
			
			function getAll() {
				AppApi.getAll().then(function(response) {
					list = response.data;
		    		addSlide();
		        }, function (error) {
		            console.log(error.data)  
		        }).finally(function () {});
			};
			
			getAll();
		}
	};
});