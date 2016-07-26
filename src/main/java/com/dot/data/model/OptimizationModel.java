package com.dot.data.model;

import java.io.Serializable;

public class OptimizationModel implements Serializable {

	private String name;
	private String formattedName;
	private String id;
	private String dataTypePercentage;
	private String sizePercentage;
	private String uniqueKeyPercentage;
	private String indexPercentage;
	private String relationshipPercentage;
	private String totalPercentage;
	public OptimizationModel parentModel;
	public String parentId;

	public OptimizationModel() {

	}
	
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public void setParentModel(OptimizationModel parentModel) {
		this.parentModel = parentModel;
	}
	
	public OptimizationModel getParentModel() {
		return this.parentModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndexPercentage() {
		return indexPercentage;
	}

	public void setIndexPercentage(String indexPercentage) {
		this.indexPercentage = indexPercentage;
	}

	public String getUniqueKeyPercentage() {
		return uniqueKeyPercentage;
	}

	public void setUniqueKeyPercentage(String uniqueKeyPercentage) {
		this.uniqueKeyPercentage = uniqueKeyPercentage;
	}

	public String getSizePercentage() {
		return sizePercentage;
	}

	public void setSizePercentage(String sizePercentage) {
		this.sizePercentage = sizePercentage;
	}

	public String getDataTypePercentage() {
		return dataTypePercentage;
	}

	public void setDataTypePercentage(String dataTypePercentage) {
		this.dataTypePercentage = dataTypePercentage;
	}

	public String getRelationshipPercentage() {
		return relationshipPercentage;
	}

	public void setRelationshipPercentage(String relationshipPercentage) {
		this.relationshipPercentage = relationshipPercentage;
	}

	public String getTotalPercentage() {
		return totalPercentage;
	}

	public void setTotalPercentage(String totalPercentage) {
		this.totalPercentage = totalPercentage;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

}
