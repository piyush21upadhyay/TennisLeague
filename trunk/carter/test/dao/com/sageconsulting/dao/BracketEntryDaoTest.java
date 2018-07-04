/*
 * BracketEntryDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.GregorianCalendar;
import java.util.List;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Season;
import com.sageconsulting.util.BracketUtility;

public class BracketEntryDaoTest extends BaseDaoTestCase
{
    private BracketEntryDao bracketEntryDao;
    
    public void setBracketEntryDao(BracketEntryDao dao)
    {
        this.bracketEntryDao = dao;
    }
    
    public void testCreateAndSaveBracket()
    {
//        Bracket bracket = new Bracket();
//        bracket.generateBracket(16);
//        this.bracketDao.saveBracket(bracket);
//        
//        bracket = this.bracketDao.getBracket(bracket.getId());
//        System.out.println(bracket);
        Season s = new Season();
        s.setCity(getCity());
        GregorianCalendar date = new GregorianCalendar();
        s.setId(Long.valueOf(1));
        s.setPostSeasonQualifyingCount(Integer.valueOf(16));
        List<BracketEntry> bracket = BracketUtility.generateBracket(s, date, 4);
        System.out.println(BracketUtility.toString(bracket));
        //BracketUtility.saveBracket(bracket);
        this.bracketEntryDao.saveBracket(bracket);
        
        List<BracketEntry> testBracket = this.bracketEntryDao.getRoundOneBracketForSeason(s.getId());
        System.out.println(BracketUtility.toString(testBracket));
    }
    
    private City getCity()
    {
        City city = new City();
        city.setId(Long.valueOf(1));
        city.setName("Portland"); //$NON-NLS-1$
        city.setVersion(Integer.valueOf(1));
        return city;
    }
}
