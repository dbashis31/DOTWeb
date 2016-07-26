/**
 * User service
 */
angular
		.module('dot.services.similarity', [])
		.factory(
				'Similarity',
				[
						'$http',
						function($http) {

							var Similarity = {};

							Similarity.contextBasedSimilarityPercentage = function() {
								var res = $http
										.get('SimilarityService/contextBasedSimilarityPercentage');
								return res;
							};

							Similarity.schemaGroups = function(type) {
								var res = $http
										.get('SimilarityService/schemaGroups?type='
												+ type);
								return res;
							};
							Similarity.similarDatabases = function(type) {
								var res = $http
										.get('SimilarityService/similarDatabases?type='
												+ type);
								return res;
							};
							Similarity.groupSchemas = function(group) {
								var res = $http
										.get('SimilarityService/groupSchemas?group='
												+ group);
								return res;
							};
							Similarity.dataBaseSimilarities = function(type,
									connectionId, connectionName) {
								var res = $http
										.get('SimilarityService/dataBaseSimilarities?type='
												+ type
												+ '&connectionId='
												+ connectionId
												+ '&connectionName='
												+ connectionName);
								return res;
							};
							Similarity.similarSchemas = function(type,
									connectionId, connectionId1) {
								var res = $http
										.get('SimilarityService/similarSchemas?type='
												+ type
												+ '&connectionId='
												+ connectionId
												+ '&connectionId1='
												+ connectionId1);
								return res;
							};
							Similarity.similarTables = function(type, id, id1) {
								var res = $http
										.get('SimilarityService/similarTables?type='
												+ type
												+ '&id='
												+ id
												+ '&id1='
												+ id1);
								return res;
							};
							Similarity.parentModel = function(id, id1, type) {
								var res = $http
										.get('SimilarityService/parentModel?id='
												+ id
												+ '&id1='
												+ id1
												+ '&type='
												+ type);
								return res;
							};

							Similarity.name = function(id, type) {
								var res = $http
										.get('SimilarityService/name?id=' + id
												+ '&type=' + type);
								return res;
							};
							Similarity.similarColumns = function(type, id, id1) {
								var res = $http
										.get('SimilarityService/similarColumns?type='
												+ type
												+ '&id='
												+ id
												+ '&id1='
												+ id1);
								return res;
							};

							return Similarity;
						} ]);