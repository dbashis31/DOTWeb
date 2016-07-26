package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the PROCESS database table.
 * 
 */
@Entity
@NamedQuery(name="Process.findAll", query="SELECT p FROM Process p")
public class Process implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROCESS_ID")
	private String processId;

	@Column(name="PROCESS_END_TIME")
	private Long processEndTime;

	@Column(name="PROCESS_PARAMETER")
	private String processParameter;

	@Column(name="PROCESS_SERVER_NAME")
	private String processServerName;

	@Column(name="PROCESS_START_TIME")
	private Long processStartTime;

	@Column(name="PROCESS_STATUS")
	private String processStatus;
	
	@Column(name="PROCESS_GROUP_ID")
	private String processGroupId;

	/*//bi-directional many-to-one association to ProcessGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROCESS_GROUP_ID")
	private ProcessGroup processGroup;*/

	public Process() {
	}

	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	public String getprocessGroupId() {
		return this.processGroupId;
	}

	public void setprocessGroupId(String processGroupId) {
		this.processGroupId = processGroupId;
	}

	public Long getProcessEndTime() {
		return this.processEndTime;
	}

	public void setProcessEndTime(Long processEndTime) {
		this.processEndTime = processEndTime;
	}

	public String getProcessParameter() {
		return this.processParameter;
	}

	public void setProcessParameter(String processParameter) {
		this.processParameter = processParameter;
	}

	public String getProcessServerName() {
		return this.processServerName;
	}

	public void setProcessServerName(String processServerName) {
		this.processServerName = processServerName;
	}

	public Long getProcessStartTime() {
		return this.processStartTime;
	}

	public void setProcessStartTime(Long processStartTime) {
		this.processStartTime = processStartTime;
	}

	public String getProcessStatus() {
		return this.processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/*public ProcessGroup getProcessGroup() {
		return this.processGroup;
	}

	public void setProcessGroup(ProcessGroup processGroup) {
		this.processGroup = processGroup;
	}*/
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (processId != null ? processId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.processId == null && other.processId != null) || (this.processId != null && !this.processId.equals(other.processId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return processId;
    }

}