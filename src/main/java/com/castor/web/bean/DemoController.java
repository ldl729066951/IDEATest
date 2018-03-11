package com.castor.web.bean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/getDemo")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("aaa");
		return demo;
	}
	
	@RequestMapping("/zeroException")
	public int zeroException(){
		return 100/0;
	}
	
}
