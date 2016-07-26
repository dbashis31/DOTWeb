/**
 * User service
 */
angular.module('dot.services.notification',[]).factory('Notification',['$http', function($http) {
	var Notification = {};
	Notification.findLatestFive = function(){		
		var res = $http.get('NotificationService/findLatestFive');
		return res;
	};
	Notification.findAll = function(){		
		var res = $http.get('NotificationService/findAll');
		return res;
	};
	Notification.findByID = function(id){		
		var res = $http.get('NotificationService/findAll',id);
		return res;
	};
	Notification.countNotification = function(){		
		var res = $http.get('NotificationService/countNotification');
		return res;
	};
	return Notification;
}]);