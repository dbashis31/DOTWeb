package com.dot.web.controller.rest;
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

import com.dot.dao.ColumnDAO;
import com.dot.dao.NotificationDao;
import com.dot.dao.TableDAO;
import com.dot.dao.UserAccountDao;
import com.dot.data.Notification;
import com.dot.data.UserAccount;

@Controller
@Transactional
@RequestMapping(value="/ColumnService")
public class ColumnService {
	@Autowired
	private ColumnDAO dao;
	
	@RequestMapping(value = "/countColumn", method = RequestMethod.GET )	
	public @ResponseBody Long countColumn(){
		return dao.countColumn();
	}
	
}
