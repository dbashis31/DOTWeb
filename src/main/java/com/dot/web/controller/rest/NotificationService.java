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

import com.dot.dao.NotificationDao;
import com.dot.dao.UserAccountDao;
import com.dot.data.Notification;
import com.dot.data.UserAccount;

@Controller
@Transactional
@RequestMapping(value="/NotificationService")
public class NotificationService {

	@Autowired
	private NotificationDao dao;
	
	@RequestMapping(value = "/findLatestFive", method = RequestMethod.GET )	
	public @ResponseBody List<Notification> findLatestFive(){
		return dao.findLatestFive();
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET )	
	public @ResponseBody List<Notification> findAll(){
		return dao.findAll();
	}
	
	@RequestMapping(value = "/findByID", method = RequestMethod.GET )	
	public @ResponseBody Notification findByID(long notificationID){
		return dao.findByID(notificationID);
	}
	
	@RequestMapping(value = "/countNotification", method = RequestMethod.GET )	
	public @ResponseBody Long countNotification(){
		return dao.countNotification();
	}
}
