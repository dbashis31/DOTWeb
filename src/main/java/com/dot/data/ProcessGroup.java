package com.dot.data;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the PROCESS_GROUP database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="PROCESS_GROUP")
@NamedQuery(name="ProcessGroup.findAll", query="SELECT p FROM ProcessGroup p")
public class ProcessGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROCESS_GROUP_ID")
	private String processGroupId;

	@Column(name="PROCESS_GROUP_ADDED_BY")
	private String processGroupAddedBy;

	@Column(name="PROCESS_GROUP_END_TIME")
	private Long processGroupEndTime;

	@Column(name="PROCESS_GROUP_NAME")
	private String processGroupName;

	@Column(name="PROCESS_GROUP_START_TIME")
	private Long processGroupStartTime;

	@Column(name="PROCESS_GROUP_STATUS")
	private String processGroupStatus;

	@Column(name="PROCESS_GROUP_TASK_CLASS")
	private String processGroupTaskClass;

	/*//bi-directional many-to-one association to Process
	@OneToMany(mappedBy="processGroup")
	private List<Process> processes;*/

	public ProcessGroup() {
	}
	

	public String getProcessGroupId() {
		return this.processGroupId;
	}

	public void setProcessGroupId(String processGroupId) {
		this.processGroupId = processGroupId;
	}

	public String getProcessGroupAddedBy() {
		return this.processGroupAddedBy;
	}

	public void setProcessGroupAddedBy(String processGroupAddedBy) {
		this.processGroupAddedBy = processGroupAddedBy;
	}

	public Long getProcessGroupEndTime() {
		return this.processGroupEndTime;
	}

	public void setProcessGroupEndTime(Long processGroupEndTime) {
		this.processGroupEndTime = processGroupEndTime;
	}

	public String getProcessGroupName() {
		return this.processGroupName;
	}

	public void setProcessGroupName(String processGroupName) {
		this.processGroupName = processGroupName;
	}

	public Long getProcessGroupStartTime() {
		return this.processGroupStartTime;
	}

	public void setProcessGroupStartTime(Long processGroupStartTime) {
		this.processGroupStartTime = processGroupStartTime;
	}

	public String getProcessGroupStatus() {
		return this.processGroupStatus;
	}

	public void setProcessGroupStatus(String processGroupStatus) {
		this.processGroupStatus = processGroupStatus;
	}

	public String getProcessGroupTaskClass() {
		return this.processGroupTaskClass;
	}

	public void setProcessGroupTaskClass(String processGroupTaskClass) {
		this.processGroupTaskClass = processGroupTaskClass;
	}

	/*public List<Process> getProcesses() {
		return this.processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	public Process addProcess(Process process) {
		getProcesses().add(process);
		process.setProcessGroup(this);

		return process;
	}

	public Process removeProcess(Process process) {
		getProcesses().remove(process);
		process.setProcessGroup(null);

		return process;
	}
	
	public double getCompletionStatus(){
		double status=0;
		List<Process> processes=getProcesses();
		int processCount=processes.size();
		int finishedProcess=0;
		for(Process process:processes){
			if(process.getProcessStatus().equalsIgnoreCase("Finished") || process.getProcessStatus().equalsIgnoreCase("Failed")){
				finishedProcess ++;
			}
		}
		status=((double)(processCount-finishedProcess)/processCount)*100;
		System.out.print(status);
		return status;
	}*/
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (processGroupId != null ? processGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessGroup)) {
            return false;
        }
        ProcessGroup other = (ProcessGroup) object;
        if ((this.processGroupId == null && other.processGroupId != null) || (this.processGroupId != null && !this.processGroupId.equals(other.processGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return processGroupName;
    }

}