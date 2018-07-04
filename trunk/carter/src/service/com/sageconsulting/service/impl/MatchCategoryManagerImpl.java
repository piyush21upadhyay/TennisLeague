/**
 * 
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.MatchCategoryDao;
import com.sageconsulting.model.MatchCategory;
import com.sageconsulting.service.MatchCategoryManager;

/**
 * @author PIYUSH
 *
 */
public class MatchCategoryManagerImpl extends BaseManager implements
		MatchCategoryManager {

	private MatchCategoryDao getMatchCategoryDao() {
		return (MatchCategoryDao) this.dao;
	}

	public void setMatchCategoryDao(MatchCategoryDao matchCategoryDao) {
		super.setDao(matchCategoryDao);
	}

	@Override
	public MatchCategory getMatchCategory(Long id) {
		return getMatchCategoryDao().getMatchCategory(id);
	}

	@Override
	public List<MatchCategory> getMatchCategory() {
		return getMatchCategoryDao().getMatchCategory();
	}

	@Override
	public List<MatchCategory> getMatchCategoryForCity(Long cityId) {
		return getMatchCategoryDao().getMatchCategoryForCity(cityId);
	}

}
