package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the CONFIGURATION database table.
 * 
 */
@Entity
@Table(name="CONFIGURATION")
@NamedQuery(name="Configuration.findAll", query="SELECT c FROM Configuration c")
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"KEY\"")
	private String key;

	@Id
	@Column(name="PROPERTY")
	private String property;

	@Column(name="VALUE")
	private String value;

	public Configuration() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}