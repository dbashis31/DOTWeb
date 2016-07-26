<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>

<html ng-app="dotApp" ng-controller="optimizationController">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
	<div ng-view>
		<div class="row wrapper border-bottom white-bg page-heading">
			<div class="col-lg-10">
				<div style="height: 10px"></div>
				<ol class="breadcrumb">
					<li>Rationalization</li>
					<li class="active"><strong>Optimize</strong></li>
				</ol>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="wrapper wrapper-content">
			<div class="row">
				<div class="col-lg-6" style="height: 350px">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Overall Optimization Status(%)</h5>
						</div>
						<div class="ibox-content">
							<div id="ct-chart6" class="ct-perfect-fourth"
								style="height: 250px"></div>
						</div>
					</div>
				</div>

				<div class="col-lg-6" style="height: 350px">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Overall Optimization Status(%) By Type</h5>
						</div>
						<div class="ibox-content">
							<div id="ct-chart3" class="ct-perfect-fourth"
								style="height: 250px"></div>
						</div>
					</div>


				</div>
			</div>

			<div class="row">

				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<div class="row">
								<div class="col-sm-9 m-b-xs">
									<h5>Database wise optimization status</h5>
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

	</div>
</body>

</html>
