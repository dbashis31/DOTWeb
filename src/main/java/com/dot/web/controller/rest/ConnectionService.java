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

import com.dot.dao.ConnectionDAO;
import com.dot.dao.NotificationDao;
import com.dot.dao.UserAccountDao;
import com.dot.data.Connection;
import com.dot.data.Notification;
import com.dot.data.UserAccount;

@Controller
@Transactional
@RequestMapping(value="/ConnectionService")
public class ConnectionService {

	@Autowired
	private ConnectionDAO dao;
	
	@RequestMapping(value = "/countConnection", method = RequestMethod.GET )	
	public @ResponseBody Long countConnection(){
		return dao.countConnection();
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET )	
	public @ResponseBody List<Connection> findAll(){
		return dao.findAll();
	}
	
}
