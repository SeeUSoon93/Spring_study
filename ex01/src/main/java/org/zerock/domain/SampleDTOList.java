package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.bytecode.SignatureAttribute.ArrayType;

import lombok.Data;

@Data
public class SampleDTOList {

	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>(); 
	}
}
