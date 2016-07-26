/**
 * 
 */
var app = angular.module("dotApp", [ 'dot.services.column',
		'dot.services.table', 'dot.services.connection',
		'dot.services.notification', 'dot.services.processGroup',
		'dot.services.optimizationStat', 'dot.services.sizeOptimizationStat',
		'dot.services.uniqueKeyOptimizationStat',
		'dot.services.indexOptimizationStat', 'ui.router', 'fm.services',
		'fm.services.utility', 'dot.services.schema' ]);
// Define Routing for app
// Uri /AddNewOrder -> partials add_order.html and Controller AddOrderController
// Uri /ShowOrders -> partials show_orders.html and Controller
// AddOrderController

app.config(function($stateProvider, $urlRouterProvider) {

	// $urlRouterProvider.otherwise('/home');

	$stateProvider

	// HOME STATES AND NESTED VIEWS ========================================
	.state('home', {
		url : '/home',
		templateUrl : 'resources/js/partials/home.html',
		controller : scotchController
	}).state('home.dataType', {
		url : "/dataType",
		templateUrl : "resources/js/partials/dataTypeOptz.jsp",
		controller : dataTypeController
	}).state('home.dataTypeschema', {
		url : "/dataTypeschema/:id/:name",
		templateUrl : "resources/js/partials/dataTypeOptzSchema.jsp",
		controller : dataTypeSchemaController
	}).state('home.dataTypeTable', {
		url : "/dataTypeTable/:id/:name",
		templateUrl : "resources/js/partials/dataTypeOptzTable.jsp",
		controller : dataTypeTableController
	}).state('home.dataTypeColumn', {
		url : "/dataTypeColumn/:id/:name",
		templateUrl : "resources/js/partials/dataTypeOptzColumn.jsp",
		controller : dataTypeColumnController
	}).state('home.dataSize', {
		url : "/dataSize",
		templateUrl : "resources/js/partials/dataSizeOptz.jsp",
		controller : dataSizeController
	}).state('home.dataSizeSchema', {
		url : "/dataSizeSchema/:id/:name",
		templateUrl : "resources/js/partials/dataSizeOptzSchema.jsp",
		controller : dataSizeSchemaController
	}).state('home.dataSizeTable', {
		url : "/dataSizeTable/:id/:name",
		templateUrl : "resources/js/partials/dataSizeOptzTable.jsp",
		controller : dataSizeTableController
	}).state('home.dataSizeColumn', {
		url : "/dataSizeColumn/:id/:name",
		templateUrl : "resources/js/partials/dataSizeOptzColumn.jsp",
		controller : dataSizeColumnController
	}).state('home.key', {
		url : "/key",
		templateUrl : "resources/js/partials/UniqueKeyOptz.jsp",
		controller : UniqueKeyController
	}).state('home.keySchema', {
		url : "/keySchema/:id/:name",
		templateUrl : "resources/js/partials/uniqueKeyOptzSchema.jsp",
		controller : uniqueKeySchemaController
	}).state('home.keyTable', {
		url : "/keyTable/:id/:name",
		templateUrl : "resources/js/partials/uniqueKeyOptzTable.jsp",
		controller : uniqueKeyTableController
	}).state('home.keyColumn', {
		url : "/keyColumn/:id/:name",
		templateUrl : "resources/js/partials/uniqueKeyOptzColumn.jsp",
		controller : uniqueKeyColumnController
	}).state('home.index', {
		url : "/index",
		templateUrl : "resources/js/partials/indexOptz.jsp",
		controller : indexController
	}).state('home.indexSchema', {
		url : "/indexSchema/:id/:name",
		templateUrl : "resources/js/partials/indexOptzSchema.jsp",
		controller : indexSchemaController
	}).state('home.indexTable', {
		url : "/indexTable/:id/:name",
		templateUrl : "resources/js/partials/indexOptzTable.jsp",
		controller : indexTableController
	}).state('home.indexColumn', {
		url : "/indexColumn/:id/:name",
		templateUrl : "resources/js/partials/indexOptzColumn.jsp",
		controller : indexColumnController
	}).state('home.optimize', {
		url : "/optimize",
		templateUrl : "resources/js/partials/optimize.jsp",
		controller : optimizationController
	});

});

