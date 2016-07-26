package com.dot.web.controller.rest;

import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dot.dao.OptimizationStatDAO;
import com.dot.data.OptimizationStat;
import com.dot.data.model.DataTypeDatabaseModel;
import com.dot.data.model.OptimizationModel;

@Controller
@Transactional
@RequestMapping(value = "/OptimizationStatService")
public class OptimizationStatService {

	@Autowired
	private OptimizationStatDAO dao;

	@RequestMapping(value = "/databaseCount", method = RequestMethod.GET)
	public @ResponseBody
	Long databaseCount() {
		long count = dao.getDatabaseCount();
		System.out.println("databaseCount : " + count);
		return count;
	}

	@RequestMapping(value = "/schemaCount", method = RequestMethod.GET)
	public @ResponseBody
	Long schemaCount() {
		long count = dao.getSchemaCount();
		System.out.println("schemaCount : " + count);
		return count;
	}

	@RequestMapping(value = "/tableCount", method = RequestMethod.GET)
	public @ResponseBody
	Long tableCount() {
		long count = dao.getTableCount();
		System.out.println("tableCount : " + count);
		return count;
	}

	@RequestMapping(value = "/columnCount", method = RequestMethod.GET)
	public @ResponseBody
	Long columnCount() {
		long count = dao.getColumnCount();
		System.out.println("columnCount : " + count);
		return count;
	}

	@RequestMapping(value = "/optimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double optimizationStatus() {
		double status = dao.getStatus();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println("optimizationStatus : " + status);
		return Double.valueOf(nf.format(status));
	}

	@RequestMapping(value = "/databases", method = RequestMethod.GET)
	public @ResponseBody
	List<DataTypeDatabaseModel> databases() {
		List<DataTypeDatabaseModel> models = dao.getDatabases();
		for (DataTypeDatabaseModel model : models) {
			System.out.println("name : " + model.getName());
			System.out.println("schemaCount : " + model.getSchemaCount());
			System.out.println("tableCOunt : " + model.getTableCount());
			System.out.println("columnCount : " + model.getColumnCount());
			System.out.println("nonOptColumnCOunt : "
					+ model.getNonOptcolumnCount());
			System.out.println("percentage : " + model.getPercentage());
			System.out
					.println("--------------------------------------------------------------");
		}
		return models;
	}

	@RequestMapping(value = "/schemas", method = RequestMethod.GET)
	public @ResponseBody
	List<DataTypeDatabaseModel> schemas(String connectionId) {
		List<DataTypeDatabaseModel> models = dao.getSchemas(connectionId);
		for (DataTypeDatabaseModel model : models) {
			System.out.println("name : " + model.getName());
			System.out.println("id : " + model.getId());
			System.out.println("schemaCount : " + model.getSchemaCount());
			System.out.println("tableCOunt : " + model.getTableCount());
			System.out.println("columnCount : " + model.getColumnCount());
			System.out.println("nonOptColumnCOunt : "
					+ model.getNonOptcolumnCount());
			System.out.println("percentage : " + model.getPercentage());
			System.out
					.println("--------------------------------------------------------------");
		}
		return models;
	}

	@RequestMapping(value = "/columns", method = RequestMethod.GET)
	public @ResponseBody
	List<DataTypeDatabaseModel> columns(String tableId) {
		List<DataTypeDatabaseModel> models = dao.getColumns(tableId);
		for (DataTypeDatabaseModel model : models) {
			System.out.println("name : " + model.getName());
			System.out
					.println("--------------------------------------------------------------");
		}
		return models;
	}

	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public @ResponseBody
	List<DataTypeDatabaseModel> tables(String schemaId) {
		List<DataTypeDatabaseModel> models = dao.getTables(schemaId);
		for (DataTypeDatabaseModel model : models) {
			System.out.println("name : " + model.getName());
			System.out.println("columnCount : " + model.getColumnCount());
			System.out.println("nonOptColumnCOunt : "
					+ model.getNonOptcolumnCount());
			System.out.println("percentage : " + model.getPercentage());
			System.out
					.println("--------------------------------------------------------------");
		}
		return models;
	}

	@RequestMapping(value = "/parentModel", method = RequestMethod.GET)
	public @ResponseBody
	DataTypeDatabaseModel parentModel(String id, String type) {
		DataTypeDatabaseModel model = dao.getParentModel(id, type);
		return model;
	}

	@RequestMapping(value = "/viewData", method = RequestMethod.GET)
	public @ResponseBody
	List<String> viewData(String columnId) {
		List<String> data = dao.columnValues(columnId);
		return data;
	}

	@RequestMapping(value = "/overAllOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double overAllOptimizationStatus() {
		return dao.getOverAllOptimizationStatus();
	}

	@RequestMapping(value = "/dataTypeOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double dataTypeOptimizationStatus() {
		return dao.getDataTypeOptimizationStatus();
	}

	@RequestMapping(value = "/sizeOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double sizeOptimizationStatus() {
		return dao.getSizeOptimizationStatus();
	}

	@RequestMapping(value = "/uniqueKeyOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double uniqueKeyOptimizationStatus() {
		return dao.getUniqueKeyOptimizationStatus();
	}

	@RequestMapping(value = "/indexOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double indexOptimizationStatus() {
		return dao.getIndexOptimizationStatus();
	}

	@RequestMapping(value = "/relationshipOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	double relationshipOptimizationStatus() {
		return dao.getRelationShipOptimizationStatus();
	}

	@RequestMapping(value = "/databaseOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	List<OptimizationModel> databaseOptimizationStatus() {
		return dao.getDatabaseOptimizationStatus();
	}

	@RequestMapping(value = "/schemaOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	List<OptimizationModel> schemaOptimizationStatus(String connectionId) {
		return dao.getSchemaOptimizationStatus(connectionId);
	}

	@RequestMapping(value = "/tableOptimizationStatus", method = RequestMethod.GET)
	public @ResponseBody
	List<OptimizationModel> tableOptimizationStatus(String schemaId) {
		return dao.getTableOptimizationStatus(schemaId);
	}

}
