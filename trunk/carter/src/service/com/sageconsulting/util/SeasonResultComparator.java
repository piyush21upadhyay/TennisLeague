/*
 * SeasonResultComparator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.util.Comparator;

public final class SeasonResultComparator implements Comparator<SeasonResult>
{
    public int compare(SeasonResult sr1, SeasonResult sr2)
    {
        if (sr1.getPoints() == sr2.getPoints())
        {
            return compareWins(sr1, sr2);
        }
        else if (sr1.getPoints() > sr2.getPoints())
        {
            return -1;
        }
        return 1;
    }
    
    private int compareWins(SeasonResult sr1, SeasonResult sr2)
    {
        /*if (sr1.getWins() == sr2.getWins())
        {
            return compareHandicaps(sr1, sr2);
        }
        else*/ if (sr1.getWins() > sr2.getWins())
        {
            return -1;
        }
        return 1;
    }
    
    /*private int compareHandicaps(SeasonResult sr1, SeasonResult sr2)
    {
        if (sr1.getUser().getHandicap() == sr2.getUser().getHandicap())
        {
            return 0;
        }
        else if (sr1.getUser().getHandicap().doubleValue() < sr2.getUser().getHandicap().doubleValue())
        {
            return -1;
        }
        return 1;
    }*/
}
