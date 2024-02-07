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
	
	@RequestMapping("/insert/1")
	@ResponseBody
	public String createEstate() {
		
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(10000);
		
		int count = estateService.addEstateByObject(estate);
				
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createEstate(@RequestParam("realtorId") int realtorId) {
		
		int count = estateService.addEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateEstate() {
		//id가 24인 매물 정보에 type을 전세, 보증금 70000으로 변경
		int count = estateService.updateEstate(24, "전세", 70000);
		return "수정 성공 : " + count;
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String deleteEstate(@RequestParam("id") int id) {
		int count = estateService.deleteEstate(id);
		return "삭제 성공 : " + count;
	
		
		
		
		
		
		
		
		
	}
	
	
	
}
