/**
 * User service
 */
angular.module('dot.services.user',[]).factory('User',['$http', function($http) {
	var User = {};
	User.save = function(user){		
		
		// Writing it to the server
		//
		alert(user.myfile);
		alert(user.userName);
		var dataObj = user;
		var uadata=[];
		 var ua ={
			  "userName": "sss",
			  "emailID": "22#@dg.com",
			  "password": "sssss"
			 
			};
		 
		 var uac ={
				  "userName": "dsssseba",
				  "emailID": "22#ssssss@dg.com",
				  "password": "sssssssssss"
				 
				};

		 uadata.push(ua);
		 uadata.push(uac);
	
		var res =  $http({
            method: 'POST',
            url: "UserService/Save/unprotected",
            //IMPORTANT!!! You might think this should be set to 'multipart/form-data' 
            // but this is not true because when we are sending up files the request 
            // needs to include a 'boundary' parameter which identifies the boundary 
            // name between parts in this multi-part request and setting the Content-type 
            // manually will not set this boundary parameter. For whatever reason, 
            // setting the Content-type to 'false' will force the request to automatically
            // populate the headers properly including the boundary parameter.
            headers: { 'Content-Type': undefined },
            //This method will allow us to change how the data is sent up to the server
            // for which we'll need to encapsulate the model data in 'FormData'
            transformRequest: function (data) {
                var formData = new FormData();
                //need to convert our json object to a string version of json otherwise
                // the browser will do a 'toString()' on the object which will result 
                // in the value '[Object object]' on the server.
               
                    //add each file to the form data and iteratively name them
                    formData.append("ua",angular.toJson(data.ua));
                    formData.append("file",data.file);
                
                return formData;
            },
            //Create an object that contains the model and files which will be transformed
            // in the above transformRequest method
            data: { "ua": uadata, "file" : user.myfile }
        });
		
		return res;
		// Making the fields empty
		//
		
		
	};
	return User;
}]);