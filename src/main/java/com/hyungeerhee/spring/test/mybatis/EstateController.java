package com.hyungeerhee.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.test.mybatis.domain.Estate;
import com.hyungeerhee.spring.test.mybatis.service.EstateService;

@Controller
public class EstateController {
	@Autowired
	private EstateService estateService;
	
	@RequestMapping("/mybatis/estate")
	@ResponseBody
	public Estate estate(@RequestParam("id") int id) {
		Estate estate = estateService.getEstate(id);
		return estate;
	}
}
