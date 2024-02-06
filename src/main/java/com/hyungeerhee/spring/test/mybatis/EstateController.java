package com.hyungeerhee.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.test.mybatis.domain.Estate;
import com.hyungeerhee.spring.test.mybatis.service.EstateService;

@Controller
@RequestMapping("/mybatis/estate")
public class EstateController {
	@Autowired
	private EstateService estateService;
	
	@RequestMapping("/select/1")
	@ResponseBody
	public Estate estate(@RequestParam("id") int id) {
		//파라미터로 전달된 id와 일치하는 매물 정보를 json으로 response에 담는다.
		Estate estate = estateService.getEstate(id);
		return estate;
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<Estate> estateListByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<Estate> estateList = estateService.getEstateListByRentPrice(rentPrice);
		return estateList;
	}
	
	
	@RequestMapping("/select/3")
	@ResponseBody
	public List<Estate> estateListByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		List<Estate> estateList = estateService.getEstateListByAreaAndPrice(area, price);
		return estateList;
	}
	
	
}
