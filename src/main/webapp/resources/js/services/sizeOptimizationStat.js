/**
 * User service
 */
angular
		.module('dot.services.sizeOptimizationStat', [])
		.factory(
				'SizeOptimizationStat',
				[
						'$http',
						function($http) {

							var OptimizationStat = {};

							OptimizationStat.databaseCount = function() {
								var res = $http
										.get('SizeOptimizationStatService/databaseCount');
								return res;
							};

							OptimizationStat.schemaCount = function() {
								var res = $http
										.get('SizeOptimizationStatService/schemaCount');
								return res;
							};

							OptimizationStat.tableCount = function() {
								var res = $http
										.get('SizeOptimizationStatService/tableCount');
								return res;
							};

							OptimizationStat.columnCount = function() {
								var res = $http
										.get('SizeOptimizationStatService/columnCount');
								return res;
							};

							OptimizationStat.optimizationStatus = function() {
								var res = $http
										.get('SizeOptimizationStatService/optimizationStatus');
								return res;
							};

							OptimizationStat.databases = function() {
								var res = $http
										.get('SizeOptimizationStatService/databases');
								return res;
							};

							OptimizationStat.schemas = function(connectionId) {
								var res = $http
										.get('SizeOptimizationStatService/schemas?connectionId='
												+ connectionId);
								return res;
							};

							OptimizationStat.tables = function(schemaId) {
								var res = $http
										.get('SizeOptimizationStatService/tables?schemaId='
												+ schemaId);
								return res;
							};

							OptimizationStat.columns = function(tableId) {
								var res = $http
										.get('SizeOptimizationStatService/columns?tableId='
												+ tableId);
								return res;
							};

							OptimizationStat.parentModel = function(id, type) {
								var res = $http
										.get('SizeOptimizationStatService/parentModel?id='
												+ id + '&type=' + type);
								return res;
							};

							OptimizationStat.viewData = function(columnId) {
								var res = $http
										.get('SizeOptimizationStatService/viewData?columnId='
												+ columnId);
								return res;
							};

							return OptimizationStat;
						} ]);