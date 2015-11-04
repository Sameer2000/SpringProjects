testModule.controller('ChartController', ['$scope', '$http', function ($scope, $http) {
	console.log('first controller loaded');
	
	 $scope.labels = ['Monthly Sales', 'In-Store Sales', 'Online Sales'];
	    $scope.data = [400, 500, 300];
	    
	    $scope.sales = 'Sales';
	    
	    
	    $scope.getSales = function(){
	    	console.log('ijn method');
	    	$http('/sales').success(function(data){
	    		console.log(data);
	    	});
	    }
	
}]);

