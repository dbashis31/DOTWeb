/**
 * User service
 */
angular
		.module('dot.services.optimizationStat', [])
		.factory(
				'OptimizationStat',
				[
						'$http',
						function($http) {

							var OptimizationStat = {};

							OptimizationStat.databaseCount = function() {
								var res = $http
										.get('OptimizationStatService/databaseCount');
								return res;
							};

							OptimizationStat.schemaCount = function() {
								var res = $http
										.get('OptimizationStatService/schemaCount');
								return res;
							};

							OptimizationStat.tableCount = function() {
								var res = $http
										.get('OptimizationStatService/tableCount');
								return res;
							};

							OptimizationStat.columnCount = function() {
								var res = $http
										.get('OptimizationStatService/columnCount');
								return res;
							};

							OptimizationStat.optimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/optimizationStatus');
								return res;
							};

							OptimizationStat.databases = function() {
								var res = $http
										.get('OptimizationStatService/databases');
								return res;
							};

							OptimizationStat.schemas = function(connectionId) {
								var res = $http
										.get('OptimizationStatService/schemas?connectionId='
												+ connectionId);
								return res;
							};

							OptimizationStat.tables = function(schemaId) {
								var res = $http
										.get('OptimizationStatService/tables?schemaId='
												+ schemaId);
								return res;
							};

							OptimizationStat.columns = function(tableId) {
								var res = $http
										.get('OptimizationStatService/columns?tableId='
												+ tableId);
								return res;
							};

							OptimizationStat.parentModel = function(id, type) {
								var res = $http
										.get('OptimizationStatService/parentModel?id='
												+ id + '&type=' + type);
								return res;
							};

							OptimizationStat.viewData = function(columnId) {
								var res = $http
										.get('OptimizationStatService/viewData?columnId='
												+ columnId);
								return res;
							};

							OptimizationStat.overAllOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/overAllOptimizationStatus');
								return res;
							};

							OptimizationStat.dataTypeOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/dataTypeOptimizationStatus');
								return res;
							};
							OptimizationStat.sizeOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/sizeOptimizationStatus');
								return res;
							};
							OptimizationStat.indexOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/indexOptimizationStatus');
								return res;
							};
							OptimizationStat.relationshipOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/relationshipOptimizationStatus');
								return res;
							};
							OptimizationStat.uniqueKeyOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/uniqueKeyOptimizationStatus');
								return res;
							};
							OptimizationStat.databaseOptimizationStatus = function() {
								var res = $http
										.get('OptimizationStatService/databaseOptimizationStatus');
								return res;
							};
							OptimizationStat.schemaOptimizationStatus = function(connectionId) {
								var res = $http
										.get('OptimizationStatService/schemaOptimizationStatus?connectionId='
												+ connectionId);
								return res;
							};
							OptimizationStat.tableOptimizationStatus = function(schemaId) {
								var res = $http
										.get('OptimizationStatService/tableOptimizationStatus?schemaId='
												+ schemaId);
								return res;
							};

							return OptimizationStat;
						} ]);