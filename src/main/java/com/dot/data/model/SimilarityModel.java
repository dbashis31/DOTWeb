package com.dot.data.model;

public class SimilarityModel {

	private String name;
	private String id;
	private String name1;
	private String id1;
	private int count;
	private double percentage;
	private String percentageHtml;
	private String formattedName;
	private String value;
	private String value1;
	private int tableCount;
	private int tableCount1;
	public SimilarityModel parentModel;

	public void setParentModel(SimilarityModel parentModel) {
		this.parentModel = parentModel;
	}

	public SimilarityModel getParentModel() {
		return parentModel;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getPercentageHtml() {
		return percentageHtml;
	}

	public void setPercentageHtml(String percentageHtml) {
		this.percentageHtml = percentageHtml;
	}

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public int getTableCount() {
		return tableCount;
	}

	public void setTableCount(int tableCount) {
		this.tableCount = tableCount;
	}

	public int getTableCount1() {
		return tableCount1;
	}

	public void setTableCount1(int tableCount1) {
		this.tableCount1 = tableCount1;
	}

}
