/**
 * 
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.MatchCategoryDao;
import com.sageconsulting.model.MatchCategory;

/**
 * @author PIYUSH
 *
 */
public class MatchCategoryDaoHibernate extends BaseDaoHibernate implements
		MatchCategoryDao {

	@Override
	public MatchCategory getMatchCategory(Long id) {
		return (MatchCategory) getHibernateTemplate().get(MatchCategory.class,
				id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatchCategory> getMatchCategory() {
		return getHibernateTemplate().find(
				"from Match_category mc order by mc.name");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatchCategory> getMatchCategoryForCity(Long cityId) {
		return getHibernateTemplate().find("from MatchCategory mc where mc.city.id = ? order by mc.name", cityId); //$NON-NLS-1$
	}

}
