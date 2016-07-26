<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!-- saved from url=(0062)dashboard_4_1.html -->
<html ng-app="dotApp" ng-controller="uniqueKeySchemaController">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>DOT</title>

<script
	src="<c:url value="/resources/js/services/optimizationStat.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dotApp.js" />"></script>

</head>

<body class="pace-done">
	<div ng-view>
		<div class="row wrapper border-bottom white-bg page-heading">
			<div class="col-lg-10">
				<div style="height: 10px"></div>
				<ol class="breadcrumb">
					<li>Rationalization</li>
					<li><a ui-sref="home.optimize">Optimize</a></li>
					<li><a ui-sref="home.key">Unique Key</a></li>
					<li class="active"><strong>{{databaseName}}</strong></li>
				</ol>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="wrapper wrapper-content">

			<div class="row">

				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<div class="row">
								<div class="col-sm-9 m-b-xs" style="margin-top: 10px">
									<h5>Schemas</h5>
								</div>
								<div class="col-sm-3">
									<div class="input-group">
										<input type="text" placeholder="Search"
											class="input-sm form-control"> <span
											class="input-group-btn">
											<button type="button" class="btn btn-sm btn-primary">
												Go!</button>
										</span>
									</div>
								</div>
							</div>

						</div>
						<div class="ibox-content">

							<div class="table-responsive">
								
								<div ag-grid="gridOptions" style="width: 100%; height: 700px; " 						
								class="ag-fresh" ></div>

							</div>
						</div>
						<!-- end view -->
					</div>
				</div>
			</div>
		</div>
</body>
</html>