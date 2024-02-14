package com.hyungeerhee.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.hyungeerhee.spring.test.jsp.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	public int insertRealtor(Realtor realtor);

}