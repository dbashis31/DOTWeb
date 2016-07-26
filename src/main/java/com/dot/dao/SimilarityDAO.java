package com.dot.dao;

import java.util.List;

import com.dot.data.model.DataTypeDatabaseModel;
import com.dot.data.model.SimilarityModel;

public interface SimilarityDAO {

	double getContextBasedSimilarityPercentage();

	List<SimilarityModel> getSchemaGroup(String type);

	List<SimilarityModel> getSimilarDatabases(String type);

	List<DataTypeDatabaseModel> getGroupSchemas(String group);

	List<SimilarityModel> getDataBaseSimilarities(String type,
			String connectionId, String connectionName);

	List<SimilarityModel> getSimilarSchemas(String type, String connectionId,
			String connectionId1);

	List<SimilarityModel> getSimilarTables(String type, String id, String id1);

	SimilarityModel getParentModel(String id, String id1, String type);

	String getName(String id, String type);

	List<SimilarityModel> getSimilarColumns(String type, String id, String id1);

}
