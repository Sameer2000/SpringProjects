var testModule = angular.module('testModule', ['ngRoute', 'ngResource', 'chart.js']);

testModule.config(['$routeProvider', 'ChartJsProvider', function ($routeProvider, ChartJsProvider) {
//	Angular Chart Configuration
	
	ChartJsProvider.setOptions({
	    colours: ['#97BBCD', '#DCDCDC', '#F7464A', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360'],
	    responsive: true
	});
    // Configure all doughnut charts
    ChartJsProvider.setOptions('Doughnut', {
      animateScale: false
    });
	
//    RouteProvider Configuration
	$routeProvider.when('/chart', {
			templateUrl : '/resources/templates/chart.jsp',
			controller : 'ChartController'
	})
	.otherwise({redirectTo : '/'});
	
}]);