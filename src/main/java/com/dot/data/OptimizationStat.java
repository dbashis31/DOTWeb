package com.dot.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SIMILAR_SCHEMA database table.
 * 
 */
@Entity
@Table(name="OPTIMIZATION_STAT")
public class OptimizationStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OPTIMIZATION_STAT_ID")
	private String optimizationStatId;

	@Column(name="OPTIMIZATION_STAT_SCHEMA_ID")
	private String optimizationStatSchemaId;

	@Column(name="OPTIMIZATION_STAT_TABLE_COUNT")
	private int optimizationStatTableCount;

	@Column(name="OPTIMIZATION_STAT_COLUMN_COUNT")
	private int optimizationStatColumnCount;

	@Column(name="OPTIMIZATION_STAT_TYPE")
	private String optimizationStatType;


	public OptimizationStat() {
		
	}

	public String getOptimizationStatId() {
		return this.optimizationStatId;
	}

	public void setOptimizationStatId(String optimizationStatId) {
		this.optimizationStatId = optimizationStatId;
	}

	public String getOptimizationStatSchemaId() {
		return this.optimizationStatSchemaId;
	}

	public void setOptimizationStatSchemaId(String optimizationStatSchemaId) {
		this.optimizationStatSchemaId = optimizationStatSchemaId;
	}


	public int getOptimizationStatTableCount() {
		return this.optimizationStatTableCount;
	}

	public void setOptimizationStatTableCount(int optimizationStatTableCount) {
		this.optimizationStatTableCount = optimizationStatTableCount;
	}

	public int getOptimizationStatColumnCount() {
		return this.optimizationStatColumnCount;
	}

	public void setOptimizationStatColumnCount(int optimizationStatColumnCount) {
		this.optimizationStatColumnCount = optimizationStatColumnCount;
	}

	public String getOptimizationStatType() {
		return this.optimizationStatType;
	}

	public void setOptimizationStatType(String optimizationStatType) {
		this.optimizationStatType = optimizationStatType;
	}

}