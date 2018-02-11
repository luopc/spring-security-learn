package com.luopc.web.controller;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class AsyncController {

	private Logger log = LoggerFactory.getLogger(AsyncController.class);

	@GetMapping
	public Callable<String> order() {
		log.info("主线程开始");
		Callable<String> result = new Callable<String>() {
			public String call() throws InterruptedException {
				log.info("副线程开始");
				Thread.sleep(1000);
				log.info("副线程结束");
				return "success";
			}
		};
		log.info("主线程返回");
		return result;
	}
	
	
	@GetMapping("/new")
	public void newOrder() {
		
	}

}
