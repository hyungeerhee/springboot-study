package com.hyungeerhee.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyungeerhee.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	public Estate selectEstate(@Param("id") int id);

}
