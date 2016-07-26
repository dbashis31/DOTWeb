function similarSchemaController($scope, $stateParams, Similarity) {

	var connectionId = $stateParams.id;
	var connectionId1 = $stateParams.id1;
	$scope.connectionName = $stateParams.name;
	$scope.connectionName1 = $stateParams.name1;
	$scope.connectionId = connectionId;

	$scope.similarSchemas = function() {
		var res = Similarity.similarSchemas("CONTEXT_BASED", connectionId,
				connectionId1);
		res.success(function(data, status, headers, config) {
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

	var columnDefs1 = [ {
		headerName : $stateParams.name,
		field : "name",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "# Tables",
		field : "tableCount",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : $stateParams.name1,
		field : "name1",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "# Tables",
		field : "tableCount1",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Similar Tables",
		field : "count",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "Similarity(%)",
		field : "formattedName",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	} ];

	$scope.gridOptions = {
		suppressRowClickSelection : true,
		suppressCellSelection : true,
		enableColResize : true,
		columnDefs : columnDefs1,
		enableFilter : true,
		enableSorting : true,
		sortingOrder : [ 'desc', 'asc', null ],
		headerHeight : '40',
		rowHeight : '40'

	};

	$scope.similarSchemas();

}