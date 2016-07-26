package com.dot.dao;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dot.data.model.DataTypeDatabaseModel;
import com.dot.data.model.SimilarityModel;

@Repository("SimilarityDAO")
public class SimilarityImpl extends AbstractDao implements SimilarityDAO {

	@Override
	public double getContextBasedSimilarityPercentage() {

		Query query = getSession().createQuery("SELECT COUNT(*) FROM TableDOT");
		long tableCount = ((Long) query.iterate().next());
		query = getSession()
				.createQuery(
						"SELECT similarSchemaSchemaOneId,MAX(similarSchemaTblMatched) FROM SimilarSchema "
								+ "GROUP BY similarSchemaSchemaOneId");

		long duplicateTableCount = 0;
		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			duplicateTableCount += Integer.valueOf(row[1].toString());
		}

		double totalPercentage = ((double) duplicateTableCount / tableCount) * 100;

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println("tableCount : " + tableCount);
		System.out.println("duplicateTableCount : " + duplicateTableCount);
		System.out.println("totalPercentage : " + (nf.format(totalPercentage)));

		return Double.valueOf(nf.format(totalPercentage));
	}

	@Override
	public List<SimilarityModel> getSchemaGroup(String type) {
		List<SimilarityModel> models = new ArrayList<>();

		Query query = getSession()
				.createQuery(
						"select s.schemaGroupName,s.schemaGroupId,s.schemaGroupSchemaCount "
								+ "from SchemaGroup s "
								+ "where s.schemaGroupType='"
								+ type
								+ "' and s.schemaGroupSchemaCount > 1 order by s.schemaGroupSchemaCount desc");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			SimilarityModel model = new SimilarityModel();
			model.setName(row[0].toString());
			model.setId(row[1].toString());
			model.setCount(Integer.valueOf(row[2].toString()));
			models.add(model);
		}

		return models;
	}

	@Override
	public List<SimilarityModel> getSimilarDatabases(String type) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<SimilarityModel> models = new ArrayList<>();

		Query query = getSession().createQuery(
				"SELECT c.connectionId,c.connectionName, COUNT(*) "
						+ "FROM TableDOT t, SchemaDOT s, Connection c "
						+ "WHERE s.connectionId=c.connectionId "
						+ "AND t.schemaId=s.schemaId "
						+ "GROUP BY c.connectionId,c.connectionName");
		List list = query.list();

		Map<String, List<String>> connectionSchemaMap = new HashMap<>();
		Map<String, Integer> connectionTableCountMap = new HashMap<>();

		query = getSession()
				.createQuery(
						"SELECT s.connectionId,d.similarSchemaSchemaOneId,MAX(d.similarSchemaTblMatched) "
								+ "FROM SimilarSchema d,SchemaDOT s "
								+ "WHERE s.schemaId=d.similarSchemaSchemaOneId "
								+ "GROUP BY s.connectionId,d.similarSchemaSchemaOneId ");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			List<String> schemaList = connectionSchemaMap
					.get(row[0].toString());
			if (schemaList == null) {
				schemaList = new ArrayList<>();
				connectionSchemaMap.put(row[0].toString(), schemaList);
			}
			if (!schemaList.contains(row[1].toString())) {
				schemaList.add(row[1].toString());
				if (connectionTableCountMap.containsKey(row[0].toString())) {
					connectionTableCountMap.put(row[0].toString(),
							connectionTableCountMap.get(row[0].toString())
									+ Integer.valueOf(row[2].toString()));
				} else {
					connectionTableCountMap.put(row[0].toString(),
							Integer.valueOf(row[2].toString()));
				}
			}

		}

		query = getSession()
				.createQuery(
						"SELECT s.connectionId,d.similarSchemaSchemaTwoId,MAX(d.similarSchemaTblMatched) "
								+ "FROM SimilarSchema d,SchemaDOT s "
								+ "WHERE s.schemaId=d.similarSchemaSchemaTwoId "
								+ "GROUP BY s.connectionId,d.similarSchemaSchemaTwoId ");

		list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			List<String> schemaList = connectionSchemaMap
					.get(row[0].toString());
			if (schemaList == null) {
				schemaList = new ArrayList<>();
				connectionSchemaMap.put(row[0].toString(), schemaList);
			}
			if (!schemaList.contains(row[1].toString())) {
				schemaList.add(row[1].toString());
				if (connectionTableCountMap.containsKey(row[0].toString())) {
					connectionTableCountMap.put(row[0].toString(),
							connectionTableCountMap.get(row[0].toString())
									+ Integer.valueOf(row[2].toString()));
				} else {
					connectionTableCountMap.put(row[0].toString(),
							Integer.valueOf(row[2].toString()));
				}
			}

		}

		for (Object o : list) {
			Object[] row = (Object[]) o;
			String connectionId = row[0].toString();
			String connectionName = row[1].toString();
			if (connectionTableCountMap.containsKey(connectionId)) {

				double percentage = ((double) connectionTableCountMap
						.get(connectionId) / Integer.valueOf(row[2].toString())) * 100;

				System.out.println("duplicate tables :"
						+ connectionTableCountMap.get(connectionId));
				System.out.println("total tables :"
						+ Integer.valueOf(row[2].toString()));
				System.out.println("percentage :" + percentage);

				SimilarityModel model = new SimilarityModel();
				model.setName(connectionName);
				model.setId(connectionId);
				model.setPercentage(Double.valueOf(nf.format(percentage)));
				String percentageHtml = "<div>" + model.getPercentage()
						+ "%<div class=\"progress progress-mini\">"
						+ "<div class=\"progress-bar\" style=\"width: "
						+ model.getPercentage() + "%\"></div></div></div>";
				model.setPercentageHtml(percentageHtml);
				model.setFormattedName("<a href=\"#/home/similarDatabase/"
						+ model.getId() + "/" + model.getName()
						+ "\"} )\" style=\"color: #18A689\">" + model.getName()
						+ "</a>");
				models.add(model);

			}
		}
		return models;
	}

	@Override
	public List<DataTypeDatabaseModel> getGroupSchemas(String group) {
		List<DataTypeDatabaseModel> models = new ArrayList<>();
		Query query = getSession()
				.createQuery(
						"SELECT c.connectionName, s.schemaName, s.schemaId, s.schemaTableCount, s.schemaColumnCount"
								+ " FROM Connection c,SchemaDOT s,SchemaGroupDetails d "
								+ "WHERE s.connectionId=c.connectionId "
								+ "AND s.schemaId=d.schemaId "
								+ "AND d.groupId='" + group + "'");
		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			DataTypeDatabaseModel model = new DataTypeDatabaseModel();
			model.setValue(row[0].toString());
			model.setName(row[1].toString());
			model.setId(row[2].toString());
			model.setTableCount(Integer.valueOf(row[3].toString()));
			model.setColumnCount(Integer.valueOf(row[3].toString()));
			models.add(model);
		}

		return models;
	}

	@Override
	public List<SimilarityModel> getDataBaseSimilarities(String type,
			String connectionId, String connectionName) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<SimilarityModel> models = new ArrayList<>();

		Query tableCountQuery = getSession().createQuery(
				"SELECT c.connectionId,c.connectionName, COUNT(*) "
						+ "FROM TableDOT t, SchemaDOT s, Connection c "
						+ "WHERE s.connectionId=c.connectionId "
						+ "AND t.schemaId=s.schemaId " + "AND c.connectionId='"
						+ connectionId + "' "
						+ "GROUP BY c.connectionId,c.connectionName");
		List tableCountList = tableCountQuery.list();
		int tableCOunt = 0;
		List list = tableCountQuery.list();
		for (Object o : list) {
			Object[] row = (Object[]) o;
			tableCOunt = Integer.valueOf(row[2].toString());
		}

		Map<String, Integer> countMap = new HashMap<>();
		Map<String, String> nameIdMap = new HashMap<>();
		Map<String, List<String>> connectionSchemaMap = new HashMap<>();

		Query query = getSession()
				.createQuery(
						"SELECT c1.connectionId,c1.connectionName, MAX(a.similarSchemaTblMatched), "
								+ "s.schemaId  "
								+ "FROM Connection c,Connection c1,SchemaDOT s,SchemaDOT s1, SimilarSchema a "
								+ "WHERE c.connectionId=s.connectionId "
								+ "AND c1.connectionId= s1.connectionId "
								+ "AND a.similarSchemaSchemaOneId=s.schemaId "
								+ "AND a.similarSchemaSchemaTwoId=s1.schemaId "
								+ "AND c.connectionId='"
								+ connectionId
								+ "' "
								+ "GROUP BY c1.connectionName, c1.connectionId, s.schemaId");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			List<String> schemaList = connectionSchemaMap
					.get(row[0].toString());
			if (schemaList == null) {
				schemaList = new ArrayList<>();
				connectionSchemaMap.put(row[0].toString(), schemaList);
			}
			if (!schemaList.contains(row[3].toString())) {
				schemaList.add(row[3].toString());
				if (countMap.containsKey(row[0].toString())) {
					countMap.put(
							row[0].toString(),
							countMap.get(row[0].toString())
									+ Integer.valueOf(row[2].toString()));
				} else {
					countMap.put(row[0].toString(),
							Integer.valueOf(row[2].toString()));
				}
			}
			nameIdMap.put(row[0].toString(), row[1].toString());

		}

		query = getSession()
				.createQuery(
						"SELECT c.connectionId,c.connectionName, MAX(a.similarSchemaTblMatched), "
								+ "s1.schemaId  "
								+ "FROM Connection c,Connection c1,SchemaDOT s,SchemaDOT s1, SimilarSchema a "
								+ "WHERE c.connectionId=s.connectionId "
								+ "AND c1.connectionId= s1.connectionId "
								+ "AND a.similarSchemaSchemaOneId=s.schemaId "
								+ "AND a.similarSchemaSchemaTwoId=s1.schemaId "
								+ "AND c1.connectionId='"
								+ connectionId
								+ "' "
								+ "GROUP BY c.connectionName, c.connectionId, s1.schemaId");

		list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			List<String> schemaList = connectionSchemaMap
					.get(row[0].toString());
			if (schemaList == null) {
				schemaList = new ArrayList<>();
				connectionSchemaMap.put(row[0].toString(), schemaList);
			}
			if (!schemaList.contains(row[3].toString())) {
				schemaList.add(row[3].toString());
				if (countMap.containsKey(row[0].toString())) {
					countMap.put(
							row[0].toString(),
							countMap.get(row[0].toString())
									+ Integer.valueOf(row[2].toString()));
				} else {
					countMap.put(row[0].toString(),
							Integer.valueOf(row[2].toString()));
				}
			}

			nameIdMap.put(row[0].toString(), row[1].toString());

		}

		for (String id : nameIdMap.keySet()) {

			if (countMap.containsKey(id)) {
				double percentage = ((double) countMap.get(id) / tableCOunt) * 100;

				SimilarityModel model = new SimilarityModel();
				model.setName(connectionName);
				model.setName1(nameIdMap.get(id));
				model.setId(connectionId);
				model.setId1(id);
				model.setPercentage(Double.valueOf(nf.format(percentage)));
				String percentageHtml = "<div>" + model.getPercentage()
						+ "%<div class=\"progress progress-mini\">"
						+ "<div class=\"progress-bar\" style=\"width: "
						+ model.getPercentage() + "%\"></div></div></div>";
				model.setPercentageHtml(percentageHtml);

				model.setFormattedName("<a href=\"#/home/similarSchemas/"
						+ model.getId() + "/" + model.getName() + "/"
						+ model.getId1() + "/" + model.getName1()
						+ "\"} )\" style=\"color: #18A689\">"
						+ model.getName1() + "</a>");

				System.out.println("duplicate tables :" + countMap.get(id));
				System.out.println("total tables :" + tableCOunt);
				System.out.println("percentage :" + percentage);

				models.add(model);
			}

		}

		return models;

	}

	@Override
	public List<SimilarityModel> getSimilarSchemas(String type,
			String connectionId, String connectionId1) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<SimilarityModel> models = new ArrayList<>();

		Query query = getSession()
				.createQuery(
						"SELECT c.connectionName, s.schemaName, s.schemaId, "
								+ "c1.connectionName, s1.schemaName, s1.schemaId, "
								+ "d.similarSchemaTblMatched,d.similarSchemaTblMatchedPer, "
								+ "s.schemaTableCount,s1.schemaTableCount,d.similarSchemaId,"
								+ "c.connectionId, c1.connectionId  "
								+ " FROM Connection c,SchemaDOT s,Connection c1,SchemaDOT s1,SimilarSchema d "
								+ "WHERE s.connectionId=c.connectionId "
								+ "AND s1.connectionId=c1.connectionId "
								+ "AND s.schemaId=d.similarSchemaSchemaOneId "
								+ "AND s1.schemaId=d.similarSchemaSchemaTwoId "
								+ "AND ((c.connectionId='" + connectionId
								+ "' " + "AND c1.connectionId='"
								+ connectionId1 + "') OR (c1.connectionId='"
								+ connectionId + "' " + "AND c.connectionId='"
								+ connectionId1 + "')) "
								+ "ORDER BY d.similarSchemaTblMatchedPer DESC");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			SimilarityModel model = new SimilarityModel();

			model.setCount(Integer.valueOf(row[6].toString()));
			model.setPercentage(Double.valueOf(nf.format(Double.valueOf(row[7]
					.toString()))));

			if (connectionId.equalsIgnoreCase(row[11].toString())) {
				model.setName(row[1].toString());
				model.setName1(row[4].toString());
				model.setId(row[2].toString());
				model.setId1(row[5].toString());
				model.setValue(row[0].toString());
				model.setValue1(row[3].toString());
				model.setTableCount(Integer.valueOf(row[8].toString()));
				model.setTableCount1(Integer.valueOf(row[9].toString()));

			} else {
				model.setName(row[4].toString());
				model.setName1(row[1].toString());
				model.setId(row[5].toString());
				model.setId1(row[2].toString());
				model.setValue(row[3].toString());
				model.setValue1(row[0].toString());
				model.setTableCount(Integer.valueOf(row[9].toString()));
				model.setTableCount1(Integer.valueOf(row[8].toString()));
			}

			model.setFormattedName("<a href=\"#/home/similarTables/"
					+ model.getId() + "/" + model.getName() + "/"
					+ model.getId1() + "/" + model.getName1()
					+ "\"} )\" style=\"color: #18A689\">"
					+ model.getPercentage() + "</a>");

			models.add(model);
		}

		return models;
	}

	@Override
	public List<SimilarityModel> getSimilarTables(String type, String id,
			String id1) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		List<SimilarityModel> models = new ArrayList<>();

		Query query = getSession()
				.createQuery(
						"SELECT t.tableName, t1.tableName, t.tableId, "
								+ "t1.tableId, t.tableColumnCount,"
								+ "t1.tableColumnCount,d.similarTableColMatched,"
								+ "d.similarTableColMatchedPerc,t.schemaId,t1.schemaId "
								+ "FROM TableDOT t,TableDOT t1,SimilarTable d "
								+ "WHERE t.tableId=d.similarTableOneId "
								+ "AND  t1.tableId=d.similarTableTwoId "
								+ "AND ((t.schemaId='"
								+ id
								+ "' AND t1.schemaId='"
								+ id1
								+ "') OR (t1.schemaId='"
								+ id
								+ "' AND t.schemaId='"
								+ id1
								+ "')) order by d.similarTableColMatchedPerc desc");

		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			SimilarityModel model = new SimilarityModel();
			if (id.equalsIgnoreCase(row[8].toString())) {
				model.setName(row[0].toString());
				model.setName1(row[1].toString());
				model.setId(row[2].toString());
				model.setId1(row[3].toString());
				model.setTableCount(Integer.valueOf(row[4].toString()));
				model.setTableCount1(Integer.valueOf(row[5].toString()));
			} else {
				model.setName(row[1].toString());
				model.setName1(row[0].toString());
				model.setId(row[3].toString());
				model.setId1(row[2].toString());
				model.setTableCount(Integer.valueOf(row[5].toString()));
				model.setTableCount1(Integer.valueOf(row[4].toString()));
			}

			model.setCount(Integer.valueOf(row[6].toString()));
			model.setPercentage(Double.valueOf(nf.format(Double.valueOf(row[7]
					.toString()))));
			String percentageHtml = "<div>" + model.getPercentage()
					+ "%<div class=\"progress progress-mini\">"
					+ "<div class=\"progress-bar\" style=\"width: "
					+ model.getPercentage() + "%\"></div></div></div>";
			model.setPercentageHtml(percentageHtml);

			model.setFormattedName("<a href=\"#/home/similarColumns/"
					+ model.getId() + "/" + model.getName() + "/"
					+ model.getId1() + "/" + model.getName1()
					+ "\"} )\" style=\"color: #18A689\">"
					+ model.getPercentage() + "</a>");

			models.add(model);
		}

		return models;
	}

	@Override
	public SimilarityModel getParentModel(String id, String id1, String type) {
		if (type.equalsIgnoreCase("TABLE")) {

			Query query = getSession().createQuery(
					"select c.connectionId," + "c.connectionName  "
							+ "from SchemaDOT s,Connection c "
							+ "where s.schemaId ='" + id + "' "
							+ "and c.connectionId=s.connectionId ");

			Object o = query.list().get(0);
			Object[] row = (Object[]) o;
			SimilarityModel parentModel = new SimilarityModel();
			parentModel.setName(row[1].toString());
			parentModel.setId(row[0].toString());

			query = getSession().createQuery(
					"select c.connectionId," + "c.connectionName  "
							+ "from SchemaDOT s,Connection c "
							+ "where s.schemaId ='" + id1 + "' "
							+ "and c.connectionId=s.connectionId ");

			o = query.list().get(0);
			row = (Object[]) o;
			SimilarityModel model = new SimilarityModel();
			model.setName(parentModel.getName());
			model.setId(parentModel.getId());
			model.setName1(row[1].toString());
			model.setId1(row[0].toString());
			model.setParentModel(parentModel);

			System.out.println("c1 : " + model.getName());
			System.out.println("c2 : " + model.getName1());
			return model;
		} else if (type.equalsIgnoreCase("COLUMN")) {
			Query query = getSession().createQuery(
					"select c.connectionId," + "c.connectionName,"
							+ "s.schemaName,s.schemaId,t.tableName  "
							+ "from SchemaDOT s,Connection c,TableDOT t "
							+ "where t.tableId ='" + id + "' "
							+ "and t.schemaId=s.schemaId "
							+ "and c.connectionId=s.connectionId ");

			Object o = query.list().get(0);
			Object[] row = (Object[]) o;
			SimilarityModel model = new SimilarityModel();
			model.setName(row[1].toString());
			model.setId(row[0].toString());

			query = getSession().createQuery(
					"select c.connectionId," + "c.connectionName,"
							+ "s.schemaName,s.schemaId,t.tableName   "
							+ "from SchemaDOT s,Connection c,TableDOT t "
							+ "where t.tableId ='" + id1 + "' "
							+ "and t.schemaId=s.schemaId "
							+ "and c.connectionId=s.connectionId ");

			Object o1 = query.list().get(0);
			Object[] row1 = (Object[]) o1;
			SimilarityModel model1 = new SimilarityModel();
			model1.setName(row1[1].toString());
			model1.setId(row1[0].toString());
			model1.setParentModel(model);

			SimilarityModel model2 = new SimilarityModel();
			model2.setName(row[2].toString());
			model2.setId(row[3].toString());
			model2.setName1(row1[2].toString());
			model2.setId1(row1[3].toString());
			model2.setParentModel(model1);

			return model2;
		}

		return null;
	}

	@Override
	public String getName(String id, String type) {
		if (type.equalsIgnoreCase("DATABASE")) {
			Query query = getSession().createQuery(
					"select c.connectionName  from Connection c where c.connectionId='"
							+ id + "' ");
			Object o = query.list().get(0);
			System.out.println("Name : " + o.toString());
			return o.toString();
		}
		return null;
	}

	@Override
	public List<SimilarityModel> getSimilarColumns(String type, String id,
			String id1) {
		List<SimilarityModel> models = new ArrayList<>();

		Query query = getSession().createQuery(
				"select c.columnName,c.columnId from ColumnDOT c "
						+ "where c.columnTableId ='" + id + "' ");
		Map<String, String> columns1 = new HashMap<>();
		List<String> colSet1 = new ArrayList();
		List list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			columns1.put(row[0].toString().toUpperCase(), row[0].toString());
			colSet1.add(row[0].toString());
		}

		query = getSession().createQuery(
				"select c.columnName,c.columnId from ColumnDOT c "
						+ "where c.columnTableId ='" + id1 + "' ");
		Map<String, String> columns2 = new HashMap<>();
		List<String> colSet2 = new ArrayList();
		list1 = query.list();
		for (Object o : list1) {
			Object[] row = (Object[]) o;
			columns2.put(row[0].toString().toUpperCase(), row[0].toString());
			colSet2.add(row[0].toString());
		}

		List<String> matchedColumns = new ArrayList<>();
		for (String column : columns1.keySet()) {
			if (columns2.containsKey(column)) {
				matchedColumns.add(column);
			}
		}

		int length = columns1.size();
		int length1 = columns2.size();
		if (length >= length1) {
			for (int i = 0; i < length; i++) {
				SimilarityModel model = new SimilarityModel();

				String col1 = colSet1.get(i);
				String col2 = "";
				if (i < length1) {
					col2 = colSet2.get(i);
				}
				if (matchedColumns.contains(col1.toUpperCase())) {
					model.setName("<div style=\"color:blue\">" + col1
							+ "</div>");
				} else {
					model.setName(col1);
				}
				if (matchedColumns.contains(col2.toUpperCase())) {
					model.setName1("<div style=\"color:blue\">" + col2
							+ "</div>");
				} else {
					model.setName1(col2);
				}
				models.add(model);

			}
		} else {
			for (int i = 0; i < length1; i++) {
				SimilarityModel model = new SimilarityModel();

				String col2 = colSet2.get(i);
				String col1 = "";
				if (i < length) {
					col1 = colSet1.get(i);
				}
				if (matchedColumns.contains(col1.toUpperCase())) {
					model.setName("<div style=\"color:blue\">" + col1
							+ "</div>");
				} else {
					model.setName(col1);
				}
				if (matchedColumns.contains(col2.toUpperCase())) {
					model.setName1("<div style=\"color:blue\">" + col2
							+ "</div>");
				} else {
					model.setName1(col2);
				}

				models.add(model);

			}
		}

		return models;
	}
}
