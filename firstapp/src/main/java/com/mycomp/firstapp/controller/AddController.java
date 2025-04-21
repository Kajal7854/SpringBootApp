package com.mycomp.firstapp.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.firstapp.service.MyService;

@RestController
@RequestMapping("/api")
public class AddController {
	
	private static final Logger Logger= LoggerFactory.getLogger(AddController.class);
	
	//@Autowired
	private MyService myService;
	
	private ApplicationContext applicationContext;
	
	private Random random;
	
	public AddController( MyService  myService,ApplicationContext applicationContext,
			Random random) {
		Logger.info("AddController constructor******** this:{} ", this);
		this.myService=myService;
		this.applicationContext=applicationContext;
		this.random= random;
	}
	
	@GetMapping("/add")
	public String add(@RequestParam int val1, @RequestParam int val2) {
		Logger.info("val1:"+val1+",val2:"+val2);
		
		
		
//		try {
//			throw new RuntimeException("Test Exception");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		//MyService myService = new MyServiceImpl();
		Logger.info("Object myService: {})",myService);
		
		myService= applicationContext.getBean(MyService.class);
		
		Logger.info("Dependency lookuped reference myService: {} ",myService );

		
		//get list of  all spring beans from application context
//		String[]beanNames = applicationContext.getBeanDefinitionNames();
//		
//		
//		Logger.info("=========");
//		for(String beanName : beanNames) {
//			Logger . info("Bean name: {}",beanName);
//		}
//		Logger.info("===========");
//		
		//Random random=new Random();
		
		int randomIntVal = random.nextInt(100);
		
		String result=myService.add(val1, val2);
		
		Logger.info("result: {}",result);
		
		return result + "\n| " + randomIntVal;
	}

}
