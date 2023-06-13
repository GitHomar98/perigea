package com.example.demo.controller;

import java.util.Timer;

//import java.util.Timer;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DataExtractor;


@RestController
class RestControl {
	
	//private static final int INTERVAL = 24 * 60 * 60 * 1000; // 24 ore in millisecondi
	
	@Autowired
	public DataExtractor e;

	@PostConstruct
	@GetMapping("/dataExtractor")
	public void init() {
    e.run();
    
    //Timer timer = new Timer();
    //timer.scheduleAtFixedRate(new DataExtractor(), 0, INTERVAL);
	}
}