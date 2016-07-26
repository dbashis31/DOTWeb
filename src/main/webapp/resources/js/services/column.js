/**
 * User service
 */
angular.module('dot.services.column',["agGrid"]).factory('Column',['$http', function($http) {
	var Column = {};
	Column.countColumn = function(){		
		var res = $http.get('ColumnService/countColumn');
		return res;
	};
	Column.columList = function(){
		var res=$http.get("http://localhost:8080/DOT/resources/js/grid/olympicWinners.json");
        return res;
	    }; 
	
	return Column;
}]);