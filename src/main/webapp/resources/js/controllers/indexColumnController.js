function indexColumnController($scope, $stateParams, IndexOptimizationStat,
		fmmodal, fmmodalopen, fmmodalclose) {

	var tableId = $stateParams.id;
	$scope.tableName = $stateParams.name;

	$scope.columns = function() {
		var res = IndexOptimizationStat.columns(tableId);
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
		var res = IndexOptimizationStat.parentModel(tableId, "TABLE");
		res.success(function(data, status, headers, config) {
			$scope.parentModel = data;
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	var commonDesignPopup = new Options();
	commonDesignPopup.fmmodal = fmmodal;
	var url = "resources/js/partials/viewData.jsp";
	commonDesignPopup.scope = $scope;
	commonDesignPopup.controller = this;
	$scope.viewDataWindow = function(id, name) {
		alert(id + "= " + name);

		$scope.viewData = function() {
			var res = IndexOptimizationStat.viewData(id);
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
							var rowsThisPage = allOfTheData.slice(
									params.startRow, params.endRow);
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

		$scope.viewData();

		$scope.columnId = id;
		$scope.columnName = name;
		$scope.disableButton = false;
		commonDesignPopup.width = "500";
		commonDesignPopup.height = "500";
		commonDesignPopup.popupHeader = "";
		commonDesignPopup.url = url;
		commonDesignPopup.onOpenCallService = null;
		commonDesignPopup.serviceToServe = null;
		fmmodalopen(commonDesignPopup);
	};

	var columnDefs = [

	{
		headerName : "Column Name",
		field : "name",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "Data Type",
		field : "value",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	},/* {
		headerName : "Size",
		field : "value1",
		width : 100,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'right'
		}
	},*/ {
		headerName : "Is Primary Key",
		field : "value3",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'center'
		}
	}, {
		headerName : "Is Index",
		field : "value2",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'center'
		}
	}, {
		headerName : "PK Column",
		field : "value4",
		width : 200,
		sortingOrder : [ 'asc', 'desc' ],
		cellStyle : {
			'text-align' : 'left'
		}
	}, {
		headerName : "PK Table",
		field : "value5",
		width : 200,
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

	$scope.columns();

}