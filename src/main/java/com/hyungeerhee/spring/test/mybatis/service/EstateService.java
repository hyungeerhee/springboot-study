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
}
