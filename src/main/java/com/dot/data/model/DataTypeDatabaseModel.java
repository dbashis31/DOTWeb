package com.dot.data.model;

import java.io.Serializable;

public class DataTypeDatabaseModel implements Serializable {

	public int serialNo;
	public String name;
	public String formattedName;
	public String id;
	public int schemaCount;
	public int tableCount;
	public int columnCount;
	public int nonOptcolumnCount;
	public int nonOptTableCount;
	public double percentage;
	public String parentId;
	public DataTypeDatabaseModel parentModel;
	public String value;
	public String value1;
	public String value2;
	public String value3;
	public String value4;
	public String value5;
	public String isOptimized;
	public String htmlString;

	public DataTypeDatabaseModel() {

	}

	public String getFormattedName() {
		return this.formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

	public String getHtmlString() {
		return this.htmlString;
	}

	public void setHtmlString(String htmlString) {
		this.htmlString = htmlString;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return this.value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return this.value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}
	
	public String getValue4() {
		return this.value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}
	
	public String getValue5() {
		return this.value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}

	public DataTypeDatabaseModel getParentModel() {
		return this.parentModel;
	}

	public String isOptimized() {
		return this.isOptimized;
	}

	public void setIsOptimized(String isOptimized) {
		this.isOptimized = isOptimized;
	}

	public void setParentModel(DataTypeDatabaseModel parentModel) {
		this.parentModel = parentModel;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getSerialNo() {
		return this.serialNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return this.id;
	}

	public void setSchemaCount(int schemaCount) {
		this.schemaCount = schemaCount;
	}

	public int getSchemaCount() {
		return this.schemaCount;
	}

	public void setTableCount(int tableCount) {
		this.tableCount = tableCount;
	}

	public int getTableCount() {
		return this.tableCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getColumnCount() {
		return this.columnCount;
	}

	public void setNonOptcolumnCount(int nonOptcolumnCount) {
		this.nonOptcolumnCount = nonOptcolumnCount;
	}

	public int getNonOptcolumnCount() {
		return this.nonOptcolumnCount;
	}

	public void setNonOptTableCount(int nonOptTableCount) {
		this.nonOptTableCount = nonOptTableCount;
	}

	public int getNonOptTableCount() {
		return this.nonOptTableCount;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getPercentage() {
		return this.percentage;
	}

}
