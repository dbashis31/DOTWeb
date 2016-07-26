<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!-- saved from url=(0054)login.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>DOT | Login</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div style="text-align: left;">

                <h1 class="logo-name">DOT</h1>

            </div>
            <h3>Welcome to DOT</h3>
            <p>Database Optimization Tool</p>
            <p>Login in. To see it in action.
			<c:if test="${not empty error}">
			<div class="error" style="color: red;">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
			</p>
            <form class="m-t" name="loginForm" role="form" action="<c:url value='/login'  />" method='POST'>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Username" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password" required="">
                </div>
                <input name="submit" type="submit"
						value="Login"  class="btn btn-primary block full-width m-b">

                <a href="login.html#"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="registerPage">Create an account</a>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
            </form>
            <p class="m-t"> <small>Copyright © 2001- 2015 Stubs & Stacks. All Rights Reserved.</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    
    
    
    <script src="js/bootstrap.min.js"></script>




</body></html>