package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SIMILAR_TABLE database table.
 * 
 */
@Entity
@Table(name="SIMILAR_TABLE")
@NamedQuery(name="SimilarTable.findAll", query="SELECT s FROM SimilarTable s")
public class SimilarTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SIMILAR_TABLE_ID")
	private String similarTableId;

	@Column(name="SIMILAR_TABLE_ADDED_BY")
	private String similarTableAddedBy;

	@Column(name="SIMILAR_TABLE_ADDED_ON")
	private BigDecimal similarTableAddedOn;

	@Column(name="SIMILAR_TABLE_COL_MATCHED")
	private int similarTableColMatched;

	@Column(name="SIMILAR_TABLE_COL_MATCHED_PERC")
	private double similarTableColMatchedPerc;

	@Column(name="SIMILAR_TABLE_META_MATCHE_PERC")
	private double similarTableMetaMatchePerc;

	@Column(name="SIMILAR_TABLE_METADATA_MATCHED")
	private int similarTableMetadataMatched;

	@Column(name="SIMILAR_TABLE_ROW_MATCHED")
	private int similarTableRowMatched;

	@Column(name="SIMILAR_TABLE_ROW_MATCHED_PERC")
	private double similarTableRowMatchedPerc;
	
	@Column(name="SIMILAR_TABLE_TABLE_TWO_ID")
	private String similarTableTwoId;
	
	@Column(name="SIMILAR_TABLE_TABLE_ONE_ID")
	private String similarTableOneId;

	/*//bi-directional many-to-one association to Schema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SIMILAR_TABLE_SCHEMA_TWO_ID", referencedColumnName="SCHEMA_ID")
	private Schema schema1;

	//bi-directional many-to-one association to Schema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SIMILAR_TABLE_SCHEMA_ONE_ID", referencedColumnName="SCHEMA_ID")
	private Schema schema2;

	//bi-directional many-to-one association to Table
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SIMILAR_TABLE_TABLE_TWO_ID")
	private Table table1;

	//bi-directional many-to-one association to Table
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SIMILAR_TABLE_TABLE_ONE_ID")
	private Table table2;*/

	public SimilarTable() {
	}
	
	public String getSimilarTableTwoId() {
		return this.similarTableTwoId;
	}

	public void setSimilarTableTwoId(String similarTableTwoId) {
		this.similarTableTwoId = similarTableTwoId;
	}
	
	public String getSimilarTableOneId() {
		return this.similarTableOneId;
	}

	public void setSimilarTableOneId(String similarTableOneId) {
		this.similarTableOneId = similarTableOneId;
	}

	public String getSimilarTableId() {
		return this.similarTableId;
	}

	public void setSimilarTableId(String similarTableId) {
		this.similarTableId = similarTableId;
	}

	public String getSimilarTableAddedBy() {
		return this.similarTableAddedBy;
	}

	public void setSimilarTableAddedBy(String similarTableAddedBy) {
		this.similarTableAddedBy = similarTableAddedBy;
	}

	public BigDecimal getSimilarTableAddedOn() {
		return this.similarTableAddedOn;
	}

	public void setSimilarTableAddedOn(BigDecimal similarTableAddedOn) {
		this.similarTableAddedOn = similarTableAddedOn;
	}

	public int getSimilarTableColMatched() {
		return this.similarTableColMatched;
	}

	public void setSimilarTableColMatched(int similarTableColMatched) {
		this.similarTableColMatched = similarTableColMatched;
	}

	public double getSimilarTableColMatchedPerc() {
		return this.similarTableColMatchedPerc;
	}

	public void setSimilarTableColMatchedPerc(double similarTableColMatchedPerc) {
		this.similarTableColMatchedPerc = similarTableColMatchedPerc;
	}

	public double getSimilarTableMetaMatchePerc() {
		return this.similarTableMetaMatchePerc;
	}

	public void setSimilarTableMetaMatchePerc(double similarTableMetaMatchePerc) {
		this.similarTableMetaMatchePerc = similarTableMetaMatchePerc;
	}

	public int getSimilarTableMetadataMatched() {
		return this.similarTableMetadataMatched;
	}

	public void setSimilarTableMetadataMatched(int similarTableMetadataMatched) {
		this.similarTableMetadataMatched = similarTableMetadataMatched;
	}

	public int getSimilarTableRowMatched() {
		return this.similarTableRowMatched;
	}

	public void setSimilarTableRowMatched(int similarTableRowMatched) {
		this.similarTableRowMatched = similarTableRowMatched;
	}

	public double getSimilarTableRowMatchedPerc() {
		return this.similarTableRowMatchedPerc;
	}

	public void setSimilarTableRowMatchedPerc(double similarTableRowMatchedPerc) {
		this.similarTableRowMatchedPerc = similarTableRowMatchedPerc;
	}

	/*public Schema getSchema1() {
		return this.schema1;
	}

	public void setSchema1(Schema schema1) {
		this.schema1 = schema1;
	}

	public Schema getSchema2() {
		return this.schema2;
	}

	public void setSchema2(Schema schema2) {
		this.schema2 = schema2;
	}

	public Table getTable1() {
		return this.table1;
	}

	public void setTable1(Table table1) {
		this.table1 = table1;
	}

	public Table getTable2() {
		return this.table2;
	}

	public void setTable2(Table table2) {
		this.table2 = table2;
	}*/

}