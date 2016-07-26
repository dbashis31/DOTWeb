<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!-- saved from url=(0062)dashboard_4_1.html -->
<html ng-app="dotApp" ng-controller="indexController">
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
					<li class="active"><strong>Index</strong></li>
				</ol>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="wrapper wrapper-content">

			<div class="row">
				<div style="height: 4px"></div>
				<div class="col-md-2">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<span class="label label-success pull-right"><i
								class="fa fa-database"></i></span>
							<h5>Databases</h5>
						</div>
						<div class="ibox-content"">
							<h1 class="no-margins">{{databaseCount}}</h1>
							<small>Databases has column index optimization scope </small>

						</div>
					</div>
				</div>
				<div class="col-md-2">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<span class="label label-info pull-right"><i
								class="fa fa-database"></i></span>
							<h5>Schemas</h5>
						</div>
						<div class="ibox-content">
							<h1 class="no-margins">{{schemaCount}}</h1>
							<small>Schemas has column index optimization scope</small>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<span class="label label-primary pull-right"><i
								class="fa fa-database"></i></span>
							<h5>Tables & Columns</h5>
						</div>
						<div class="ibox-content" style="height: 123px;">

							<div class="row">
								<div class="col-md-6">
									<h1 class="no-margins">{{tableCount}}</h1>
									<div class="font-bold text-navy">
										<small>Tables has column index optimization scope</small>
									</div>
								</div>
								<div class="col-md-6">
									<h1 class="no-margins">{{columnCount}}</h1>
									<div class="font-bold text-navy">
										<small>Columns has column index optimization scope</small>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<span class="label label-info pull-right"><i
								class="fa fa-database"></i></span>
							<h5>Status</h5>
						</div>
						<div class="ibox-content" style="height: 123px;">
							<h2>{{optimizationStatus}}%</h2>
							<div class="progress progress-mini">
								<div style="width: {{optimizationStatus}}%" class="progress-bar"></div>
							</div>

							<div class="m-t-sm small">Column Index Optimized</div>
						</div>
					</div>

				</div>

			</div>

			<div class="row">

				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<div class="row">
								<div class="col-sm-9 m-b-xs" style="margin-top: 10px">
									<h5>Databases</h5>
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
								<div ag-grid="gridOptions" style="width: 100%; height: 400px;"
									class="ag-fresh"></div>
							</div>
						</div>
						<!-- end view -->
					</div>
				</div>
			</div>
		</div>
</body>
</html>