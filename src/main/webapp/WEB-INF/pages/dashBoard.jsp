<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!-- saved from url=(0062)dashboard_4_1.html -->
<html ng-app="dotApp" ng-controller="DotCtrl" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>DOT</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- link href="<c:url value="/resources/font-awesome-4.4.0/css/font-awesome.min.cs" />" rel="stylesheet" -->

<!-- Morris -->
<link href="<c:url value="/resources/css/morris-0.4.3.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular-route.min.js"></script>
	
    <!-- you don't need ignore=notused in your code, this is just here to trick the cache -->
    <script src="<c:url value="/resources/js/grid/ag-grid.js?ignore=notused14" />"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/grid/ag-grid.css?ignore=notused14" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/grid/theme-fresh.css?ignore=notused14" />">
    
	
 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.8/angular-ui-router.min.js"></script>	
<script src="<c:url value="/resources/js/services/Notification.js" />"></script>
<script src="<c:url value="/resources/js/services/ProcessGroup.js" />"></script>
<script src="<c:url value="/resources/js/services/optimizationStat.js" />"></script>
<script src="<c:url value="/resources/js/services/sizeOptimizationStat.js" />"></script>
<script src="<c:url value="/resources/js/services/UniqueKeyOptimizationStat.js" />"></script>
<script src="<c:url value="/resources/js/services/indexOptimizationStat.js" />"></script>
<script src="<c:url value="/resources/js/services/similarity.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dotApp.js" />"></script>
<script src="<c:url value="/resources/js/controllers/scotchController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataTypeController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataTypeColumnController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataTypeSchemaController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataTypeTableController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataSizeController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataSizeSchemaController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataSizeTableController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/dataSizeColumnController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/UniqueKeyController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/uniqueKeySchemaController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/uniqueKeyTableController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/uniqueKeyColumnController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/indexController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/indexSchemaController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/indexTableController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/indexColumnController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/optimizationController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/schemaOptimizationController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/tableOptimizationController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/contextSimilarityController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/similarGroupSchemas.js" />"></script>
<script src="<c:url value="/resources/js/controllers/similarDatabaseController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/similarSchemaController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/similarTablesController.js" />"></script>
<script src="<c:url value="/resources/js/controllers/similarColumnsController.js" />"></script>

<script src="<c:url value="/resources/js/services/modal.js" />"></script>
<script src="<c:url value="/resources/js/services/column.js" />"></script>
<script src="<c:url value="/resources/js/services/connection.js" />"></script>
<script src="<c:url value="/resources/js/services/table.js" />"></script>
<script src="<c:url value="/resources/js/services/utility.js" />"></script>
<script src="<c:url value="/resources/js/services/schema.js" />"></script>
<script src="<c:url value="/resources/js/data/modalOptions.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.8.17.custom.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.jqtransform.js" />"></script>
<script src="<c:url value="/resources/js/jquery.peity.min.js" />"></script>
<script src="<c:url value="/resources/js/peity-demo.js" />"></script>
<link href="<c:url value="/resources/css/pmCompliance.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui-style-override.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui-1.8.17.custom.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/chartist.min.css" />"
	rel="stylesheet">
	
<script src="<c:url value="/resources/js/chartist.min.js" />"></script>	
<script src="<c:url value="/resources/js/jquery.sparkline.min.js" />"></script>
	

<style type="text/css">
.jqstooltip {
	position: absolute;
	left: 0px;
	top: 0px;
	visibility: hidden;
	background: rgb(0, 0, 0) transparent;
	background-color: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,
		endColorstr=#99000000);
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";
	color: white;
	font: 10px arial, san serif;
	text-align: left;
	white-space: nowrap;
	padding: 5px;
	border: 1px solid white;
	z-index: 10000;
}

.jqsfield {
	color: white;
	font: 10px arial, san serif;
	text-align: left;
}
</style>

