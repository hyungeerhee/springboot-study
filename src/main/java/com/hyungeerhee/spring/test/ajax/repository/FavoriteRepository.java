package com.hyungeerhee.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyungeerhee.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	
	public List<Favorite> selectFavoriteList();

}
