testModule.controller('ChartController', ['$scope', '$http', 'RestService', '$location', function ($scope, $http, RestService, $location) {
	
	 $scope.labels = ['Monthly Sales', 'In-Store Sales', 'Online Sales'];
	 $scope.data = [];   
	 console.log($location.path());

	 	/**
	 	 * $http method to get the sales from spring controller.
	 	 */
	    $scope.getSales = function(){
	    	$http.get('/sales').success(function(response, status, header, config){
				angular.forEach(response, function(value, index){
					$scope.data.push(value.amount);
				});
			});
	    }
	    
	    /**
	     * $resource method service to get the response as rest api.
	     */
	    $scope.restSales = function(){
	    	RestService.getSales(function(response){
	    		angular.forEach(response, function(value, index){
	    			$scope.data.push(value.amount);
	    		});
	    		//$location.path('/')
	    	});
	    }
	    
}]);

