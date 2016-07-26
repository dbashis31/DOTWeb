package com.dot.dao;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dot.data.model.DataTypeDatabaseModel;
import com.dot.data.model.OptimizationModel;

@Repository("optimizationStatDAO")
public class OptimizationStatImpl extends AbstractDao implements
		OptimizationStatDAO {

	private long totalTableCount = 0;

	@Override
	public long getDatabaseCount() {
		try {
			Query query = getSession().createQuery(
					" select count(distinct s.connectionId) "
							+ "from SchemaDOT s,OptimizationStat o "
							+ "where s.schemaId = o.optimizationStatSchemaId "
							+ "and o.optimizationStatType='DATA_TYPE'");
			return ((Long) query.iterate().next());
		} catch (NoResultException nr) {
			return 0l;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0l;
		}
	}

	@Override
	public long getSchemaCount() {
		try {
			Query query = getSession()
					.createQuery(
							"select count(*) from OptimizationStat where optimizationStatType='DATA_TYPE'");
			return ((Long) query.iterate().next());
		} catch (NoResultException nr) {
			return 0l;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0l;
		}
	}

	@Override
	public long getTableCount() {

		try {
			Query query = getSession()
					.createQuery(
							"select sum(optimizationStatTableCount) from OptimizationStat where optimizationStatType='DATA_TYPE'");
			return ((Long) query.iterate().next());
		} catch (NoResultException nr) {
			return 0l;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0l;
		}
	}

	@Override
	public long getColumnCount() {

		try {
			Query query = getSession()
					.createQuery(
							"select sum(optimizationStatColumnCount) from OptimizationStat where optimizationStatType='DATA_TYPE'");
			return ((Long) query.iterate().next());
		} catch (NoResultException nr) {
			return 0l;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0l;
		}
	}

	@Override
	public double getStatus() {
		try {
			Query query = getSession()
					.createQuery(
							"select sum(optimizationStatTableCount) from OptimizationStat where optimizationStatType='DATA_TYPE'");
			long columnCount = ((Long) query.iterate().next());

			Query query1 = getSession().createQuery(
					"select count(*) from TableDOT");
			long totalColumnCount = (Long) query1.iterate().next();

			long optimizedColumn = totalColumnCount - columnCount;
			System.out.println("columnCount : " + columnCount);
			System.out.println("totalColumnCount : " + totalColumnCount);
			System.out.println("optimizedColumn : " + optimizedColumn);

			return 100 - (((double) (totalColumnCount - optimizedColumn) / totalColumnCount) * 100);
		} catch (NoResultException nr) {
			return 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<DataTypeDatabaseModel> getDatabases() {

		List<DataTypeDatabaseModel> databaseModels = new ArrayList<>();

		Query statQuery = getSession().createQuery(
				"select s.connectionId," + "sum(o.optimizationStatTableCount) "
						+ "from SchemaDOT s,OptimizationStat o "
						+ "where s.schemaId = o.optimizationStatSchemaId "
						+ "and o.optimizationStatType='DATA_TYPE' "
						+ "group by s.connectionId");

		Map<String, Integer> connectionStatMap = new HashMap<>();
		List list = statQuery.list();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			String connectionId = row[0].toString();
			int columnCount = Integer.valueOf(row[1].toString());
			connectionStatMap.put(connectionId, columnCount);
		}

		Query query = getSession().createQuery(
				"select s.connectionId," + "c.connectionName," + "count(*),"
						+ "sum(s.schemaTableCount),"
						+ "sum(s.schemaColumnCount) "
						+ "from SchemaDOT s,Connection c "
						+ "where s.connectionId =c.connectionId "
						+ "group by s.connectionId,c.connectionName");

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		List list1 = query.list();
		int i = 1;
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String connectionId = row[0].toString();
			if (connectionStatMap.containsKey(connectionId)) {
				DataTypeDatabaseModel databaseModel = new DataTypeDatabaseModel();
				databaseModel.setId(connectionId);
				databaseModel.setName(row[1].toString());
				databaseModel
						.setSchemaCount(Integer.valueOf(row[2].toString()));
				databaseModel.setTableCount(Integer.valueOf(row[3].toString()));
				databaseModel
						.setColumnCount(Integer.valueOf(row[4].toString()));
				databaseModel.setNonOptTableCount(connectionStatMap
						.get(connectionId));
				databaseModel.setSerialNo(i++);

				int columnCount = Integer.valueOf(row[3].toString());
				int nonOptColumnCount = connectionStatMap.get(connectionId);
				int optColumnCount = columnCount - nonOptColumnCount;
				double percentage = 100 - (((double) (columnCount - optColumnCount) / columnCount) * 100);

				databaseModel.setPercentage(Double.valueOf(nf
						.format(percentage)));

				databaseModel
						.setFormattedName("<a href=\"#/home/dataTypeschema/"
								+ databaseModel.getId() + "/"
								+ databaseModel.getName()
								+ "\"} )\" style=\"color: #18A689\">"
								+ databaseModel.getName() + "</a>");

				String htmlString = "<div>" + databaseModel.getPercentage()
						+ "%<div class=\"progress progress-mini\">"
						+ "<div class=\"progress-bar\" style=\"width: "
						+ databaseModel.getPercentage()
						+ "%\"></div></div></div>";
				databaseModel.setHtmlString(htmlString);

				databaseModels.add(databaseModel);
			}

		}

		return databaseModels;
	}

	@Override
	public List<DataTypeDatabaseModel> getSchemas(String connectionId) {

		List<DataTypeDatabaseModel> schemaModels = new ArrayList<>();

		Query statQuery = getSession().createQuery(
				"select s.schemaId," + "o.optimizationStatTableCount, "
						+ "o.optimizationStatColumnCount "
						+ "from OptimizationStat o, SchemaDOT s "
						+ "where s.schemaId = o.optimizationStatSchemaId "
						+ "and o.optimizationStatType='DATA_TYPE' "
						+ "and s.connectionId='" + connectionId + "'");

		Map<String, Integer> tableStatMap = new HashMap<>();
		Map<String, Integer> columnStatMap = new HashMap<>();
		List list = statQuery.list();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			String schemaId = row[0].toString();
			int tableCount = Integer.valueOf(row[1].toString());
			int columnCount = Integer.valueOf(row[2].toString());
			tableStatMap.put(schemaId, tableCount);
			columnStatMap.put(schemaId, columnCount);
		}

		Query query = getSession().createQuery(
				"select s.schemaId," + "s.schemaName," + "count(*),"
						+ "sum(t.tableColumnCount), c.connectionName "
						+ "from SchemaDOT s,TableDOT t, Connection c "
						+ "where t.schemaId =s.schemaId "
						+ "and s.connectionId='" + connectionId + "' "
						+ "and c.connectionId=s.connectionId "
						+ "group by s.schemaId,s.schemaName,c.connectionName ");

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		List list1 = query.list();
		int i = 1;
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String schemaId = row[0].toString();

			if (tableStatMap.containsKey(schemaId)
					&& tableStatMap.get(schemaId) != 0) {
				DataTypeDatabaseModel databaseModel = new DataTypeDatabaseModel();
				databaseModel.setId(schemaId);
				databaseModel.setName(row[1].toString());
				databaseModel.setTableCount(Integer.valueOf(row[2].toString()));
				databaseModel
						.setColumnCount(Integer.valueOf(row[3].toString()));
				databaseModel.setNonOptTableCount(tableStatMap.get(schemaId));
				databaseModel.setNonOptcolumnCount(columnStatMap.get(schemaId));
				databaseModel.setSerialNo(i++);
				databaseModel.setParentId(connectionId);

				int columnCount = Integer.valueOf(row[2].toString());
				int nonOptColumnCount = tableStatMap.get(schemaId) == null ? 0
						: tableStatMap.get(schemaId);
				int optColumnCount = columnCount - nonOptColumnCount;
				double percentage = (columnCount == 0 || nonOptColumnCount == 0) ? 100
						: 100 - (((double) (columnCount - optColumnCount) / columnCount) * 100);

				System.out.println(row[1].toString() + " = " + schemaId + " = "
						+ percentage);

				databaseModel.setPercentage(Double.valueOf(nf
						.format(percentage)));

				String htmlString = "<div>" + databaseModel.getPercentage()
						+ "%<div class=\"progress progress-mini\">"
						+ "<div class=\"progress-bar\" style=\"width: "
						+ databaseModel.getPercentage()
						+ "%\"></div></div></div>";
				databaseModel.setHtmlString(htmlString);
				databaseModel
						.setFormattedName("<a href=\"#/home/dataTypeTable/"
								+ databaseModel.getId() + "/"
								+ databaseModel.getName()
								+ "\"} )\" style=\"color: #18A689\">"
								+ databaseModel.getName() + "</a>");

				DataTypeDatabaseModel parentModel = new DataTypeDatabaseModel();
				parentModel.setName(row[4].toString());
				parentModel.setId(connectionId);
				databaseModel.setParentModel(parentModel);

				schemaModels.add(databaseModel);
			}
		}

		return schemaModels;
	}

	@Override
	public List<DataTypeDatabaseModel> getTables(String schemaId) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<DataTypeDatabaseModel> tableModels = new ArrayList<>();

		Query query = getSession()
				.createQuery(
						"select t.tableId,"
								+ "t.tableName,"
								+ "count(*),"
								+ "t.tableColumnCount,s.schemaName "
								+ "from ColumnDOT c,TableDOT t,SchemaDOT s "
								+ "where  c.columnTableId = t.tableId "
								+ "and t.schemaId='"
								+ schemaId
								+ "' "
								+ "and s.schemaId=t.schemaId "
								+ "and c.columnIsDataTypeOptz='Y' "
								+ "group by s.schemaName,t.tableId,t.tableName,t.tableColumnCount ");

		List list1 = query.list();
		int i = 1;
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String tableId = row[0].toString();
			DataTypeDatabaseModel databaseModel = new DataTypeDatabaseModel();
			databaseModel.setId(tableId);
			databaseModel.setName(row[1].toString());
			databaseModel.setColumnCount(Integer.valueOf(row[3].toString()));
			databaseModel.setNonOptcolumnCount(Integer.valueOf(row[2]
					.toString()));

			int columnCount = Integer.valueOf(row[3].toString());
			int nonOptColumnCount = Integer.valueOf(row[2].toString());
			int optColumnCount = columnCount - nonOptColumnCount;
			double percentage = 100 - (((double) (columnCount - optColumnCount) / columnCount) * 100);

			databaseModel.setPercentage(Double.valueOf(nf.format(percentage)));
			databaseModel.setSerialNo(i++);
			databaseModel.setParentId(schemaId);

			String htmlString = "<div>" + databaseModel.getPercentage()
					+ "%<div class=\"progress progress-mini\">"
					+ "<div class=\"progress-bar\" style=\"width: "
					+ databaseModel.getPercentage() + "%\"></div></div></div>";
			databaseModel.setHtmlString(htmlString);
			databaseModel.setFormattedName("<a href=\"#/home/dataTypeColumn/"
					+ databaseModel.getId() + "/" + databaseModel.getName()
					+ "\"} )\" style=\"color: #18A689\">"
					+ databaseModel.getName() + "</a>");

			DataTypeDatabaseModel parentModel = new DataTypeDatabaseModel();
			parentModel.setName(row[4].toString());
			parentModel.setId(schemaId);
			databaseModel.setParentModel(parentModel);

			tableModels.add(databaseModel);

		}
		System.out.println(tableModels.size());

		return tableModels;
	}

	@Override
	public DataTypeDatabaseModel getParentModel(String id, String type) {
		if (type.equalsIgnoreCase("SCHEMA")) {
			Query query = getSession().createQuery(
					"select c.connectionId," + "c.connectionName "
							+ "from SchemaDOT s,Connection c "
							+ "where s.schemaId='" + id + "' "
							+ "and c.connectionId=s.connectionId ");

			Object o = query.list().get(0);
			Object[] row = (Object[]) o;
			DataTypeDatabaseModel parentModel = new DataTypeDatabaseModel();
			parentModel.setName(row[1].toString());
			parentModel.setId(row[0].toString());
			System.out.println("Parent Name" + parentModel.getName());
			return parentModel;
		}

		if (type.equalsIgnoreCase("TABLE")) {
			Query query = getSession().createQuery(
					"select c.connectionId,"
							+ "c.connectionName, s.schemaId, s.schemaName "
							+ "from SchemaDOT s,Connection c,TableDOT t "
							+ "where t.tableId='" + id + "' "
							+ "and t.schemaId=s.schemaId "
							+ "and c.connectionId=s.connectionId ");

			Object o = query.list().get(0);
			Object[] row = (Object[]) o;
			DataTypeDatabaseModel schemaModel = new DataTypeDatabaseModel();
			schemaModel.setName(row[3].toString());
			schemaModel.setId(row[2].toString());
			System.out.println("Parent Name" + schemaModel.getName());

			DataTypeDatabaseModel connectionModel = new DataTypeDatabaseModel();
			connectionModel.setName(row[1].toString());
			connectionModel.setId(row[0].toString());
			schemaModel.setParentModel(connectionModel);
			return schemaModel;
		}

		return null;
	}

	@Override
	public List<DataTypeDatabaseModel> getColumns(String tableId) {
		List<DataTypeDatabaseModel> columnModels = new ArrayList<>();

		Query query = getSession().createQuery(
				"select c.columnId," + "c.columnName," + "c.columnDataType,"
						+ "c.columnactualDataType," + "c.columnIsDataTypeOptz,"
						+ "t.tableName " + "from ColumnDOT c,TableDOT t "
						+ "where  c.columnTableId ='" + tableId + "' "
						+ "and t.tableId=c.columnTableId");

		List list1 = query.list();
		int i = 1;
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String columnId = row[0].toString();
			DataTypeDatabaseModel databaseModel = new DataTypeDatabaseModel();
			databaseModel.setId(columnId);

			databaseModel.setIsOptimized(row[4] == null ? "N" : row[4]
					.toString());

			databaseModel.setParentId(tableId);
			databaseModel.setSerialNo(i++);

			if (databaseModel.isOptimized().equalsIgnoreCase("Y")) {
				databaseModel.setName("<div style=\"color:red\">"
						+ row[1].toString() + "</div>");
				databaseModel.setValue("<div style=\"color:red\">"
						+ row[2].toString() + "</div>");
				databaseModel.setValue1("<div style=\"color:red\">"
						+ row[3].toString() + "</div>");
			} else {
				databaseModel.setName(row[1].toString());
				databaseModel.setValue(row[2].toString());
				databaseModel.setValue1(row[3].toString());
			}

			DataTypeDatabaseModel parentModel = new DataTypeDatabaseModel();
			parentModel.setName(row[5].toString());
			parentModel.setId(tableId);
			databaseModel.setParentModel(parentModel);

			databaseModel
					.setFormattedName("<a href=\"#\"} )\" style=\"color: #18A689\">View Data</a>");

			columnModels.add(databaseModel);

		}
		System.out.println(columnModels.size());

		return columnModels;
	}

	@Override
	public List<String> columnValues(String columnId) {
		List<String> data = new ArrayList<>();
		/*
		 * Query query = getSession() .createQuery(
		 * "select c.connectionId,c1.columnName,s.schemaName,t.tableName " +
		 * "from Connection c, SchemaDOT s, TableDOT t, ColumnDOT c1 " +
		 * "where c1.columnId='" + columnId + "' " +
		 * "and c1.columnTableId=t.tableId " + "and t.schemaId=s.schemaId " +
		 * "and s.connectionId=c.connectionId"); List list1 = query.list();
		 * Object[] row = (Object[]) list1.get(0); String connectionId =
		 * row[0].toString(); String columnName = row[1].toString(); String
		 * tableName = row[2].toString(); String schemaName = row[3].toString();
		 * 
		 * try { ConnectionObject connectionObject = ConnectionUtility
		 * .getConnectionInfo(connectionId); Connection conn = ConnectionUtility
		 * .checkInstanceConnection(connectionObject);
		 * 
		 * Query query1 = getSession().createQuery(
		 * "select c.connconfigColReqQuotes from Connconfig c where c.connconfigDbtype='"
		 * + connectionObject.getDbType() + "'"); List list2 = query.list();
		 * Object[] row1 = (Object[]) list2.get(0); String quote =
		 * row1[0].toString();
		 * 
		 * String selectQuery = "SELECT " + quote + columnName + quote +
		 * " FROM " + quote + schemaName + quote + "." + quote + tableName +
		 * quote;
		 * 
		 * System.out.println("selectQuery=" + selectQuery);
		 * Vector<Vector<Object>> dataVector = DataBaseUtility.getResults(
		 * selectQuery, conn, 1, 50);
		 * 
		 * for (Vector<Object> object : dataVector) { data.add(object.get(0) ==
		 * null ? "" : object.get(0).toString()); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */

		return data;
	}

	@Override
	public double getOverAllOptimizationStatus() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		Query query = getSession()
				.createQuery(
						"select count(*) from TableDOT t "
								+ "where  (tableIsDeleted is null OR tableIsDeleted ='N')");
		totalTableCount = ((Long) query.iterate().next());

		query = getSession().createQuery(
				"select count(distinct c.columnTableId) from ColumnDOT c "
						+ "where  (columnIsDataTypeOptz='Y' "
						+ "OR columnIsSizeOptz='Y' "
						+ "OR columnIsUniqueKeyOptz='Y' "
						+ "OR columnIsIndexOptz='Y')");
		long nonOptTableCount = ((Long) query.iterate().next());

		double percentage = ((double) (totalTableCount - nonOptTableCount) / totalTableCount) * 100;

		System.out.println("totalTableCount : " + totalTableCount);
		System.out.println("nonOptTableCount : " + nonOptTableCount);
		System.out.println("Percentage : " + (100 - percentage));

		return Double.valueOf(nf.format((percentage)));
	}

	@Override
	public double getDataTypeOptimizationStatus() {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		Query query = getSession()
				.createQuery(
						"select count(*) from TableDOT t "
								+ "where  (tableIsDeleted is null OR tableIsDeleted ='N')");
		long totalTableCount = ((Long) query.iterate().next());

		query = getSession().createQuery(
				"select sum(o.optimizationStatTableCount) from OptimizationStat o "
						+ "where optimizationStatType='DATA_TYPE'");
		long nonOptTableCount = ((Long) query.iterate().next());

		double percentage = ((double) (totalTableCount - nonOptTableCount) / totalTableCount) * 100;

		System.out
				.println("************************************************************************");

		System.out.println("Data TypePercentage : " + (percentage));

		return Double.valueOf(nf.format((percentage)));
	}

	@Override
	public double getSizeOptimizationStatus() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		Query query = getSession()
				.createQuery(
						"select count(*) from TableDOT t "
								+ "where  (tableIsDeleted is null OR tableIsDeleted ='N')");
		long totalTableCount = ((Long) query.iterate().next());

		query = getSession().createQuery(
				"select sum(o.optimizationStatTableCount) from OptimizationStat o "
						+ "where optimizationStatType='SIZE'");
		long nonOptTableCount = ((Long) query.iterate().next());

		double percentage = ((double) (totalTableCount - nonOptTableCount) / totalTableCount) * 100;

		System.out
				.println("************************************************************************");
		System.out.println("Size Percentage : " + (percentage));

		return Double.valueOf(nf.format((percentage)));
	}

	@Override
	public double getUniqueKeyOptimizationStatus() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		Query query = getSession()
				.createQuery(
						"select count(*) from TableDOT t "
								+ "where  (tableIsDeleted is null OR tableIsDeleted ='N')");
		long totalTableCount = ((Long) query.iterate().next());

		query = getSession().createQuery(
				"select sum(o.optimizationStatTableCount) from OptimizationStat o "
						+ "where optimizationStatType='UNIQUE_KEY'");
		long nonOptTableCount = ((Long) query.iterate().next());

		double percentage = ((double) (totalTableCount - nonOptTableCount) / totalTableCount) * 100;

		System.out
				.println("************************************************************************");
		System.out.println("Key Percentage : " + (percentage));

		return Double.valueOf(nf.format((percentage)));
	}

	@Override
	public double getIndexOptimizationStatus() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		Query query = getSession()
				.createQuery(
						"select count(*) from TableDOT t "
								+ "where  (tableIsDeleted is null OR tableIsDeleted ='N')");
		long totalTableCount = ((Long) query.iterate().next());

		query = getSession().createQuery(
				"select sum(o.optimizationStatTableCount) from OptimizationStat o "
						+ "where optimizationStatType='INDEX'");
		long nonOptTableCount = ((Long) query.iterate().next());

		double percentage = ((double) (totalTableCount - nonOptTableCount) / totalTableCount) * 100;

		System.out
				.println("************************************************************************");

		System.out.println("Index Percentage : " + (percentage));

		return Double.valueOf(nf.format((percentage)));
	}

	@Override
	public double getRelationShipOptimizationStatus() {
		// TODO Auto-generated method stub
		return 90;
	}

	@Override
	public List<OptimizationModel> getDatabaseOptimizationStatus() {
		List<OptimizationModel> models = new ArrayList<>();

		Query statQuery = getSession().createQuery(
				"select s.connectionId,o.optimizationStatType, "
						+ "sum(o.optimizationStatTableCount) "
						+ "from SchemaDOT s,OptimizationStat o "
						+ "where s.schemaId = o.optimizationStatSchemaId "
						+ "group by s.connectionId,o.optimizationStatType");

		Map<String, Map<String, Integer>> connectionStatMap = new HashMap<>();
		List list = statQuery.list();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			String connectionId = row[0].toString();
			String type = row[1].toString();

			Map<String, Integer> map = connectionStatMap.get(type);
			if (map == null) {
				map = new HashMap<String, Integer>();
				connectionStatMap.put(type, map);
			}
			map.put(connectionId, Integer.valueOf(row[2].toString()));
		}

		Query query = getSession().createQuery(
				"select c.connectionId," + "c.connectionName,"
						+ "count(t.tableId)"
						+ "from SchemaDOT s,Connection c, TableDOT t "
						+ "where s.connectionId =c.connectionId "
						+ "and t.schemaId=s.schemaId "
						+ "group by c.connectionId,c.connectionName");

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		List list1 = query.list();

		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String connectionId = row[0].toString();
			OptimizationModel databaseModel = new OptimizationModel();
			databaseModel.setId(connectionId);
			databaseModel.setName(row[1].toString());
			databaseModel.setFormattedName("<a href=\"#/home/schemaOptimize/"
					+ databaseModel.getId() + "/" + databaseModel.getName()
					+ "\"} )\" style=\"color: #18A689\">"
					+ databaseModel.getName() + "</a>");

			Map<String, Integer> map = connectionStatMap.get("DATA_TYPE");
			if (map == null || !map.containsKey(connectionId)) {
				databaseModel
						.setDataTypePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(connectionId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("SIZE");
			if (map == null || !map.containsKey(connectionId)) {
				databaseModel
						.setSizePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(connectionId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setSizePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setSizePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setSizePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("UNIQUE_KEY");
			if (map == null || !map.containsKey(connectionId)) {
				databaseModel
						.setUniqueKeyPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(connectionId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}

			}

			map = connectionStatMap.get("INDEX");
			if (map == null || !map.containsKey(connectionId)) {
				databaseModel
						.setIndexPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(connectionId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("RELATIONSHIP");
			if (map == null || !map.containsKey(connectionId)) {
				databaseModel
						.setRelationshipPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(connectionId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			models.add(databaseModel);
		}

		return models;
	}

	@Override
	public List<OptimizationModel> getSchemaOptimizationStatus(
			String connectionId) {
		List<OptimizationModel> models = new ArrayList<>();

		Query statQuery = getSession().createQuery(
				"select s.schemaId,o.optimizationStatType, "
						+ "o.optimizationStatTableCount "
						+ "from SchemaDOT s,OptimizationStat o "
						+ "where s.schemaId = o.optimizationStatSchemaId "
						+ "and s.connectionId='" + connectionId + "'");

		Map<String, Map<String, Integer>> connectionStatMap = new HashMap<>();
		List list = statQuery.list();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			String schemaId = row[0].toString();
			String type = row[1].toString();

			Map<String, Integer> map = connectionStatMap.get(type);
			if (map == null) {
				map = new HashMap<String, Integer>();
				connectionStatMap.put(type, map);
			}
			map.put(schemaId, Integer.valueOf(row[2].toString()));
		}

		Query query = getSession().createQuery(
				"select s.schemaId," + "s.schemaName," + "count(t.tableId)"
						+ "from SchemaDOT s, TableDOT t "
						+ "where s.connectionId ='" + connectionId + "' "
						+ "and t.schemaId=s.schemaId "
						+ "group by s.schemaId,s.schemaName");

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		List list1 = query.list();

		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String schemaId = row[0].toString();
			OptimizationModel databaseModel = new OptimizationModel();
			databaseModel.setId(schemaId);
			databaseModel.setName(row[1].toString());
			databaseModel.setFormattedName("<a href=\"#/home/tableOptimize/"
					+ databaseModel.getId() + "/" + databaseModel.getName()
					+ "\"} )\" style=\"color: #18A689\">"
					+ databaseModel.getName() + "</a>");

			Map<String, Integer> map = connectionStatMap.get("DATA_TYPE");
			if (map == null || !map.containsKey(schemaId)) {
				databaseModel
						.setDataTypePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(schemaId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("SIZE");
			if (map == null || !map.containsKey(schemaId)) {
				databaseModel
						.setSizePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(schemaId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setSizePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setSizePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setSizePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("UNIQUE_KEY");
			if (map == null || !map.containsKey(schemaId)) {
				databaseModel
						.setUniqueKeyPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(schemaId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}

			}

			map = connectionStatMap.get("INDEX");
			if (map == null || !map.containsKey(schemaId)) {
				databaseModel
						.setIndexPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(schemaId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("RELATIONSHIP");
			if (map == null || !map.containsKey(schemaId)) {
				databaseModel
						.setRelationshipPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(schemaId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			models.add(databaseModel);
		}

		return models;
	}

	@Override
	public List<OptimizationModel> getTableOptimizationStatus(String schemaId) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<OptimizationModel> tableModels = new ArrayList<>();

		Map<String, Map<String, Integer>> connectionStatMap = new HashMap<>();

		Query query = getSession().createQuery(
				"select t.tableId,count(*) " + "from ColumnDOT c,TableDOT t "
						+ "where  c.columnTableId = t.tableId "
						+ "and t.schemaId='" + schemaId + "' "
						+ "and c.columnIsDataTypeOptz='Y' "
						+ "group by t.tableId");
		connectionStatMap.put("DATA_TYPE", getTableMap(query.list()));

		query = getSession().createQuery(
				"select t.tableId,count(*) " + "from ColumnDOT c,TableDOT t "
						+ "where  c.columnTableId = t.tableId "
						+ "and t.schemaId='" + schemaId + "' "
						+ "and c.columnIsSizeOptz='Y' " + "group by t.tableId");
		connectionStatMap.put("SIZE", getTableMap(query.list()));

		query = getSession().createQuery(
				"select t.tableId,count(*) " + "from ColumnDOT c,TableDOT t "
						+ "where  c.columnTableId = t.tableId "
						+ "and t.schemaId='" + schemaId + "' "
						+ "and c.columnIsUniqueKeyOptz='Y' "
						+ "group by t.tableId");
		connectionStatMap.put("UNIQUE_KEY", getTableMap(query.list()));

		query = getSession()
				.createQuery(
						"select t.tableId,count(*) "
								+ "from ColumnDOT c,TableDOT t "
								+ "where  c.columnTableId = t.tableId "
								+ "and t.schemaId='" + schemaId + "' "
								+ "and c.columnIsIndexOptz='Y' "
								+ "group by t.tableId");
		connectionStatMap.put("INDEX", getTableMap(query.list()));

		query = getSession().createQuery(
				"select t.tableId," + "t.tableName,"
						+ "t.tableColumnCount, s.schemaName, s.schemaId "
						+ "from TableDOT t, SchemaDOT s "
						+ "where  t.schemaId='" + schemaId
						+ "' and s.schemaId=t.schemaId");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			String tableId = row[0].toString();
			OptimizationModel databaseModel = new OptimizationModel();
			databaseModel.setId(tableId);
			databaseModel.setName(row[1].toString());
			
			OptimizationModel parentModel = new OptimizationModel();
			parentModel.setName(row[3].toString());
			parentModel.setId(row[4].toString());
			databaseModel.setParentModel(parentModel);
			
			databaseModel.setParentId(schemaId);

			Map<String, Integer> map = connectionStatMap.get("DATA_TYPE");
			if (map == null || !map.containsKey(tableId)) {
				databaseModel
						.setDataTypePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(tableId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setDataTypePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("SIZE");
			if (map == null || !map.containsKey(tableId)) {
				databaseModel
						.setSizePercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(tableId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setSizePercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setSizePercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setSizePercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("UNIQUE_KEY");
			if (map == null || !map.containsKey(tableId)) {
				databaseModel
						.setUniqueKeyPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(tableId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setUniqueKeyPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}

			}

			map = connectionStatMap.get("INDEX");
			if (map == null || !map.containsKey(tableId)) {
				databaseModel
						.setIndexPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(tableId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setIndexPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			map = connectionStatMap.get("RELATIONSHIP");
			if (map == null || !map.containsKey(tableId)) {
				databaseModel
						.setRelationshipPercentage("<div style=\"color: #1AB394\">100</div>");
			} else {
				int tableCount = Integer.valueOf(row[2] == null ? "0" : row[2]
						.toString());
				int nonOptTableCount = map.get(tableId);
				double percentage = ((double) (tableCount - nonOptTableCount) / tableCount) * 100;

				if (percentage >= 90) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #1AB394\">"
									+ nf.format(percentage) + "</div>");
				} else if (percentage < 90 && percentage > 50) {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F8AC59\">"
									+ nf.format(percentage) + "</div>");
				} else {
					databaseModel
							.setRelationshipPercentage("<div style=\"color: #F36969\">"
									+ nf.format(percentage) + "</div>");
				}
			}

			tableModels.add(databaseModel);
		}

		return tableModels;
	}

	private Map<String, Integer> getTableMap(List list) {

		Map<String, Integer> map = new HashMap<>();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			String tableId = row[0].toString();
			map.put(tableId,
					row[1] == null ? 0 : Integer.valueOf(row[1].toString()));
		}
		return map;

	}
}
