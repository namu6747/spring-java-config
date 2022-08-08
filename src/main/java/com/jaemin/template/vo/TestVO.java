package com.jaemin.template.vo;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class TestVO {
	
	private String id;
	private String pw;
	
	public TestVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	/*
	 * @NotBlank
	 * 
	 * @NotNull
	 * 
	 * @Range(min = 1000, max = 1000000)
	 * 
	 * @Max(value = 9999)
	 * 
	 * @Value("${file.dir}") private String temp;
	 */
}
