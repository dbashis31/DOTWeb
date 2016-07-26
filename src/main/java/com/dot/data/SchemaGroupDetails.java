package com.dot.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEMA_GROUP_DETAILS")
public class SchemaGroupDetails {

	@Column(name = "SCHEMA_GROUP_SCHEMA_ID")
	private String schemaId;

	@Column(name = "SCHEMA_GROUP_DETAILS_GROUP_ID")
	private String groupId;

	@Id
	@Column(name = "SCHEMA_GROUP_DETAILS_ID")
	private String detailId;

	public SchemaGroupDetails() {

	}

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

}
