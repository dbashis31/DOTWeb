package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SCHEMA_GROUP database table.
 * 
 */
@Entity
@Table(name="SCHEMA_GROUP")
@NamedQuery(name="SchemaGroup.findAll", query="SELECT s FROM SchemaGroup s")
public class SchemaGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCHEMA_GROUP_ID")
	private String schemaGroupId;

	@Column(name="SCHEMA_GROUP_NAME")
	private String schemaGroupName;

	@Column(name="SCHEMA_GROUP_SCHEMA_COUNT")
	private BigDecimal schemaGroupSchemaCount;
	
	@Column(name="SCHEMA_GROUP_TYPE")
	private String schemaGroupType;

	public SchemaGroup() {
	}
	
	public String getSchemaGroupType() {
		return this.schemaGroupType;
	}

	public void setSchemaGroupType(String schemaGroupType) {
		this.schemaGroupType = schemaGroupType;
	}

	public String getSchemaGroupId() {
		return this.schemaGroupId;
	}

	public void setSchemaGroupId(String schemaGroupId) {
		this.schemaGroupId = schemaGroupId;
	}

	public String getSchemaGroupName() {
		return this.schemaGroupName;
	}

	public void setSchemaGroupName(String schemaGroupName) {
		this.schemaGroupName = schemaGroupName;
	}

	public BigDecimal getSchemaGroupSchemaCount() {
		return this.schemaGroupSchemaCount;
	}

	public void setSchemaGroupSchemaCount(BigDecimal schemaGroupSchemaCount) {
		this.schemaGroupSchemaCount = schemaGroupSchemaCount;
	}

}