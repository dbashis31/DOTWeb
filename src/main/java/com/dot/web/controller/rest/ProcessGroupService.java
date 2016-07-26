package com.dot.web.controller.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dot.dao.ProcessGroupDao;
import com.dot.data.ProcessGroup;
import com.dot.data.model.ProcessGroupDo;


@Controller
@Transactional
@RequestMapping(value="/ProcessGroupService")
public class ProcessGroupService {

	@Autowired
	private ProcessGroupDao dao;
	
	@RequestMapping(value = "/runningProcessGroup", method = RequestMethod.GET )	
	public @ResponseBody List<ProcessGroupDo> runningProcessGroup(){
		try{
		System.out.println("Process Size : "+ dao.getRunningProcressGroup().size());
		List<ProcessGroupDo> processGroups=dao.getRunningProcressGroup();
		for(ProcessGroupDo group:processGroups){
			System.out.println("Name : "+ group.getprocessGroup().getProcessGroupName());
			System.out.println("Status : "+ group.getCompletionStatus());
		}
		return dao.getRunningProcressGroup();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping(value = "/completionStatus", method = RequestMethod.GET )	
	public @ResponseBody Double completionStatus(String groupId){
		System.out.println("groupId : " + groupId);
		return dao.getCompletionStatus(groupId);
	}
	
}
