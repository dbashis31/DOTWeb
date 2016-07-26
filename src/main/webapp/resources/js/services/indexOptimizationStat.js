/**
 * User service
 */
angular
		.module('dot.services.indexOptimizationStat', [])
		.factory(
				'IndexOptimizationStat',
				[
						'$http',
						function($http) {

							var OptimizationStat = {};

							OptimizationStat.databaseCount = function() {
								var res = $http
										.get('IndexOptimizationStatService/databaseCount');
								return res;
							};

							OptimizationStat.schemaCount = function() {
								var res = $http
										.get('IndexOptimizationStatService/schemaCount');
								return res;
							};

							OptimizationStat.tableCount = function() {
								var res = $http
										.get('IndexOptimizationStatService/tableCount');
								return res;
							};

							OptimizationStat.columnCount = function() {
								var res = $http
										.get('IndexOptimizationStatService/columnCount');
								return res;
							};

							OptimizationStat.optimizationStatus = function() {
								var res = $http
										.get('IndexOptimizationStatService/optimizationStatus');
								return res;
							};

							OptimizationStat.databases = function() {
								var res = $http
										.get('IndexOptimizationStatService/databases');
								return res;
							};

							OptimizationStat.schemas = function(connectionId) {
								var res = $http
										.get('IndexOptimizationStatService/schemas?connectionId='
												+ connectionId);
								return res;
							};

							OptimizationStat.tables = function(schemaId) {
								var res = $http
										.get('IndexOptimizationStatService/tables?schemaId='
												+ schemaId);
								return res;
							};

							OptimizationStat.columns = function(tableId) {
								var res = $http
										.get('IndexOptimizationStatService/columns?tableId='
												+ tableId);
								return res;
							};

							OptimizationStat.parentModel = function(id, type) {
								var res = $http
										.get('IndexOptimizationStatService/parentModel?id='
												+ id + '&type=' + type);
								return res;
							};

							OptimizationStat.viewData = function(columnId) {
								var res = $http
										.get('IndexOptimizationStatService/viewData?columnId='
												+ columnId);
								return res;
							};

							return OptimizationStat;
						} ]);