package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value = "/basic",method = {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		log.info("basic............");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("basic get only get.........");
	}
	
	@PostMapping("/basicOnlyPost")
	public void basicpost() {
		log.info("basic get only Post.........");
	}
	
	@PutMapping("/basicOnlyPut")
	public void basicPut() {
		log.info("basic get only put.........");
	}
	
	@DeleteMapping("/basicOnlyDelete")
	public void basicDelete() {
		log.info("basic get only Delete.........");
	}
	
//	////////////////////////////////
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name, @RequestParam("age") int age) {
		log.info("name : "+name);
		log.info("age : "+age);
		
		return "ex02";
	}
	
//	리스트, 배열 처리
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")List<String> ids) {
		log.info("ids:"+ids);
		
		return "ex02List";
	}
	// 객체 리스트
	

}
