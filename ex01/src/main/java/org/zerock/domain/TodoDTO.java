package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	
	// @InitBinder를 이용해 날짜를 변환할 수 있지만, 여기서
	// @DateTimeFormat을 적용해도 변환 가능(이 경우 InitBinder는 필요하지 않음)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	// 문자열로 위의 형식이 맞으면 자동으로 날짜 타입으로 변환
	private Date dueDate;
	
}
