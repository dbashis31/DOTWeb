function similarGroupSchemas($scope, $stateParams, Similarity) {

	var groupId = $stateParams.id;
	$scope.groupName = $stateParams.name;

	$scope.groupSchemas = function() {
		var res = Similarity.groupSchemas(groupId);
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
		field : "value",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "Schema Name",
		field : "name",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "# Tables",
		field : "tableCount",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	}, {
		headerName : "# Columns",
		field : "columnCount",
		width : 100,
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

	$scope.groupSchemas();

}