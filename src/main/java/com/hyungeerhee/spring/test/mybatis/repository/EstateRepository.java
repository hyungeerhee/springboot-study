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
	
	public int insertEstateByObject(Estate estate);
	//insert는 행의 개수를 리턴해 줌
	
	public int insertEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
		
	public int updateEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	public int deleteEstate(@Param("id") int id);
}
