package com.jaemin.template.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class TestVO {
	
	@NotNull
	@NotBlank
	private String id;
	@NotBlank
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
