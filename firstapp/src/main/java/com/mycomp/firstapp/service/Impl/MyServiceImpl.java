package com.mycomp.firstapp.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mycomp.firstapp.controller.AddController;
import com.mycomp.firstapp.dto.MyReq;
import com.mycomp.firstapp.service.MyService;

@Service
public class MyServiceImpl implements MyService {
	
	private static final Logger Logger= LoggerFactory.getLogger(AddController.class);
	
	private Gson gson;
	
	
	public MyServiceImpl(Gson gson) {
		Logger.info("MyServiceImpl constructor******** this:{} ", this);
		Logger.info("Gson: {}", gson);
		this.gson= gson;
	}

	@Override
	public String add(int val1, int val2) {
		Logger.info("val1: {}, val2:{}", val1,val2);
		int result= val1+ val2;
		
		MyReq myReq= new MyReq();
		 myReq.setNum1(val1);
		 myReq.setNum2(val2);
		 
		 
		Logger.info(" myReq:{}", myReq);
		
		//convert myReq obj to JSON string
		
		//String jsonString= com.google.gson.Gson().toJson(myReq);
		
		//Gson gson= new Gson();
		String jsonString= gson.toJson(myReq);
		
		
		Logger.info(" jsonString:{}", jsonString);
		
		//Logger.info(" result:{}", result);
		
		return  "From service:\n"+jsonString;
	}

}