app.controller("DotCtrl", function($scope, Notification, ProcessGroup, fmmodal,
		fmmodalopen, fmmodalclose, Table, Connection, Column, OptimizationStat,
		Schema) {

	var progressBar = "resources/js/partials/progressBar.html";
	var notificationALL = "resources/js/partials/Notification.html";
	var commonDesignPopup = new Options();
	commonDesignPopup.fmmodal = fmmodal;
	commonDesignPopup.scope = $scope;
	commonDesignPopup.controller = this;
	/*-------------------------------
	 *  Display Progressbar
	 * -----------------------------*/
	$scope.showProgressBar = function() {
		$scope.disableButton = true;
		commonDesignPopup.width = "300";
		commonDesignPopup.popupHeader = "";
		commonDesignPopup.url = progressBar;
		commonDesignPopup.onOpenCallService = null;
		commonDesignPopup.serviceToServe = null;
		// fmmodalopen(commonDesignPopup);
	}
	$scope.notificationWindow = function() {
		alert("dddddddddd");
		$scope.disableButton = false;
		commonDesignPopup.width = "720";
		commonDesignPopup.popupHeader = "";
		commonDesignPopup.url = notificationALL;
		commonDesignPopup.onOpenCallService = null;
		commonDesignPopup.serviceToServe = null;
		fmmodalopen(commonDesignPopup);
	}
	$scope.findLatestFive = function() {

		// alert($scope.user);
		// alert("ssss");
		$scope.showProgressBar();
		var res = Notification.findLatestFive();

		res.success(function(data, status, headers, config) {
			$scope.notificationList = data;
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});
		});
	};
	$scope.countNotification = function() {
		// alert("$scope.user");
		$scope.showProgressBar();
		var res = Notification.countNotification();

		res.success(function(data, status, headers, config) {
			$scope.countData = data;
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});
		});
	};

	$scope.countNotification();

	$scope.runningProcessGroup = function() {

		$scope.showProgressBar();

		var res = ProcessGroup.runningProcessGroup();

		res.success(function(data, status, headers, config) {
			$scope.processList = data;
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});

		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			fmmodalclose({
				popupId : "progressMsg",
				isremove : true
			});
		});
	};

	$scope.countTable = function() {
		// alert("$scope.user");
		// $scope.showProgressBar();
		var res = Table.countTable();

		res.success(function(data, status, headers, config) {
			$scope.countTableData = data;
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
	};

	$scope.countColumn = function() {
		// alert("$scope.user");
		// $scope.showProgressBar();
		var res = Column.countColumn();

		res.success(function(data, status, headers, config) {
			$scope.countColumnData = data;
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
	};

	$scope.countConnection = function() {
		// alert("$scope.user");
		// $scope.showProgressBar();
		var res = Connection.countConnection();

		res.success(function(data, status, headers, config) {
			$scope.countConnectionData = data;
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
	};

	$scope.countSchema = function() {
		// alert("$scope.user");
		// $scope.showProgressBar();
		var res = Schema.countSchema();

		res.success(function(data, status, headers, config) {
			$scope.countSchemaData = data;
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
	};

	$scope.countTable();
	$scope.countColumn();
	$scope.countConnection();
	$scope.countSchema();

	$scope.columList = function() {
		var res = Connection.findAll();

		res.success(function(data, status, headers, config) {
			// alert(data);
			var allOfTheData = data;
			var dataSource = {
				rowCount : null, // behave as infinite scroll
				pageSize : 100,
				overflowSize : 100,
				maxConcurrentRequests : 2,
				maxPagesInCache : 2,
				getRows : function(params) {
					console.log('asking for ' + params.startRow + ' to '
							+ params.endRow);
					// At this point in your code, you would call the server,
					// using $http if in AngularJS.
					// To make the demo look real, wait for 500ms before
					// returning
					setTimeout(function() {
						// take a slice of the total rows
						var rowsThisPage = allOfTheData.slice(params.startRow,
								params.endRow);
						// if on or after the last page, work out the last row.
						var lastRow = -1;
						if (allOfTheData.length <= params.endRow) {
							lastRow = allOfTheData.length;
						}
						// call the success callback
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
			// fmmodalclose({popupId:"progressMsg",isremove:true});
		});
	};

	var columnDefs = [
	// this row shows the row index, doesn't use any data from the row
	{
		headerName : "#",
		width : 50,
		cellRenderer : function(params) {
			return params.node.id + 1;
		}
	},

	{
		headerName : "Connection name",
		field : "connectionName",
		width : 250,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Database Name",
		field : "connectionDatabaseName",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Host",
		field : "connectionSystemIp",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Port",
		field : "connectionPort",
		width : 100,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Database Type",
		field : "connectionDbtype",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Added By",
		field : "connectionAddedBy",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ]
	}, {
		headerName : "Added On",
		field : "connectionAddedOn",
		width : 150,
		sortingOrder : [ 'asc', 'desc' ]
	}

	];
	$scope.gridOptions = {
		enableColResize : true,
		// virtualPaging: true, // this is important, if not set, normal paging
		// will be done
		rowSelection : 'single',
		rowDeselection : true,
		columnDefs : columnDefs,
		enableFilter : true,
		enableSorting : true,
		sortingOrder : [ 'desc', 'asc', null ],
		headerHeight : '40',
		rowHeight : '40'
	// showToolPanel: true

	};
	$scope.columList();

});
