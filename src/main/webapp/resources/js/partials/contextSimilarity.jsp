<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>

<html ng-app="dotApp" ng-controller="contextSimilarityController">

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
					<li>Similarity</li>
					<li class="active"><strong>Context</strong></li>
				</ol>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="wrapper wrapper-content">
			<div class="row">
				<div class="col-lg-5">
					<div class="jumbotron">
						<h2>{{100-similarityPercentage}}% Context based similarity</h2>
						<div class="ibox-content" style="background-color: #EEEEEE">
							<div id="ct-chart6" class="ct-perfect-fourth"
								style="height: 220px; background-color: #EEEEEE"></div>
						</div>
					</div>
				</div>

				<div class="col-lg-7" style="height: 350px">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Context based similarity in databases</h5>
						</div>
						<div class="ibox-content">
							<div class="table-responsive">
								<div ag-grid="gridOptions1" style="width: 100%; height: 308px;"
									class="ag-fresh"></div>
							</div>
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
									<h5>Context based similar schema groups</h5>
								</div>
								<div class="col-sm-3" style="text-align: right; float: right">
									<h4 stype="float:right; padding:5px"># Schema Groups :
										{{totalGroups}}</h4>
								</div>
							</div>

						</div>


					</div>
				</div>
				<div class="col-lg-2" data-ng-repeat="group in schemaGroups">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>
								<a ui-sref="home.groupSchemas({id:group.id, name:group.name})"
									style="color: #18A689">{{group.name}}</a>
							</h5>
						</div>
						<div class="ibox-content">
							<h1 class="no-margins">{{group.count}}</h1>
							<small>Similar Schemas</small>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

</html>
