package com.jaemin.template.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jaemin.template.vo.TestVO;

@Mapper
public interface TestDAO {
	
	void save(TestVO obj);
	
}











