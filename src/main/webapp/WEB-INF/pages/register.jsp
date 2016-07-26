<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>DOT | Register</title>

    <link href="<c:url value="/resources/css/plugins/iCheck/custom.css" />" rel="stylesheet">
 
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<!-- Mainly scripts -->
    <script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/js/icheck.min.js" />"></script>
    <script src="<c:url value="/resources/js/common.js" />"></script>
    <script src="<c:url value="/resources/js/register.js" />"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
     <script src="<c:url value="/resources/js/services/user.js" />"></script>
    <script src="<c:url value="/resources/js/controllers/registerUser.js" />"></script>
   
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">DOT</h1>

            </div>
            
            <h3>Register to DOT</h3>
            <p>Create account to see it in action.</p>
            <div ng-app="userApp" ng-controller="UserCtrl">
            {{message}} 
            <form class="m-t" role="form" action="login.html" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Name" required="" ng-model="user.userName">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Email" required="" ng-model="user.emailID">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required="" ng-model="user.password">
                     <input type="file" class="form-control" id="file" name="file" required="" file-model="user.myfile">
                </div>
                <div class="form-group">
                        <div class="checkbox i-checks"><label class=""> <div class="icheckbox_square-green" style="position: relative;"><input type="checkbox" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins></div><i></i> Agree the terms and policy </label></div>
                </div>
               
                <button type="button" ng-click="save()" class="btn btn-primary block full-width m-b">Register</button>

                <p class="text-muted text-center"><small>Already have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="login.html">Login</a>
            </form>
            </div>
            <p class="m-t"> <small>Copyright © 2001- 2015 Stubs & Stacks. All Rights Reserved.</small> </p>
        </div>
    </div>

    



</body></html>