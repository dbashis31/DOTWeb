/**
 * User service
 */
angular
		.module('dot.services.uniqueKeyOptimizationStat', [])
		.factory(
				'UniqueKeyOptimizationStat',
				[
						'$http',
						function($http) {

							var OptimizationStat = {};

							OptimizationStat.databaseCount = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/databaseCount');
								return res;
							};

							OptimizationStat.schemaCount = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/schemaCount');
								return res;
							};

							OptimizationStat.tableCount = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/tableCount');
								return res;
							};

							OptimizationStat.columnCount = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/columnCount');
								return res;
							};

							OptimizationStat.optimizationStatus = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/optimizationStatus');
								return res;
							};

							OptimizationStat.databases = function() {
								var res = $http
										.get('UniqueKeyOptimizationStatService/databases');
								return res;
							};

							OptimizationStat.schemas = function(connectionId) {
								var res = $http
										.get('UniqueKeyOptimizationStatService/schemas?connectionId='
												+ connectionId);
								return res;
							};

							OptimizationStat.tables = function(schemaId) {
								var res = $http
										.get('UniqueKeyOptimizationStatService/tables?schemaId='
												+ schemaId);
								return res;
							};

							OptimizationStat.columns = function(tableId) {
								var res = $http
										.get('UniqueKeyOptimizationStatService/columns?tableId='
												+ tableId);
								return res;
							};

							OptimizationStat.parentModel = function(id, type) {
								var res = $http
										.get('UniqueKeyOptimizationStatService/parentModel?id='
												+ id + '&type=' + type);
								return res;
							};

							OptimizationStat.viewData = function(columnId) {
								var res = $http
										.get('UniqueKeyOptimizationStatService/viewData?columnId='
												+ columnId);
								return res;
							};

							return OptimizationStat;
						} ]);