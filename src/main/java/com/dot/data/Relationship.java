package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the CONFIGURATION database table.
 * 
 */
@Entity
@Table(name = "RELATIONSHIP")
public class Relationship implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RELATIONSHIP_ID")
	private String id;
	
	@Column(name = "RELATIONSHIP_ADDED_BY")
	private String addedBy;
	
	@Column(name = "RELATIONSHIP_CONFIDENCE")
	private double confidence;
	
	@Column(name = "RELATIONSHIP_CONSTRAINT_NAME")
	private String constrainName;
	
	@Column(name = "RELATIONSHIP_FK_COLUMN_ID")
	private String fkColumnId;
	
	@Column(name = "RELATIONSHIP_FK_TABLE_ID")
	private String fkTableId;
	
	@Column(name = "RELATIONSHIP_FKCOLUMN_NAME")
	private String fkColumnName;
	
	@Column(name = "RELATIONSHIP_FKTABLE_NAME")
	private String fkTableName;
	
	@Column(name = "RELATIONSHIP_HAS_SIMILAR_NAMES")
	private String hasSimilarName;
	
	@Column(name = "RELATIONSHIP_IS_DOCUMENTED")
	private String isDocumented;
	
	@Column(name = "RELATIONSHIP_NAME")
	private String name;
	
	@Column(name = "RELATIONSHIP_PK_COLUMN_ID")
	private String pkColumnId;
	
	@Column(name = "RELATIONSHIP_PK_TABLE_ID")
	private String pkTableId;
	
	@Column(name = "RELATIONSHIP_SCHEMA_ID")
	private String schemaId;
	
	@Column(name = "RELATIONSHIP_TABLE")
	private String table;

	public Relationship() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public String getConstrainName() {
		return constrainName;
	}

	public void setConstrainName(String constrainName) {
		this.constrainName = constrainName;
	}

	public String getFkColumnId() {
		return fkColumnId;
	}

	public void setFkColumnId(String fkColumnId) {
		this.fkColumnId = fkColumnId;
	}

	public String getFkTableId() {
		return fkTableId;
	}

	public void setFkTableId(String fkTableId) {
		this.fkTableId = fkTableId;
	}

	public String getFkColumnName() {
		return fkColumnName;
	}

	public void setFkColumnName(String fkColumnName) {
		this.fkColumnName = fkColumnName;
	}

	public String getFkTableName() {
		return fkTableName;
	}

	public void setFkTableName(String fkTableName) {
		this.fkTableName = fkTableName;
	}

	public String getHasSimilarName() {
		return hasSimilarName;
	}

	public void setHasSimilarName(String hasSimilarName) {
		this.hasSimilarName = hasSimilarName;
	}

	public String getDocumented() {
		return isDocumented;
	}

	public void setDocumented(String documented) {
		isDocumented = documented;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPkColumnId() {
		return pkColumnId;
	}

	public void setPkColumnId(String pkColumnId) {
		this.pkColumnId = pkColumnId;
	}

	public String getPkTableId() {
		return pkTableId;
	}

	public void setPkTableId(String pkTableId) {
		this.pkTableId = pkTableId;
	}

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}