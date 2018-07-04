/*
 * MatchSorter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.util.Comparator;

public class MatchSorter implements Comparator<Match>
{

    public int compare(Match match1, Match match2)
    {
        int sort = match1.getPlayBy().compareTo(match2.getPlayBy());
        if (sort == 0)
        {
            sort = match1.getGolfer1().getFullName().compareTo(match2.getGolfer1().getFullName());
        }
        return sort;
    }

}
