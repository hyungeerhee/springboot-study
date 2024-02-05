package com.hyungeerhee.spring.test.mybatis.service;

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
}
