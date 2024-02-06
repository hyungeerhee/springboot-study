package com.hyungeerhee.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hyungeerhee.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	public Estate selectEstate(@Param("id") int id);
	
	public List<Estate> selectEstateListByRentPrice(@Param("rent") int rentPrice);
	
	public List<Estate> selectEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
}
