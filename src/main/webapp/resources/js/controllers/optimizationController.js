function optimizationController($scope, $stateParams, OptimizationStat) {

	$scope.overAllOptimizationStatus = function() {
		var res = OptimizationStat.overAllOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.overAllOptimizationStatus = data;
			$scope.chart();
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.statusByType = function() {
		$scope.dataType();
		$scope.size();
		$scope.uniqueKey();
		$scope.index();
		$scope.relationship();
		$scope.overAllOptimizationStatus();
	};

	$scope.dataType = function() {
		var res = OptimizationStat.dataTypeOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.dataTypeOptimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.size = function() {
		var res = OptimizationStat.sizeOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.sizeOptimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};
	$scope.uniqueKey = function() {
		var res = OptimizationStat.uniqueKeyOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.uniqueKeyOptimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});

	};
	$scope.index = function() {
		var res = OptimizationStat.indexOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.indexOptimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};
	$scope.relationship = function() {
		var res = OptimizationStat.relationshipOptimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.relationshipOptimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.statusByType();

	$scope.chart = function() {
		new Chartist.Pie('#ct-chart6', {
			series : [ $scope.overAllOptimizationStatus,
					100 - $scope.overAllOptimizationStatus ]
		}, {
			donut : true,
			donutWidth : 80,
			startAngle : 270,
			total : 0,
			showLabel : true
		});

		new Chartist.Bar('#ct-chart3', {
			labels : [ 'Data Type', 'Size', 'Unique Key', 'Relationship',
					'Index' ],
			series : [
					[ $scope.dataTypeOptimizationStatus,
							$scope.sizeOptimizationStatus,
							$scope.uniqueKeyOptimizationStatus,
							$scope.relationshipOptimizationStatus,
							$scope.indexOptimizationStatus ],
					[ 100 - $scope.dataTypeOptimizationStatus,
							100 - $scope.sizeOptimizationStatus,
							100 - $scope.uniqueKeyOptimizationStatus,
							100 - $scope.relationshipOptimizationStatus,
							100 - $scope.indexOptimizationStatus ] ]
		}, {
			seriesBarDistance : 5,
			stackBars : true,
			horizontalBars : true,
			showLabel : true,
			axisY : {
				offset : 80
			}
		}).on('draw', function(data) {
			if (data.type === 'bar') {
				data.element.attr({
					style : 'stroke-width: 30px'
				});
			}
		});

	}

	$scope.databases = function() {
		var res = OptimizationStat.databaseOptimizationStatus();
		res.success(function(data, status, headers, config) {
			// alert(data);
			var allOfTheData = data;
			var dataSource = {
				rowCount : null, // behave as infinite scroll
				pageSize : 15,
				overflowSize : 15,
				maxConcurrentRequests : 2,
				maxPagesInCache : 2,
				getRows : function(params) {
					console.log('asking for ' + params.startRow + ' to '
							+ params.endRow);
					setTimeout(function() {
						var rowsThisPage = allOfTheData.slice(params.startRow,
								params.endRow);
						var lastRow = -1;
						if (allOfTheData.length <= params.endRow) {
							lastRow = allOfTheData.length;
						}
						params.successCallback(rowsThisPage, lastRow);
					}, 500);
				}
			};

			$scope.gridOptions.api.setDatasource(dataSource);
			$scope.gridOptions.api.sizeColumnsToFit();
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	var columnDefs = [

	{
		headerName : "Connection Name",
		field : "formattedName",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "Data Type(%)",
		field : "dataTypePercentage",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Size(%)",
		field : "sizePercentage",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Unique Key(%)",
		field : "uniqueKeyPercentage",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "RelationShip(%)",
		field : "relationshipPercentage",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Index(%)",
		field : "indexPercentage",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	} ];

	$scope.gridOptions = {
		suppressRowClickSelection : true,
		suppressCellSelection : true,
		enableColResize : true,
		columnDefs : columnDefs,
		enableFilter : true,
		enableSorting : true,
		sortingOrder : [ 'desc', 'asc', null ],
		headerHeight : '40',
		rowHeight : '40'

	};

	$scope.databases();

}