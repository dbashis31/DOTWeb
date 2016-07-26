function dataSizeTableController($scope, $stateParams, SizeOptimizationStat) {

	var schemaId = $stateParams.id;
	$scope.schemaName = $stateParams.name;

	$scope.tables = function() {
		var res = SizeOptimizationStat.tables(schemaId);
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
			$scope.parentModel();
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.parentModel = function() {
		var res = SizeOptimizationStat.parentModel(schemaId, "SCHEMA");
		res.success(function(data, status, headers, config) {
			$scope.parentModel = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	var columnDefs = [

	{
		headerName : "Table Name",
		field : "formattedName",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "# Columns",
		field : "columnCount",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "# Columns To Optimized",
		field : "nonOptcolumnCount",
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

	$scope.tables();

}