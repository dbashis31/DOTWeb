package com.dot.web.controller.rest;



import java.io.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.dot.dao.UserAccountDao;
import com.dot.dao.UserAccountDaoImpl;
import com.dot.data.DBResult;
import com.dot.data.UserAccount;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Transactional
@RequestMapping(value="/UserService")
class UserService {

	@Autowired
	private UserAccountDao dao;
	
	@RequestMapping(value = "/Save/unprotected",method = RequestMethod.POST)
	@ResponseBody
	public  DBResult register( @RequestParam("ua") String ua, @RequestParam("file") MultipartFile file){
		//@RequestPart UserAccount ua
		ObjectMapper mapper = new ObjectMapper();
		UserAccount uab = new UserAccount();
		System.out.println("User name : "+ua);
		try {
			//UserAccount user = mapper.readValue(ua, UserAccount.class);
			List<UserAccount> myObjects = mapper.readValue(ua, mapper.getTypeFactory().constructCollectionType(List.class, UserAccount.class));
			for(int i=0;i<myObjects.size();i++){
				System.out.println(myObjects.get(i).getEmailID());
				System.out.println(myObjects.get(i).getPassword());
				
			}

			
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(pathURL);RequestPart
		uab.setFullName(uab.getUserName());
		 if (!file.isEmpty()) {
			 System.out.print("File :::"+file.getName());
			 try {
				byte[] bytes = file.getBytes();
				for(int i=0;i<bytes.length;i++){
					System.out.print(bytes[i]);	
					
				}
				BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\temp\\"+file.getName())));
                stream.write(bytes);
                stream.close();
                //return "You successfully uploaded " + file.getName() + "!";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		return null;
		
		
	}
	@RequestMapping(value = "/Get", method = RequestMethod.GET )	
	public @ResponseBody List<UserAccount> get(){
		System.out.println(dao);
		return dao.findAllUA();
	}
	
	 @RequestMapping(value="/upload", method=RequestMethod.POST)
	    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, 
	            @RequestParam("file") MultipartFile file){
	        if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream = 
	                        new BufferedOutputStream(new FileOutputStream(new File(name)));
	                stream.write(bytes);
	                stream.close();
	                return "You successfully uploaded " + name + "!";
	            } catch (Exception e) {
	                return "You failed to upload " + name + " => " + e.getMessage();
	            }
	        } else {
	            return "You failed to upload " + name + " because the file was empty.";
	        }
	    }
	
	
}
