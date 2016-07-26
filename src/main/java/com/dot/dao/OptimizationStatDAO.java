package com.dot.dao;

import java.util.List;

import com.dot.data.model.*;

public interface OptimizationStatDAO {

	long getDatabaseCount();

	long getSchemaCount();

	long getTableCount();

	long getColumnCount();

	double getStatus();

	List<DataTypeDatabaseModel> getDatabases();

	List<DataTypeDatabaseModel> getSchemas(String connectionId);

	List<DataTypeDatabaseModel> getTables(String schemaId);
	
	List<DataTypeDatabaseModel> getColumns(String tableId);

	DataTypeDatabaseModel getParentModel(String id, String type);
	
	List<String> columnValues(String columnId);
	
	double getOverAllOptimizationStatus();
	
	double getDataTypeOptimizationStatus();
	
	double getSizeOptimizationStatus();
	
	double getUniqueKeyOptimizationStatus();
	
	double getIndexOptimizationStatus();
	
	double getRelationShipOptimizationStatus();
	
	List<OptimizationModel> getDatabaseOptimizationStatus();
	
	List<OptimizationModel> getSchemaOptimizationStatus(String connectionId);
	
	List<OptimizationModel> getTableOptimizationStatus(String schemaId);

}
