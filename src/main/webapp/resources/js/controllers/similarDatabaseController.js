function similarDatabaseController($scope, $stateParams, Similarity) {

	var connectionId = $stateParams.id;
	var connectionName = $stateParams.name;
	$scope.connectionName = $stateParams.name;

	$scope.dataBaseSimilarities = function() {
		var res = Similarity.dataBaseSimilarities("CONTEXT_BASED",
				connectionId, connectionName);
		res.success(function(data, status, headers, config) {
			var allOfTheData = data;
			var dataSource = {
				rowCount : null, // behave as infinite scroll
				pageSize : 5,
				overflowSize : 5,
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

			$scope.gridOptions1.api.setDatasource(dataSource);
			$scope.gridOptions1.api.sizeColumnsToFit();
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	var columnDefs1 = [

	{
		headerName : "Database Name",
		field : "name",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "Database Name",
		field : "formattedName",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "Similarity",
		field : "percentageHtml",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	} ];

	$scope.gridOptions1 = {
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

	$scope.dataBaseSimilarities();

}