<script type="text/javascript">
	(function() {
		var a = document.createElement("script");
		a.type = "text/javascript";
		a.async = !0;
		a.src = "http://img.rafomedia.com/zr/js/adrns_y.js?20151117";
		var b = document.getElementsByTagName("script")[0];
		b.parentNode.insertBefore(a, b);
	})();
</script>
</head>
 
<body class="pace-done" >
	<div ng-view>
	<div class="pace  pace-inactive">
		<div class="pace-progress" data-progress-text="100%"
			data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
			<div class="pace-progress-inner"></div>
		</div>
		<div class="pace-activity"></div>
	</div>
	<div id="wrapper">
		<!-- Include Nav -->
		<c:import url="include/leftMenu.jsp"></c:import>  
 
		<div id="page-wrapper" class="gray-bg" style="min-height: 623px;">
			<!-- - header -->
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top white-bg" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom"
							action="search_results.html">
							<div class="form-group">
								<input type="text" placeholder="Search for something..."
									class="form-control" name="top-search" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">Welcome
								to DOT</span></li>
								
						<li class="dropdown"><a ng-click="runningProcessGroup()"
						class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-tasks"></i>
								<span class="label label-warning">16</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li ng-repeat-start="process in processList">
									<div > 
											<strong>Job Name : </strong> {{process.processGroup.processGroupName}}
											<br >
											<strong>Completion Status :</strong> {{process.completionStatus}}
											<div class="progress progress-mini">
												  <div class="progress-bar" style="width: {{process.completionStatus}};"></div>
											</div>
 											
										</div> 
								</li>
								<li class="divider"></li>
                                <li ng-repeat-end></li>

								
							</ul></li>

						<li class="dropdown"><a ng-click="findLatestFive()"
							class="dropdown-toggle count-info" data-toggle="dropdown"> <i
								class="fa fa-bell"></i> <span class="label label-primary">{{countData}}</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li ng-repeat-start="note in notificationList">
									<a href="#">
										<div>
											{{note.notificationName}}
											<br>
											Submitted On :<span class="pull-right text-muted small"> <strong>{{note.notificationDate}}</strong></span> 
										</div>
									</a>
								</li>
								<li class="divider"></li>
                                <li ng-repeat-end></li>

								<li>
									<div class="text-center link-block">
										<a ng-click="notificationWindow()"> <strong>See All
												Notifications</strong> <i class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>


						<li><a href="/login?logout"> <i class="fa fa-sign-out"></i>
								Log out
						</a></li>
						
					</ul>

				</nav>
			</div>
			<!--  header end -->
        <div ui-view>
			<div class="wrapper wrapper-content">
				<div class="row">
					<div class="col-md-2">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<span class="label label-success pull-right"><i
									class="fa fa-database"></i></span>
								<h5>Databases</h5>
							</div>
							<div class="ibox-content">
								<h1 class="no-margins">{{countConnectionData}}</h1>
								<small># Scanned databases</small>
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
								<h1 class="no-margins">{{countSchemaData}}</h1>
								<small># Scanned schemas</small>
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
							<div class="ibox-content">

								<div class="row">
									<div class="col-md-6">
										<h1 class="no-margins">{{countTableData}}</h1>
										<div class="font-bold text-navy">
											<small># Scanned tables</small>
										</div>
									</div>
									<div class="col-md-6">
										<h1 class="no-margins">{{countColumnData}}</h1>
										<div class="font-bold text-navy">
											<small># Scanned columns</small>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="ibox float-e-margins">
							<!--  <div class="ibox-title">
                        <h5>Database Types</h5>
                        
                    </div> -->
							<div class="ibox-content">
								<div>
									<canvas id="barChart" height="95"></canvas>
								</div>
							</div>


							<%-- <div class="ibox-content no-padding">
                        <div class="flot-chart m-t-lg" style="height: 55px;">
                            <div class="flot-chart-content" id="flot-chart1" style="padding: 0px; position: relative;">
                            
                             <canvas class="flot-overlay" width="340" height="55" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 340px; height: 55px;"></canvas></div> 
                        </div>
                    </div>  --%>


						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-8">
						<div class="ibox float-e-margins">
							<div class="ibox-content">
								<div>
									<span class="pull-right text-right"> <small>Number
											of databases added with time and number of inactive databases
											with time</small>

									</span>
									<h3 class="font-bold no-margins">Database Status</h3>
								</div>

								<div class="m-t-sm">

									<div class="row">
										<div class="col-md-8">

											<div class="flot-chart-content">
												<canvas id="lineChart" height="165" width="436"
													style="width: 436px; height: 165px;"></canvas>
											</div>

										</div>
										<div class="col-md-4">
											<ul class="stat-list m-t-lg">
												<li>
													<h2 class="no-margins">50</h2> <small># Databases</small>
													<div class="progress progress-mini">
														<div class="progress-bar" style="width: 100%;"></div>
													</div>
												</li>
												<li>
													<h2 class="no-margins ">40</h2> <small># Active
														databases</small>
													<div class="progress progress-mini">
														<div class="progress-bar" style="width: 80%;"></div>
													</div>
												</li>
											</ul>
										</div>
									</div>

								</div>

								<div class="m-t-md">
									<small class="pull-right"> <i class="fa fa-clock-o">
									</i> Update on 16.07.2015
									</small>

								</div>

							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<!-- <span class="label label-warning pull-right">Data has changed</span> -->
								<h5>Large Databases</h5>
							</div>
							<!-- <div class="ibox-content"> -->
							<div class="list-group-item">
								<span class="pull-right">500 Tables</span> <span
									class="label label-success">1</span> Customer Database
							</div>
							<!-- </div> -->
							<div class="list-group-item">
								<span class="pull-right">480 Tables</span> <span
									class="label label-info">2</span> Product Database
							</div>
							<div class="list-group-item">
								<span class="pull-right">300 Tables</span> <span
									class="label label-primary">3</span> Sales Database
							</div>
							<div class="list-group-item">
								<span class="pull-right">200 Tables</span> <span
									class="label label-default">4</span> Telecome Database
							</div>
							<div class="list-group-item">
								<span class="pull-right">100 Tables</span> <span
									class="label label-primary">5</span> Order Database
							</div>
						</div>
					</div>

				</div>

				<div class="row">

					<div class="col-lg-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>Databases</h5>

							</div>
							<div class="ibox-content">
								<div class="row">
									
									
								</div>
								<div class="table-responsive">
									<!-- table class="table table-striped">
										<thead>
											<tr>

												<th>#</th>
												<th>Connection name</th>
												<th>Database Name</th>
												<th>Host</th>
												<th>Port</th>
												<th>Database Type</th>
												<th>Added By</th>
												<th>Added On</th>
												<th>Is Active</th>
											</tr>
										</thead-->
										<div ag-grid="gridOptions" style="height: 300px;" class="ag-fresh"></div>
								</div>
                          </div>
                          <!-- end view -->
							</div>
						</div>
					</div>

				</div>
              
               

			</div>


			<div class="footer">
				<div class="pull-right">
					10GB of <strong>250GB</strong> Free.
				</div>
				<div>
					<strong>Copyright</strong> Example Company © 2014-2015
				</div>
			</div>

		</div>
		<div id="right-sidebar" class="">
			<div class="slimScrollDiv"
				style="position: relative; overflow: hidden; width: auto; height: 100%;">
				<div class="sidebar-container"
					style="overflow: hidden; width: auto; height: 100%;">

					<ul class="nav nav-tabs navs-3">

						<li class="active"><a data-toggle="tab"
							href="dashboard_4_1.html#tab-1"> Notes </a></li>
						<li><a data-toggle="tab" href="dashboard_4_1.html#tab-2">
								Projects </a></li>
						<li class=""><a data-toggle="tab"
							href="dashboard_4_1.html#tab-3"> <i class="fa fa-gear"></i>
						</a></li>
					</ul>

					<div class="tab-content">


						<div id="tab-1" class="tab-pane active">

							<div class="sidebar-title">
								<h3>
									<i class="fa fa-comments-o"></i> Latest Notes
								</h3>
								<small><i class="fa fa-tim"></i> You have 10 new
									message.</small>
							</div>

							<div>

								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center">

											<div class="m-t-xs">
												<i class="fa fa-star text-warning"></i> <i
													class="fa fa-star text-warning"></i>
											</div>
										</div>
										<div class="media-body">

											There are many variations of passages of Lorem Ipsum
											available. <br> <small class="text-muted">Today
												4:21 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center"></div>
										<div class="media-body">
											The point of using Lorem Ipsum is that it has a more-or-less
											normal. <br> <small class="text-muted">Yesterday
												2:45 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center">


											<div class="m-t-xs">
												<i class="fa fa-star text-warning"></i> <i
													class="fa fa-star text-warning"></i> <i
													class="fa fa-star text-warning"></i>
											</div>
										</div>
										<div class="media-body">
											Mevolved over the years, sometimes by accident, sometimes on
											purpose (injected humour and the like). <br> <small
												class="text-muted">Yesterday 1:10 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center">
											<img alt="image" class="img-circle message-avatar"
												src=".js/a4.jpg">
										</div>

										<div class="media-body">
											Lorem Ipsum, you need to be sure there isn't anything
											embarrassing hidden in the <br> <small
												class="text-muted">Monday 8:37 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center"></div>
										<div class="media-body">

											All the Lorem Ipsum generators on the Internet tend to
											repeat. <br> <small class="text-muted">Today
												4:21 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">
										<div class="pull-left text-center"></div>
										<div class="media-body">
											Renaissance. The first line of Lorem Ipsum, "Lorem ipsum
											dolor sit amet..", comes from a line in section 1.10.32. <br>
											<small class="text-muted">Yesterday 2:45 pm</small>
										</div>
									</a>
								</div>
								<div class="sidebar-message">
									<a href="dashboard_4_1.html#">



										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i>
										</div>
								</div>
								<div class="media-body">
									The standard chunk of Lorem Ipsum used since the 1500s is
									reproduced below. <br> <small class="text-muted">Yesterday
										1:10 pm</small>
								</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="dashboard_4_1.html#">
									<div class="pull-left text-center"></div>
									<div class="media-body">
										Uncover many web sites still in their infancy. Various
										versions have. <br> <small class="text-muted">Monday
											8:37 pm</small>
									</div>
								</a>
							</div>
						</div>

					</div>

					<div id="tab-2" class="tab-pane">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-cube"></i> Latest projects
							</h3>
							<small><i class="fa fa-tim"></i> You have 14 projects. 10
								not completed.</small>
						</div>

						<ul class="sidebar-list">
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Business valuation</h4> It is a long established fact that
									a reader will be distracted.

									<div class="small">Completion with: 22%</div>
									<div class="progress progress-mini">
										<div style="width: 22%;"
											class="progress-bar progress-bar-warning"></div>
									</div>
									<div class="small text-muted m-t-xs">Project end: 4:00 pm
										- 12.06.2014</div>
							</a></li>
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Contract with Company</h4> Many desktop publishing packages
									and web page editors.

									<div class="small">Completion with: 48%</div>
									<div class="progress progress-mini">
										<div style="width: 48%;" class="progress-bar"></div>
									</div>
							</a></li>
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Meeting</h4> By the readable content of a page when looking
									at its layout.

									<div class="small">Completion with: 14%</div>
									<div class="progress progress-mini">
										<div style="width: 14%;"
											class="progress-bar progress-bar-info"></div>
									</div>
							</a></li>
							<li><a href="dashboard_4_1.html#"> <span
									class="label label-primary pull-right">NEW</span>
									<h4>The generated</h4> <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
									There are many variations of passages of Lorem Ipsum available.
									<div class="small">Completion with: 22%</div>
									<div class="small text-muted m-t-xs">Project end: 4:00 pm
										- 12.06.2014</div>
							</a></li>
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Business valuation</h4> It is a long established fact that
									a reader will be distracted.

									<div class="small">Completion with: 22%</div>
									<div class="progress progress-mini">
										<div style="width: 22%;"
											class="progress-bar progress-bar-warning"></div>
									</div>
									<div class="small text-muted m-t-xs">Project end: 4:00 pm
										- 12.06.2014</div>
							</a></li>
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Contract with Company</h4> Many desktop publishing packages
									and web page editors.

									<div class="small">Completion with: 48%</div>
									<div class="progress progress-mini">
										<div style="width: 48%;" class="progress-bar"></div>
									</div>
							</a></li>
							<li><a href="dashboard_4_1.html#">
									<div class="small pull-right m-t-xs">9 hours ago</div>
									<h4>Meeting</h4> By the readable content of a page when looking
									at its layout.

									<div class="small">Completion with: 14%</div>
									<div class="progress progress-mini">
										<div style="width: 14%;"
											class="progress-bar progress-bar-info"></div>
									</div>
							</a></li>
							<li><a href="dashboard_4_1.html#"> <span
									class="label label-primary pull-right">NEW</span>
									<h4>The generated</h4> <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
									There are many variations of passages of Lorem Ipsum available.
									<div class="small">Completion with: 22%</div>
									<div class="small text-muted m-t-xs">Project end: 4:00 pm
										- 12.06.2014</div>
							</a></li>

						</ul>

					</div>

					<div id="tab-3" class="tab-pane">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-gears"></i> Settings
							</h3>
							<small><i class="fa fa-tim"></i> You have 14 projects. 10
								not completed.</small>
						</div>

						<div class="setings-item">
							<span> Show notifications </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example"> <label
										class="onoffswitch-label" for="example"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Disable Chat </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu" checked=""
										class="onoffswitch-checkbox" id="example2"> <label
										class="onoffswitch-label" for="example2"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Enable history </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example3"> <label
										class="onoffswitch-label" for="example3"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Show charts </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example4"> <label
										class="onoffswitch-label" for="example4"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Offline users </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" checked="" name="collapsemenu"
										class="onoffswitch-checkbox" id="example5"> <label
										class="onoffswitch-label" for="example5"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Global search </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" checked="" name="collapsemenu"
										class="onoffswitch-checkbox" id="example6"> <label
										class="onoffswitch-label" for="example6"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> Update everyday </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example7"> <label
										class="onoffswitch-label" for="example7"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>

						<div class="sidebar-content">
							<h4>Settings</h4>
							<div class="small">I belive that. Lorem Ipsum is simply
								dummy text of the printing and typesetting industry. And
								typesetting industry. Lorem Ipsum has been the industry's
								standard dummy text ever since the 1500s. Over the years,
								sometimes by accident, sometimes on purpose (injected humour and
								the like).</div>
						</div>

					</div>
				</div>

			</div>
			<div class="slimScrollBar"
				style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 329.004166666667px; background: rgb(0, 0, 0);"></div>
			<div class="slimScrollRail"
				style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.4; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
		</div>



	</div>
	</div>
	</div>

	<!-- Mainly scripts -->
	<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.metisMenu.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.slimscroll.min.js" />"></script>

	<!-- Flot -->
	<script src="<c:url value="/resources/js/jquery.flot.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery.flot.tooltip.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.flot.spline.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.flot.resize.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.flot.pie.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.flot.symbol.js" />"></script>
	<script src="<c:url value="/resources/js/curvedLines.js" />"></script>

	<script src="<c:url value="/resources/js/inspinia.js" />"></script>
	<script src="<c:url value="/resources/js/pace.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery-jvectormap-2.0.2.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery-jvectormap-2.0.2.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery-jvectormap-world-mill-en.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery-jvectormap-2.0.2.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/jquery-jvectormap-world-mill-en.js" />"></script>


	<!-- Sparkline -->
	<script src="<c:url value="/resources/js/jquery.sparkline.min.js" />"></script>

	<!-- Sparkline demo data  -->
	<script src="<c:url value="/resources/js/sparkline-demo.js"/>"></script>

	<!-- ChartJS-->
	<script src="<c:url value="/resources/js/Chart.min.js"/>"></script>
	
	<script src="<c:url value="/resources/js/chartist.min.js" />"></script>
    
	 <script>
		$(document)
				.ready(
						function() {
							
							
							var sparklineCharts = function(){
				                 $("#sparkline1").sparkline([34, 43, 43, 35, 44, 32, 44, 52], {
				                     type: 'line',
				                     width: '100%',
				                     height: '60',
				                     lineColor: '#1ab394',
				                     fillColor: "#ffffff"
				                 });

				                 $("#sparkline2").sparkline([24, 43, 43, 55, 44, 62, 44, 72], {
				                     type: 'line',
				                     width: '100%',
				                     height: '60',
				                     lineColor: '#1ab394',
				                     fillColor: "#ffffff"
				                 });

				                 $("#sparkline3").sparkline([74, 43, 23, 55, 54, 32, 24, 12], {
				                     type: 'line',
				                     width: '100%',
				                     height: '60',
				                     lineColor: '#ed5565',
				                     fillColor: "#ffffff"
				                 });

				                 $("#sparkline4").sparkline([24, 43, 33, 55, 64, 72, 44, 22], {
				                     type: 'line',
				                     width: '100%',
				                     height: '60',
				                     lineColor: '#ed5565',
				                     fillColor: "#ffffff"
				                 });

				                 $("#sparkline5").sparkline([1, 4], {
				                     type: 'pie',
				                     height: '140',
				                     sliceColors: ['#1ab394', '#F5F5F5']
				                 });

				                 $("#sparkline6").sparkline([5, 3], {
				                     type: 'pie',
				                     height: '140',
				                     sliceColors: ['#1ab394', '#F5F5F5']
				                 });

				                 $("#sparkline7").sparkline([2, 2], {
				                     type: 'pie',
				                     height: '140',
				                     sliceColors: ['#ed5565', '#F5F5F5']
				                 });

				                 $("#sparkline8").sparkline([2, 3], {
				                     type: 'pie',
				                     height: '140',
				                     sliceColors: ['#ed5565', '#F5F5F5']
				                 });
				            };

				            var sparkResize;

				            $(window).resize(function(e) {
				                clearTimeout(sparkResize);
				                sparkResize = setTimeout(sparklineCharts, 500);
				            });

				            sparklineCharts();
							
							

							var lineData = {
								labels : [ "January", "February", "March",
										"April", "May", "June", "July" ],
								datasets : [
										{
											label : "Example dataset",
											fillColor : "rgba(220,220,220,0.5)",
											strokeColor : "rgba(220,220,220,1)",
											pointColor : "rgba(220,220,220,1)",
											pointStrokeColor : "#fff",
											pointHighlightFill : "#fff",
											pointHighlightStroke : "rgba(220,220,220,1)",
											data : [ 65, 59, 40, 51, 36, 25, 40 ]
										},
										{
											label : "Example dataset",
											fillColor : "rgba(26,179,148,0.5)",
											strokeColor : "rgba(26,179,148,0.7)",
											pointColor : "rgba(26,179,148,1)",
											pointStrokeColor : "#fff",
											pointHighlightFill : "#fff",
											pointHighlightStroke : "rgba(26,179,148,1)",
											data : [ 48, 48, 60, 39, 56, 37, 30 ]
										} ]
							};

							var lineOptions = {
								scaleShowGridLines : true,
								scaleGridLineColor : "rgba(0,0,0,.05)",
								scaleGridLineWidth : 1,
								bezierCurve : true,
								bezierCurveTension : 0.4,
								pointDot : true,
								pointDotRadius : 4,
								pointDotStrokeWidth : 1,
								pointHitDetectionRadius : 20,
								datasetStroke : true,
								datasetStrokeWidth : 2,
								datasetFill : true,
								responsive : true,
							};

							var ctx = document.getElementById("lineChart")
									.getContext("2d");
							var myNewChart = new Chart(ctx).Line(lineData,
									lineOptions);

							$.plot($("#lineChart"), lineData, {
								xaxis : {
									tickDecimals : 0
								},
								series : {
									lines : {
										show : true,
										fill : true,
										fillColor : {
											colors : [ {
												opacity : 1
											}, {
												opacity : 1
											} ]
										},
									},
									points : {
										width : 0.1,
										show : false
									},
								},
								grid : {
									show : false,
									borderWidth : 0
								},
								legend : {
									show : false,
								}
							});

							var barData = {
								labels : [ "Oracle", "Derby", "Db2", "MSSQL",
										"Others" ],
								datasets : [ {
									label : "My First dataset",
									fillColor : "rgba(26,179,148,0.5)",
									strokeColor : "rgba(26,179,148,0.8)",
									highlightFill : "rgba(26,179,148,0.75)",
									highlightStroke : "rgba(26,179,148,1)",
									data : [ 5, 2, 3, 1, 6 ]
								},

								]
							};

							var barOptions = {
								scaleBeginAtZero : true,
								scaleShowGridLines : true,
								scaleGridLineColor : "rgba(0,0,0,.05)",
								scaleGridLineWidth : 1,
								barShowStroke : true,
								barStrokeWidth : 2,
								barValueSpacing : 5,
								barDatasetSpacing : 1,
								responsive : true,
							}

							var ctx = document.getElementById("barChart")
									.getContext("2d");
							var myNewChart = new Chart(ctx).Bar(barData,
									barOptions);

						});
	</script>


	
	
	<script>
		// Config box

		// Enable/disable fixed top navbar
		$('#fixednavbar').click(
				function() {
					if ($('#fixednavbar').is(':checked')) {
						$(".navbar-static-top")
								.removeClass('navbar-static-top').addClass(
										'navbar-fixed-top');
						$("body").removeClass('boxed-layout');
						$("body").addClass('fixed-nav');
						$('#boxedlayout').prop('checked', false);

						if (localStorageSupport) {
							localStorage.setItem("boxedlayout", 'off');
						}

						if (localStorageSupport) {
							localStorage.setItem("fixednavbar", 'on');
						}
					} else {
						$(".navbar-fixed-top").removeClass('navbar-fixed-top')
								.addClass('navbar-static-top');
						$("body").removeClass('fixed-nav');

						if (localStorageSupport) {
							localStorage.setItem("fixednavbar", 'off');
						}
					}
				});

		// Enable/disable fixed sidebar
		$('#fixedsidebar').click(function() {
			if ($('#fixedsidebar').is(':checked')) {
				$("body").addClass('fixed-sidebar');
				$('.sidebar-collapse').slimScroll({
					height : '100%',
					railOpacity : 0.9
				});

				if (localStorageSupport) {
					localStorage.setItem("fixedsidebar", 'on');
				}
			} else {
				$('.sidebar-collapse').slimscroll({
					destroy : true
				});
				$('.sidebar-collapse').attr('style', '');
				$("body").removeClass('fixed-sidebar');

				if (localStorageSupport) {
					localStorage.setItem("fixedsidebar", 'off');
				}
			}
		});

		// Enable/disable collapse menu
		$('#collapsemenu').click(function() {
			if ($('#collapsemenu').is(':checked')) {
				$("body").addClass('mini-navbar');
				SmoothlyMenu();

				if (localStorageSupport) {
					localStorage.setItem("collapse_menu", 'on');
				}

			} else {
				$("body").removeClass('mini-navbar');
				SmoothlyMenu();

				if (localStorageSupport) {
					localStorage.setItem("collapse_menu", 'off');
				}
			}
		});

		// Enable/disable boxed layout
		$('#boxedlayout').click(
				function() {
					if ($('#boxedlayout').is(':checked')) {
						$("body").addClass('boxed-layout');
						$('#fixednavbar').prop('checked', false);
						$(".navbar-fixed-top").removeClass('navbar-fixed-top')
								.addClass('navbar-static-top');
						$("body").removeClass('fixed-nav');
						$(".footer").removeClass('fixed');
						$('#fixedfooter').prop('checked', false);

						if (localStorageSupport) {
							localStorage.setItem("fixednavbar", 'off');
						}

						if (localStorageSupport) {
							localStorage.setItem("fixedfooter", 'off');
						}

						if (localStorageSupport) {
							localStorage.setItem("boxedlayout", 'on');
						}
					} else {
						$("body").removeClass('boxed-layout');

						if (localStorageSupport) {
							localStorage.setItem("boxedlayout", 'off');
						}
					}
				});

		// Enable/disable fixed footer
		$('#fixedfooter').click(function() {
			if ($('#fixedfooter').is(':checked')) {
				$('#boxedlayout').prop('checked', false);
				$("body").removeClass('boxed-layout');
				$(".footer").addClass('fixed');

				if (localStorageSupport) {
					localStorage.setItem("boxedlayout", 'off');
				}

				if (localStorageSupport) {
					localStorage.setItem("fixedfooter", 'on');
				}
			} else {
				$(".footer").removeClass('fixed');

				if (localStorageSupport) {
					localStorage.setItem("fixedfooter", 'off');
				}
			}
		});

		// SKIN Select
		$('.spin-icon').click(function() {
			$(".theme-config-box").toggleClass("show");
		});

		// Default skin
		$('.s-skin-0').click(function() {
			$("body").removeClass("skin-1");
			$("body").removeClass("skin-2");
			$("body").removeClass("skin-3");
		});

		// Blue skin
		$('.s-skin-1').click(function() {
			$("body").removeClass("skin-2");
			$("body").removeClass("skin-3");
			$("body").addClass("skin-1");
		});

		// Inspinia ultra skin
		$('.s-skin-2').click(function() {
			$("body").removeClass("skin-1");
			$("body").removeClass("skin-3");
			$("body").addClass("skin-2");
		});

		// Yellow skin
		$('.s-skin-3').click(function() {
			$("body").removeClass("skin-1");
			$("body").removeClass("skin-2");
			$("body").addClass("skin-3");
		});

		if (localStorageSupport) {
			var collapse = localStorage.getItem("collapse_menu");
			var fixedsidebar = localStorage.getItem("fixedsidebar");
			var fixednavbar = localStorage.getItem("fixednavbar");
			var boxedlayout = localStorage.getItem("boxedlayout");
			var fixedfooter = localStorage.getItem("fixedfooter");

			if (collapse == 'on') {
				$('#collapsemenu').prop('checked', 'checked')
			}
			if (fixedsidebar == 'on') {
				$('#fixedsidebar').prop('checked', 'checked')
			}
			if (fixednavbar == 'on') {
				$('#fixednavbar').prop('checked', 'checked')
			}
			if (boxedlayout == 'on') {
				$('#boxedlayout').prop('checked', 'checked')
			}
			if (fixedfooter == 'on') {
				$('#fixedfooter').prop('checked', 'checked')
			}
		}
	</script>
	
	
</body>
</html>