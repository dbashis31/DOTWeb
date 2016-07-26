package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "\"COLUMN\"")
@NamedQuery(name = "ColumnDOT.findAll", query = "SELECT t FROM ColumnDOT t")
public class ColumnDOT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "COLUMN_NAME")
	private String columnName;

	@Id
	@Column(name = "COLUMN_ID")
	private String columnId;

	@Column(name = "COLUMN_TABLE_ID")
	private String columnTableId;
	@Column(name = "COLUMN_DATA_TYPE")
	private String columnDataType;
	@Column(name = "COLUMN_SIZE")
	private int columnSize;
	@Column(name = "COLUMN_ACTUAL_DATA_TYPE")
	private String columnactualDataType;
	@Column(name = "COLUMN_DEFAULT_VALUE")
	private String columnDefaultValue;
	@Column(name = "COLUMN_IS_INDEX")
	private String columnIsIndex;
	@Column(name = "COLUMN_IS_PRIMARY_KEY")
	private String columnIsPrimaryKey;
	@Column(name = "COLUMN_AVG_LENGTH")
	private int columnAvgLength;
	@Column(name = "COLUMN_MAX_LENGTH")
	private int columnMaxLength;
	@Column(name = "COLUMN_DISTINCT_VALUE")
	private int columnDistinctValue;
	@Column(name = "COLUMN_DISTINCT_PERCENTAGE")
	private double columnDistinctPercentage;
	@Column(name = "COLUMN_NULL_VALUES")
	private int columnNullValues;
	@Column(name = "COLUMN_NULL_PERCENTAGE")
	private double columnNullPercentage;
	@Column(name = "COLUMN_BLANK_VALUE")
	private int columnBlankValue;
	@Column(name = "COLUMN_BLANK_PERCENTAGE")
	private double columnBlankPercentage;
	@Column(name = "COLUMN_ADDED_BY")
	private String columnAddedBy;
	@Column(name = "COLUMN_ADDED_ON")
	private long columnAddedOn;
	@Column(name = "COLUMN_IS_DELETED")
	private String columnIsDeleted;
	@Column(name = "COLUMN_DECIMAL_DIGITS")
	private String columnDecimalDigits;
	@Column(name = "COLUMN_JAVA_TYPE")
	private int columnJavaType;
	@Column(name = "COLUMN_IS_NULLABLE")
	private String columnIsNullable;
	@Column(name = "COLUMN_ORDER")
	private int columnOrder;
	@Column(name = "COLUMN_DESCRIPTION")
	private String columnDescription;
	@Column(name = "COLUMN_CLASSIFICATION")
	private String columnClassification;
	@Column(name = "COLUMN_IS_RAW_TYPE")
	private String columnIsRawType;
	@Column(name = "COLUMN_IS_DATA_TYPE_OPTZ")
	private String columnIsDataTypeOptz;
	@Column(name = "COLUMN_IS_SIZE_OPTZ")
	private String columnIsSizeOptz;
	@Column(name = "COLUMN_IS_UNIQUE_KEY_OPTZ")
	private String columnIsUniqueKeyOptz;
	@Column(name = "COLUMN_IS_INDEX_OPTZ")
	private String columnIsIndexOptz;

	@Lob
	@Column(name = "COLUMN_BYTES")
	private byte[] columnBytes;
	
	public String getColumnIsIndexOptz() {
		return columnIsIndexOptz;
	}

	public void setColumnIsIndexOptz(String columnIsIndexOptz) {
		this.columnIsIndexOptz = columnIsIndexOptz;
	}

	public String getColumnIsUniqueKeyOptz() {
		return columnIsUniqueKeyOptz;
	}

	public void setColumnIsUniqueKeyOptz(String columnIsUniqueKeyOptz) {
		this.columnIsUniqueKeyOptz = columnIsUniqueKeyOptz;
	}

	public String getColumnIsSizeOptz() {
		return columnIsSizeOptz;
	}

	public void setColumnIsSizeOptz(String columnIsSizeOptz) {
		this.columnIsSizeOptz = columnIsSizeOptz;
	}

	public String getColumnIsDataTypeOptz() {
		return columnIsDataTypeOptz;
	}

	public void setColumnIsDataTypeOptz(String columnIsDataTypeOptz) {
		this.columnIsDataTypeOptz = columnIsDataTypeOptz;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getColumnTableId() {
		return columnTableId;
	}

	public void setColumnTableId(String columnTableId) {
		this.columnTableId = columnTableId;
	}

	public String getColumnDataType() {
		return columnDataType;
	}

	public void setColumnDataType(String columnDataType) {
		this.columnDataType = columnDataType;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public String getColumnactualDataType() {
		return columnactualDataType;
	}

	public void setColumnactualDataType(String columnactualDataType) {
		this.columnactualDataType = columnactualDataType;
	}

	public String getColumnDefaultValue() {
		return columnDefaultValue;
	}

	public void setColumnDefaultValue(String columnDefaultValue) {
		this.columnDefaultValue = columnDefaultValue;
	}

	public String getColumnIsIndex() {
		return columnIsIndex;
	}

	public void setColumnIsIndex(String columnIsIndex) {
		this.columnIsIndex = columnIsIndex;
	}

	public String getColumnIsPrimaryKey() {
		return columnIsPrimaryKey;
	}

	public void setColumnIsPrimaryKey(String columnIsPrimaryKey) {
		this.columnIsPrimaryKey = columnIsPrimaryKey;
	}

	public int getColumnAvgLength() {
		return columnAvgLength;
	}

	public void setColumnAvgLength(int columnAvgLength) {
		this.columnAvgLength = columnAvgLength;
	}

	public int getColumnMaxLength() {
		return columnMaxLength;
	}

	public void setColumnMaxLength(int columnMaxLength) {
		this.columnMaxLength = columnMaxLength;
	}

	public int getColumnDistinctValue() {
		return columnDistinctValue;
	}

	public void setColumnDistinctValue(int columnDistinctValue) {
		this.columnDistinctValue = columnDistinctValue;
	}

	public double getColumnDistinctPercentage() {
		return columnDistinctPercentage;
	}

	public void setColumnDistinctPercentage(double columnDistinctPercentage) {
		this.columnDistinctPercentage = columnDistinctPercentage;
	}

	public int getColumnNullValues() {
		return columnNullValues;
	}

	public void setColumnNullValues(int columnNullValues) {
		this.columnNullValues = columnNullValues;
	}

	public double getColumnNullPercentage() {
		return columnNullPercentage;
	}

	public void setColumnNullPercentage(double columnNullPercentage) {
		this.columnNullPercentage = columnNullPercentage;
	}

	public int getColumnBlankValue() {
		return columnBlankValue;
	}

	public void setColumnBlankValue(int columnBlankValue) {
		this.columnBlankValue = columnBlankValue;
	}

	public double getColumnBlankPercentage() {
		return columnBlankPercentage;
	}

	public void setColumnBlankPercentage(double columnBlankPercentage) {
		this.columnBlankPercentage = columnBlankPercentage;
	}

	public String getColumnAddedBy() {
		return columnAddedBy;
	}

	public void setColumnAddedBy(String columnAddedBy) {
		this.columnAddedBy = columnAddedBy;
	}

	public long getColumnAddedOn() {
		return columnAddedOn;
	}

	public void setColumnAddedOn(long columnAddedOn) {
		this.columnAddedOn = columnAddedOn;
	}

	public String getColumnIsDeleted() {
		return columnIsDeleted;
	}

	public void setColumnIsDeleted(String columnIsDeleted) {
		this.columnIsDeleted = columnIsDeleted;
	}

	public String getColumnDecimalDigits() {
		return columnDecimalDigits;
	}

	public void setColumnDecimalDigits(String columnDecimalDigits) {
		this.columnDecimalDigits = columnDecimalDigits;
	}

	public int getColumnJavaType() {
		return columnJavaType;
	}

	public void setColumnJavaType(int columnJavaType) {
		this.columnJavaType = columnJavaType;
	}

	public String getColumnIsNullable() {
		return columnIsNullable;
	}

	public void setColumnIsNullable(String columnIsNullable) {
		this.columnIsNullable = columnIsNullable;
	}

	public int getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}

	public String getColumnDescription() {
		return columnDescription;
	}

	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}

	public String getColumnClassification() {
		return columnClassification;
	}

	public void setColumnClassification(String columnClassification) {
		this.columnClassification = columnClassification;
	}

	public String getColumnIsRawType() {
		return columnIsRawType;
	}

	public void setColumnIsRawType(String columnIsRawType) {
		this.columnIsRawType = columnIsRawType;
	}

	public byte[] getColumnBytes() {
		return columnBytes;
	}

	public void setColumnBytes(byte[] columnBytes) {
		this.columnBytes = columnBytes;
	}
}
