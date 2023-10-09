package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

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
	
	// @ModelAttribute 사용 - Model은 파라미터로 전달된 데이터는 존재하지 않지만 화면에서 필요한 데이터를 전달하기 위해 사용
	// 강제로 전달받은 파라미터를 Model에 담아 전달
	// 타입에 관계없이 무조건 전달되므로, 파라미터로 전달된 데이터를 다시 화면에서 사용할 때 유용 
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) { // value를 지정해줘야 함
		
		log.info("dto: "+ dto);
		log.info("page: "+ page);
		
		return "/sample/ex04";	
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.......");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.......");
		SampleDTO dto = new SampleDTO();
		dto.setAge(31);
		dto.setName("김군순");
		
		return dto;
	}
	
	// ResponseEntity 타입
	// HttpServletRequest, HttpServletResponse를 직접 행동하지 않아도 http 프로토콜의 헤더를 다루기 위해 사용
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("ex/07................");
		
		String msg = "{\"name\":\"김군순\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(msg, headers, HttpStatus.OK);
	}
	
	// 파일 업로드 처리
	// 1.파일 업로드 화면이동
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload............");
	}
	// 2. 파일 업로드 
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info("--------------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});		
	}
	
	
	

}
