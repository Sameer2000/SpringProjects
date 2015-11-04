testModule.service('RestService', ['$resource', function ($resource) {
	return $resource('rest', {}, {
		getSales : {
			method : 'GET',
			url : '/sales',
			isArray : true
		},
	});
}]);

