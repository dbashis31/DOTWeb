
/**
 * User controller
 */
var userApp = angular.module("userApp", ['dot.services.user']);

userApp.controller("UserCtrl", function($scope,User) {
	
	
	$scope.save = function() {
		//alert($scope.user);
        var res=User.save($scope.user);
        
        res.success(function(data, status, headers, config) {
			$scope.message = data.message;
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
    };
});

userApp.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);