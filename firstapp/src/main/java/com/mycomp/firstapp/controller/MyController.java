package com.mycomp.firstapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycomp.firstapp.pojo.NumReq;

@Controller
//@ResponseBody


//@RestController
@RequestMapping("/myctrl")
public class MyController {
	
	private Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@GetMapping
	public String getMethod() {
		return "hello";
	}
	
//	@GetMapping("/m2")
//	public String getMethod2() {
//		return "Hello from  getMethod()";
//	}
//	
//	@GetMapping("/m2")
//	public String getMethod3() {
//		return "Hello from  getMethod()";
//	}
	
	@PostMapping("/postm/{path1}/{path2}/process" )
	public String postMethod(@RequestParam("val1") int val1, 
			                 @RequestParam("val2") int val2,
	       @PathVariable("path1") String path1 ,
	       @PathVariable("path2") String path2,
	       @RequestHeader ("myHeader") String myHeader,
	       @RequestBody String reqBody)
	{
		
		ObjectMapper objectMapper = new ObjectMapper();
		NumReq numReq = null;
			try {
				 numReq =  objectMapper.readValue(reqBody, NumReq.class);
				logger.info("numReq:{}", numReq);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
        
            
        

        
        
		
		return "Hello from postMethod() |"
				+ "\n|val1:" + val1
				+ "\n| val2:"+ val2
				+"\n|path1:" + path1
				+"\n|path1:" + path2
				+"\n|myHeader:" + myHeader
				+"\n|reqBody:" + numReq;
		
	}
}
	


