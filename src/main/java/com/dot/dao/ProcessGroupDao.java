package com.dot.dao;

import java.util.List;

import com.dot.data.ProcessGroup;
import com.dot.data.model.ProcessGroupDo;


public interface ProcessGroupDao {
	
	List<ProcessGroupDo> getRunningProcressGroup();
	
	double getCompletionStatus(String groupId);
	
}