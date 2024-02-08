package com.hyungeerhee.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
			
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		return "수행 결과 : " + count;
		
	}
	@GetMapping("/input")
	public String inputUser() {
		return "jsp/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(Model model) {
		
		Seller seller = sellerService.getLastSeller();
		
		
		model.addAttribute("result", seller);
		
		return "jsp/sellerInfo";
	}
	

}
