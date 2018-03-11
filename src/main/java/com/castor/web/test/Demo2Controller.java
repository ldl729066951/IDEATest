package com.castor.web.test;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.castor.web.bean.Demo;
import com.castor.web.test.service.DemoService;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

	@Resource
	private DemoService demoService;
	
	@RequestMapping("/save")
	public String save(){
		Demo de = new Demo();
		de.setName("Angel");
		demoService.save(de);
		return "ok.save";
	}
	
	@RequestMapping(path="/get", method=RequestMethod.POST)
	public Object get(@RequestBody long id){
		return demoService.get(1);
	}
	
	@RequestMapping("/update")
	public Object update(){
		Demo de = new Demo();
		de.setId(1);
		de.setName("Scala");
		de.setId(1);
		demoService.save(de);
		return de;
	}
	
}
