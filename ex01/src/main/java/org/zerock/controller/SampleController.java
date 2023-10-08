package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

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
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list :"+list);
		
		return "ex02Bean";
		
	}
	
	//@InitBinder 사용하기 -  데이터가 자동으로 변환되지 않을 때 바인딩 하기
	// @InitBinder를 이용해 날짜를 변환할 수 있지만, 변수에 직접
	// @DateTimeFormat을 적용해도 변환 가능(이 경우 InitBinder는 필요하지 않음)
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo:"+todo);
		return "ex03";
	}

}
