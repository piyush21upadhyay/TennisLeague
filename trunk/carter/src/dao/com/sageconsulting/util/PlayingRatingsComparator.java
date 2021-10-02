package com.sageconsulting.util;

import java.util.Comparator;

public class PlayingRatingsComparator implements Comparator<SortSeason> {

	@Override
	public int compare(SortSeason o1, SortSeason o2) {
		return Double.compare(o2.getRating(),o1.getRating());
	}

}
