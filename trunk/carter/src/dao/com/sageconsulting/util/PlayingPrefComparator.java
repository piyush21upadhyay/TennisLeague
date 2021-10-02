package com.sageconsulting.util;

import java.util.Comparator;

public class PlayingPrefComparator implements Comparator<SortSeason> {

	@Override
	public int compare(SortSeason o1, SortSeason o2) {
		return o1.getPlayingPref().compareTo(o2.getPlayingPref());
	}

}
