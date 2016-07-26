package com.dot.web.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dot.dao.SimilarityDAO;
import com.dot.data.model.DataTypeDatabaseModel;
import com.dot.data.model.SimilarityModel;

@Controller
@Transactional
@RequestMapping(value = "/SimilarityService")
public class SimilarityService {

	@Autowired
	private SimilarityDAO dao;

	@RequestMapping(value = "/contextBasedSimilarityPercentage", method = RequestMethod.GET)
	public @ResponseBody
	double contextBasedSimilarityPercentage() {
		return dao.getContextBasedSimilarityPercentage();
	}

	@RequestMapping(value = "/schemaGroups", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> schemaGroups(String type) {
		return dao.getSchemaGroup(type);
	}

	@RequestMapping(value = "/similarDatabases", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> similarDatabases(String type) {
		return dao.getSimilarDatabases(type);
	}

	@RequestMapping(value = "/groupSchemas", method = RequestMethod.GET)
	public @ResponseBody
	List<DataTypeDatabaseModel> groupSchemas(String group) {
		return dao.getGroupSchemas(group);
	}

	@RequestMapping(value = "/dataBaseSimilarities", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> dataBaseSimilarities(String type,
			String connectionId, String connectionName) {
		return dao.getDataBaseSimilarities(type, connectionId, connectionName);
	}

	@RequestMapping(value = "/similarSchemas", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> similarSchemas(String type, String connectionId,
			String connectionId1) {
		return dao.getSimilarSchemas(type, connectionId, connectionId1);
	}

	@RequestMapping(value = "/similarTables", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> similarTables(String type, String id, String id1) {
		return dao.getSimilarTables(type, id, id1);
	}

	@RequestMapping(value = "/parentModel", method = RequestMethod.GET)
	public @ResponseBody
	SimilarityModel parentModel(String id, String id1, String type) {
		SimilarityModel model = dao.getParentModel(id, id1, type);
		return model;
	}

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public @ResponseBody
	String name(String id, String type) {
		return dao.getName(id, type);
	}

	@RequestMapping(value = "/similarColumns", method = RequestMethod.GET)
	public @ResponseBody
	List<SimilarityModel> similarColumns(String type, String id, String id1) {
		return dao.getSimilarColumns(type, id, id1);
	}
}
