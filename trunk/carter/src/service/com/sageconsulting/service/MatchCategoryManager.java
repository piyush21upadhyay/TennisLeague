package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.MatchCategory;


public interface MatchCategoryManager 
{
	public MatchCategory getMatchCategory(Long id);

	public List<MatchCategory> getMatchCategory();

	public List<MatchCategory> getMatchCategoryForCity(Long id);

}
