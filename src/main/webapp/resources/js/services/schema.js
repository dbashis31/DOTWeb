/**
 * User service
 */
angular.module('dot.services.schema',[]).factory('Schema',['$http', function($http) {
	var Schema = {};
	Schema.countSchema = function(){		
		var res = $http.get('SchemaService/countSchema');
		return res;
	};
	
	
	return Schema;
}]);