testModule.controller('FirstController', ['$scope', function ($scope) {
	console.log('first controller loaded');
	
	 $scope.labels = ['Monthly Sales', 'In-Store Sales', 'Online Sales'];
	    $scope.data = [400, 500, 300];
	
}]);

