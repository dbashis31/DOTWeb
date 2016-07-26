function contextSimilarityController($scope, Similarity) {

	$scope.similarityPercentage = function() {
		var res = Similarity.contextBasedSimilarityPercentage();
		res.success(function(data, status, headers, config) {
			$scope.similarityPercentage = 100 - data;
			chart();
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.similarityPercentage();

	var chart = function() {
		new Chartist.Pie('#ct-chart6', {
			series : [ $scope.similarityPercentage,
					100 - $scope.similarityPercentage ]
		}, {
			donut : true,
			donutWidth : 60,
			startAngle : 270,
			total : 0,
			showLabel : true
		});
	};

	var sparkResize;

	$(window).resize(function(e) {
		clearTimeout(sparkResize);
		sparkResize = setTimeout(sparklineCharts, 500);
	});

	$scope.similarDatabases = function() {
		var res = Similarity.similarDatabases("CONTEXT_BASED");
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

	$scope.similarDatabases();

	$scope.schemaGroups = function() {
		var res = Similarity.schemaGroups("CONTEXT_BASED");
		res.success(function(data, status, headers, config) {
			$scope.schemaGroups = data;
			$scope.totalGroups = data.length;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.schemaGroups();

}