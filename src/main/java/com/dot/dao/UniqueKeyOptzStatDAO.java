package com.dot.dao;

import java.util.List;

import com.dot.data.model.DataTypeDatabaseModel;

public interface UniqueKeyOptzStatDAO {
	long getDatabaseCount();

	long getSchemaCount();

	long getTableCount();

	double getStatus();

	List<DataTypeDatabaseModel> getDatabases();

	List<DataTypeDatabaseModel> getSchemas(String connectionId);

	List<DataTypeDatabaseModel> getTables(String schemaId);

	List<DataTypeDatabaseModel> getColumns(String tableId);

	DataTypeDatabaseModel getParentModel(String id, String type);

	List<String> columnValues(String columnId);
}
