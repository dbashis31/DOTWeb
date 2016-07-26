package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SIMILAR_SCHEMA database table.
 * 
 */
@Entity
@Table(name="SIMILAR_SCHEMA")
@NamedQuery(name="SimilarSchema.findAll", query="SELECT s FROM SimilarSchema s")
public class SimilarSchema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SIMILAR_SCHEMA_ID")
	private String similarSchemaId;

	@Column(name="SIMILAR_SCHEMA_ADDED_BY")
	private String similarSchemaAddedBy;

	@Column(name="SIMILAR_SCHEMA_ADDED_ON")
	private BigDecimal similarSchemaAddedOn;

	@Column(name="SIMILAR_SCHEMA_META_MATCH_PER")
	private double similarSchemaMetaMatchPer;

	@Column(name="SIMILAR_SCHEMA_METADATA_MATCHED")
	private int similarSchemaMetadataMatched;

	@Column(name="SIMILAR_SCHEMA_ROW_MATCHED")
	private int similarSchemaRowMatched;

	@Column(name="SIMILAR_SCHEMA_ROW_MATCHED_PER")
	private double similarSchemaRowMatchedPer;

	@Column(name="SIMILAR_SCHEMA_SCHEMA_ONE_ID")
	private String similarSchemaSchemaOneId;

	@Column(name="SIMILAR_SCHEMA_SCHEMA_TWO_ID")
	private String similarSchemaSchemaTwoId;

	@Column(name="SIMILAR_SCHEMA_TBL_MATCHED")
	private int similarSchemaTblMatched;

	@Column(name="SIMILAR_SCHEMA_TBL_MATCHED_PER")
	private double similarSchemaTblMatchedPer;

	public SimilarSchema() {
	}

	public String getSimilarSchemaId() {
		return this.similarSchemaId;
	}

	public void setSimilarSchemaId(String similarSchemaId) {
		this.similarSchemaId = similarSchemaId;
	}

	public String getSimilarSchemaAddedBy() {
		return this.similarSchemaAddedBy;
	}

	public void setSimilarSchemaAddedBy(String similarSchemaAddedBy) {
		this.similarSchemaAddedBy = similarSchemaAddedBy;
	}

	public BigDecimal getSimilarSchemaAddedOn() {
		return this.similarSchemaAddedOn;
	}

	public void setSimilarSchemaAddedOn(BigDecimal similarSchemaAddedOn) {
		this.similarSchemaAddedOn = similarSchemaAddedOn;
	}

	public double getSimilarSchemaMetaMatchPer() {
		return this.similarSchemaMetaMatchPer;
	}

	public void setSimilarSchemaMetaMatchPer(double similarSchemaMetaMatchPer) {
		this.similarSchemaMetaMatchPer = similarSchemaMetaMatchPer;
	}

	public int getSimilarSchemaMetadataMatched() {
		return this.similarSchemaMetadataMatched;
	}

	public void setSimilarSchemaMetadataMatched(int similarSchemaMetadataMatched) {
		this.similarSchemaMetadataMatched = similarSchemaMetadataMatched;
	}

	public int getSimilarSchemaRowMatched() {
		return this.similarSchemaRowMatched;
	}

	public void setSimilarSchemaRowMatched(int similarSchemaRowMatched) {
		this.similarSchemaRowMatched = similarSchemaRowMatched;
	}

	public double getSimilarSchemaRowMatchedPer() {
		return this.similarSchemaRowMatchedPer;
	}

	public void setSimilarSchemaRowMatchedPer(double similarSchemaRowMatchedPer) {
		this.similarSchemaRowMatchedPer = similarSchemaRowMatchedPer;
	}

	public String getSimilarSchemaSchemaOneId() {
		return this.similarSchemaSchemaOneId;
	}

	public void setSimilarSchemaSchemaOneId(String similarSchemaSchemaOneId) {
		this.similarSchemaSchemaOneId = similarSchemaSchemaOneId;
	}

	public String getSimilarSchemaSchemaTwoId() {
		return this.similarSchemaSchemaTwoId;
	}

	public void setSimilarSchemaSchemaTwoId(String similarSchemaSchemaTwoId) {
		this.similarSchemaSchemaTwoId = similarSchemaSchemaTwoId;
	}

	public int getSimilarSchemaTblMatched() {
		return this.similarSchemaTblMatched;
	}

	public void setSimilarSchemaTblMatched(int similarSchemaTblMatched) {
		this.similarSchemaTblMatched = similarSchemaTblMatched;
	}

	public double getSimilarSchemaTblMatchedPer() {
		return this.similarSchemaTblMatchedPer;
	}

	public void setSimilarSchemaTblMatchedPer(double similarSchemaTblMatchedPer) {
		this.similarSchemaTblMatchedPer = similarSchemaTblMatchedPer;
	}

}