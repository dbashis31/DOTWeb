/**
 * User service
 */
angular.module('dot.services.processGroup',[]).factory('ProcessGroup',['$http', function($http) {
	
	var ProcessGroup = {};
	
	ProcessGroup.runningProcessGroup = function(){		
		var res = $http.get('ProcessGroupService/runningProcessGroup');
		return res;
	};
	
	ProcessGroup.completionStatus = function(groupId){	
		var res = $http.get('ProcessGroupService/completionStatus?groupId=' + groupId);
		return res;
	};
	
	return ProcessGroup;
}]);