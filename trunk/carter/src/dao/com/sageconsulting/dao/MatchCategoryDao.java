/**
 * 
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.MatchCategory;

/**
 * @author PIYUSH
 *
 */
public interface MatchCategoryDao extends Dao {

	public MatchCategory getMatchCategory(Long id);

	public List<MatchCategory> getMatchCategory();

	public List<MatchCategory> getMatchCategoryForCity(Long cityId);
}
