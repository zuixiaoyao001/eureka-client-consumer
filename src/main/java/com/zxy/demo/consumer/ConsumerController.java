package com.zxy.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate template;
	@RequestMapping(value="/msg0",method=RequestMethod.GET)
	public String getStr() {
		System.out.println("I am consumer msg0!");
		return template.getForEntity("http://provider/welcome", String.class).getBody();
	}
	
	@RequestMapping(value="/msg1",method=RequestMethod.GET)
	public String msg() {
		RestTemplate t = new RestTemplate();
		System.out.println("I am consumer msg1!");
		return t.getForEntity("http://127.0.0.1:1001/welcome", String.class).getBody();
	}
}
