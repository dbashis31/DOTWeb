package com.dot.dao;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dot.data.Notification;
import com.dot.data.ProcessGroup;
import com.dot.data.Process;
import com.dot.data.model.ProcessGroupDo;

@Repository("procressGroupDao")
public class ProcessGroupDaoImpl extends AbstractDao implements ProcessGroupDao {

	@Override
	public List<ProcessGroupDo> getRunningProcressGroup() {
		List<ProcessGroupDo> models=new ArrayList<>();
		try {
		    Query query = getSession().createQuery("from ProcessGroup p "
		    		+ "where p.processGroupStatus ='Running' "
		    		+ "order by p.processGroupStartTime desc");
		     
		    List<ProcessGroup> processGroups = (List<ProcessGroup>)query.setMaxResults(5).list();
		    NumberFormat nf=NumberFormat.getInstance();
		    nf.setMaximumFractionDigits(2);
		    for(ProcessGroup group:processGroups){
		    	double completionStatus= getCompletionStatus(group.getProcessGroupId());
		    	ProcessGroupDo groupDo=new ProcessGroupDo();
		    	groupDo.setProcessGroup(group);
		    	groupDo.setCompletionStatus(completionStatus==0 ? "0%": nf.format(completionStatus) + "%");
		    	models.add(groupDo);
		    }
		    
		    return models;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public double getCompletionStatus(String groupId) {
		
		double status=0;
		Query processQuery = getSession().createQuery("from Process p "
    			+ "where p.processGroupId='"+ groupId +"' "
    			+ "order by p.processStartTime ");
    	
    	List<Process> processList = (List<Process>)processQuery.list();
    	int processCount=processList.size();
    	System.out.println("total : " + processCount);
		int finishedProcess=0;
		for(Process process:processList){
			if(process.getProcessStatus().equalsIgnoreCase("Finished") || process.getProcessStatus().equalsIgnoreCase("Failed")){
				finishedProcess ++;
			}
		}
		System.out.println("finishedProcess : " + finishedProcess);
		status=(100 - ((double)((double)processCount-finishedProcess)/processCount)*100);
		System.out.println(groupId + " = " + status);
		return status;
	}
	
	
	
	
	
}