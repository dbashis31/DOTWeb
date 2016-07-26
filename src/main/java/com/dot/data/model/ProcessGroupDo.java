package com.dot.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dot.data.ProcessGroup;


public class ProcessGroupDo implements Serializable {
	
	public ProcessGroup processGroup;
	
	public String completionStatus;
	
	public ProcessGroupDo(){

	}
	
	public void setProcessGroup(ProcessGroup processGroup){
		this.processGroup=processGroup;
	}
	
	public ProcessGroup getprocessGroup(){
		return this.processGroup;
	}
	
	public void setCompletionStatus(String completionStatus){
		this.completionStatus=completionStatus;
	}
	
	public String getCompletionStatus(){
		return completionStatus;
	}
	
}