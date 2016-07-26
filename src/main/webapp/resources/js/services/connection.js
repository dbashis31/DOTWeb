/**
 * User service
 */
angular.module('dot.services.connection',[]).factory('Connection',['$http', function($http) {
	var Connection = {};
	Connection.countConnection = function(){		
		var res = $http.get('ConnectionService/countConnection');
		return res;
	};
	Connection.findAll = function(){		
		var res = $http.get('ConnectionService/findAll');
		return res;
	};
	
	return Connection;
}]);