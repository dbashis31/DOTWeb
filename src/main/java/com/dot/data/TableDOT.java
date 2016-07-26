package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the "TABLE" database table.
 * 
 */
@Entity
@Table(name="\"TABLE\"")
@NamedQuery(name="TableDOT.findAll", query="SELECT t FROM TableDOT t")
public class TableDOT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TABLE_ID")
	private String tableId;

	@Column(name="TABLE_ADDED_BY")
	private String tableAddedBy;

	@Column(name="TABLE_ADDED_ON")
	private BigDecimal tableAddedOn;

	@Column(name="TABLE_ANALIZABLE_COLUMNS")
	private int tableAnalizableColumns;

	@Column(name="TABLE_BYTES")
	private BigDecimal tableBytes;

	@Column(name="TABLE_COLUMN_COUNT")
	private BigDecimal tableColumnCount;

	@Column(name="TABLE_DESC")
	private String tableDesc;

	@Column(name="TABLE_HASH")
	private String tableHash;

	@Column(name="TABLE_IS_DELETED")
	private String tableIsDeleted;

	@Column(name="TABLE_METADATA_HASH")
	private String tableMetadataHash;

	@Lob
	@Column(name="TABLE_METADATA_STRUCTURE")
	private byte[] tableMetadataStructure;

	@Column(name="TABLE_NAME")
	private String tableName;

	@Column(name="TABLE_RECORD_COUNT")
	private BigDecimal tableRecordCount;

	@Lob
	@Column(name="TABLE_STRUCTURE")
	private byte[] tableStructure;

	@Column(name="TABLE_TYPE")
	private String tableType;

	@Column(name="TABLE_UPDATED_ON")
	private BigDecimal tableUpdatedOn;

	@Column(name="TABLE_USER")
	private String tableUser;

	/*//bi-directional many-to-one association to Column
	@OneToMany(mappedBy="table")
	private List<Column> columns;*/

	/*//bi-directional many-to-one association to SimilarTable
	@OneToMany(mappedBy="table1")
	private List<SimilarTable> similarTables1;

	//bi-directional many-to-one association to SimilarTable
	@OneToMany(mappedBy="table2")
	private List<SimilarTable> similarTables2;*/

	//bi-directional many-to-one association to Schema
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TABLE_SCHEMA_ID", referencedColumnName="SCHEMA_ID")
	private SchemaDOT schema;*/

	@Column(name="TABLE_SCHEMA_ID")
	private String schemaId;
	
	public String getSchemaId() {
		return this.schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTableAddedBy() {
		return this.tableAddedBy;
	}

	public void setTableAddedBy(String tableAddedBy) {
		this.tableAddedBy = tableAddedBy;
	}

	public BigDecimal getTableAddedOn() {
		return this.tableAddedOn;
	}

	public void setTableAddedOn(BigDecimal tableAddedOn) {
		this.tableAddedOn = tableAddedOn;
	}

	public int getTableAnalizableColumns() {
		return this.tableAnalizableColumns;
	}

	public void setTableAnalizableColumns(int tableAnalizableColumns) {
		this.tableAnalizableColumns = tableAnalizableColumns;
	}

	public BigDecimal getTableBytes() {
		return this.tableBytes;
	}

	public void setTableBytes(BigDecimal tableBytes) {
		this.tableBytes = tableBytes;
	}

	public BigDecimal getTableColumnCount() {
		return this.tableColumnCount;
	}

	public void setTableColumnCount(BigDecimal tableColumnCount) {
		this.tableColumnCount = tableColumnCount;
	}

	public String getTableDesc() {
		return this.tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	public String getTableHash() {
		return this.tableHash;
	}

	public void setTableHash(String tableHash) {
		this.tableHash = tableHash;
	}

	public String getTableIsDeleted() {
		return this.tableIsDeleted;
	}

	public void setTableIsDeleted(String tableIsDeleted) {
		this.tableIsDeleted = tableIsDeleted;
	}

	public String getTableMetadataHash() {
		return this.tableMetadataHash;
	}

	public void setTableMetadataHash(String tableMetadataHash) {
		this.tableMetadataHash = tableMetadataHash;
	}

	public byte[] getTableMetadataStructure() {
		return this.tableMetadataStructure;
	}

	public void setTableMetadataStructure(byte[] tableMetadataStructure) {
		this.tableMetadataStructure = tableMetadataStructure;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public BigDecimal getTableRecordCount() {
		return this.tableRecordCount;
	}

	public void setTableRecordCount(BigDecimal tableRecordCount) {
		this.tableRecordCount = tableRecordCount;
	}

	public byte[] getTableStructure() {
		return this.tableStructure;
	}

	public void setTableStructure(byte[] tableStructure) {
		this.tableStructure = tableStructure;
	}

	public String getTableType() {
		return this.tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public BigDecimal getTableUpdatedOn() {
		return this.tableUpdatedOn;
	}

	public void setTableUpdatedOn(BigDecimal tableUpdatedOn) {
		this.tableUpdatedOn = tableUpdatedOn;
	}

	public String getTableUser() {
		return this.tableUser;
	}

	public void setTableUser(String tableUser) {
		this.tableUser = tableUser;
	}

	/*public List<Column> getColumns() {
		return this.columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}*/

	

	/*public List<SimilarTable> getSimilarTables1() {
		return this.similarTables1;
	}

	public void setSimilarTables1(List<SimilarTable> similarTables1) {
		this.similarTables1 = similarTables1;
	}
*/
	

	/*public SimilarTable removeSimilarTables1(SimilarTable similarTables1) {
		getSimilarTables1().remove(similarTables1);
		similarTables1.setTable1(null);

		return similarTables1;
	}*/

	/*public List<SimilarTable> getSimilarTables2() {
		return this.similarTables2;
	}

	public void setSimilarTables2(List<SimilarTable> similarTables2) {
		this.similarTables2 = similarTables2;
	}*/

	

	/*public SchemaDOT getSchema() {
		return this.schema;
	}

	public void setSchema(SchemaDOT schema) {
		this.schema = schema;
	}*/
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tableId != null ? tableId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TableDOT)) {
			return false;
		}
		TableDOT other = (TableDOT) object;
		if ((this.tableId == null && other.tableId != null)
				|| (this.tableId != null && !this.tableId.equals(other.tableId))) {
			return false;
		}
		return true;
	}

}