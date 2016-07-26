package com.dot.web.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dot.dao.SchemaDAO;

@Controller
@Transactional
@RequestMapping(value="/SchemaService")
public class SchemaService {
   
	@Autowired
	private SchemaDAO dao;
	
	@RequestMapping(value = "/countSchema", method = RequestMethod.GET )	
	public @ResponseBody Long countNotification(){
		return dao.countSchema();
	}
}
