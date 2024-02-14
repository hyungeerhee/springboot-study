package com.hyungeerhee.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.test.jsp.domain.Seller;
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
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id, 
			//null을 사용하기 위해서는 Integer(Wrapper class)를 사용,  int는 null 사용불가
			Model model) {
		
		// id가 전달되면, 일치하는 판매자 정보
		if(id != null) {
			Seller seller = sellerService.getSeller(id);
			model.addAttribute("result", seller);
		}
		
		// id가 전달 되지 않으면, 가장 최근 등록된 판매자 정보
		else { Seller seller = sellerService.getLastSeller();
				model.addAttribute("result", seller);
		}
		
		
		return "jsp/sellerInfo";
	}
	
}
