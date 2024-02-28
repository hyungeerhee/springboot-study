package com.hyungeerhee.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hyungeerhee.spring.test.ajax.domain.Favorite;
import com.hyungeerhee.spring.test.ajax.repository.FavoriteRepository;

public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public getFavoriteList() {
		
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
	}

}
