<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html ng-app="modalTest">
  <head>
    	<script src="http://code.angularjs.org/1.3.0/angular.min.js"></script>
		<script src="http://code.angularjs.org/1.3.0/angular-sanitize.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/bower-angular-translate/2.0.1/angular-translate.min.js"></script>
		<script src="<c:url value="/resources/js/dialog/ui-bootstrap-tpls-0.11.2.min.js" />"></script>
		<script src="<c:url value="/resources/js/dialog/dialogs-default-translations.min.js" />"></script>
		<script src="<c:url value="/resources/js/dialog/dialogs.min.js" />"></script>
		<script src="<c:url value="/resources/js/dialog/dialogTest.js" />"></script>
	
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/dialogs.css">
  
  </head>
  <body ng-controller="dialogServiceTest" class="pad">
    <h2>Bootstrap 3 & AngularJS Dialog/Modals</h2><br />
    <p>
      Demostration of my Angular-Dialog-Service module. Which can be found on Github: <a href="https://github.com/m-e-conroy/angular-dialog-service">https://github.com/m-e-conroy/angular-dialog-service</a><br />
    </p>
    <div class="row">
      <div class="col-md-12">
        <button class="btn btn-danger" ng-click="launch('error')">Error Dialog</button>
    
        <button class="btn btn-primary" ng-click="launch('wait')">Wait Dialog</button>
    
        <button class="btn btn-default" ng-click="launch('notify')">Notify Dialog</button>
    
        <button class="btn btn-success" ng-click="launch('confirm')">Confirm Dialog</button>
        
        <button class="btn btn-warning" ng-click="launch('create')">Custom Dialog</button>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-12">
        <p>
          <span class="text-info">From Confirm Dialog</span>: {{confirmed}}
        </p>
      </div>
    </div>
    <br />
    <div class="row">
      <div class="col-md-12">
        <p>
          <span class="text-info">Your Name</span>: {{name}}
        </p>
      </div>
    </div>
    <br />
    <p>
      <a href="http://michaeleconroy.blogspot.com/2013/10/redux-creating-application-dialog.html" target="_top"><strong>View My Blog Post</strong>: Redux: Creating an Application Dialog Service using AngularJS, Twitter Bootstrap & Angular UI-Bootstrap</a>
    </p>
    
  </body>
</html>