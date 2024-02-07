package com.hyungeerhee.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyungeerhee.spring.test.mybatis.domain.Estate;
import com.hyungeerhee.spring.test.mybatis.repository.EstateRepository;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository estateRepository;
	
	// 전달된 id를 가진 리뷰 정보 돌려주는 기능
	public Estate getEstate(int id) {
		Estate estate = estateRepository.selectEstate(id);
		return estate;
	}
	
	public List<Estate> getEstateListByRentPrice(int rentPrice) {
		List<Estate> estateList = estateRepository.selectEstateListByRentPrice(rentPrice);
		return estateList;
		
		
	}
	
	public List<Estate> getEstateListByAreaAndPrice(int area, int price) {
		List<Estate> estateList = estateRepository.selectEstateListByAreaAndPrice(area, price);
		return estateList;
	}
	
	public int addEstateByObject(Estate estate) {
		int count = estateRepository.insertEstateByObject(estate);
		
		return count; 
	}
	
	public int addEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		int count = estateRepository.insertEstate(realtorId, address, area, type, price, rentPrice);
		
		return count;
	}
	
	// id가 24인 매물 정보에 type을 전세, 보증금 70000으로 변경
	//특정 id의 매물 정보에 전달받은 type과 price 값으로 수정하는 기능 
	public int updateEstate(int id, String type, int price) {
		int count = estateRepository.updateEstate(id, type, price);
		
		return count;
	}
	
	public int deleteEstate(int id) {
		int count = estateRepository.deleteEstate(id);
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
			
	
}
