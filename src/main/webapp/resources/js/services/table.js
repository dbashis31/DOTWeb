/**
 * User service
 */
angular.module('dot.services.table',[]).factory('Table',['$http', function($http) {
	var Table = {};
	Table.countTable = function(){		
		var res = $http.get('TableService/countTable');
		return res;
	};
	
	return Table;
}]);