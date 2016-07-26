function UniqueKeyController($scope, UniqueKeyOptimizationStat) {
	$scope.databaseCount = function() {
		var res = UniqueKeyOptimizationStat.databaseCount();
		res.success(function(data, status, headers, config) {
			$scope.databaseCount = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.schemaCount = function() {
		var res = UniqueKeyOptimizationStat.schemaCount();
		res.success(function(data, status, headers, config) {
			$scope.schemaCount = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.tableCount = function() {
		var res = UniqueKeyOptimizationStat.tableCount();
		res.success(function(data, status, headers, config) {
			$scope.tableCount = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};


	$scope.optimizationStatus = function() {
		var res = UniqueKeyOptimizationStat.optimizationStatus();
		res.success(function(data, status, headers, config) {
			$scope.optimizationStatus = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.databases = function() {
		var res = UniqueKeyOptimizationStat.databases();
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
		headerName : "# Schemas",
		field : "schemaCount",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "# Tables",
		field : "tableCount",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	},{
		headerName : "# Tables To Optimized",
		field : "nonOptTableCount",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Status",
		field : "htmlString",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
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

	$scope.databaseCount();
	$scope.schemaCount();
	$scope.tableCount();
	$scope.optimizationStatus();
	$scope.databases();
}