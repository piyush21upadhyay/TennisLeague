package com.sageconsulting.util;

import java.util.Comparator;

public class GenderComparator implements Comparator<SortSeason> {
	private boolean isMale;

	public GenderComparator(boolean isMale) {
		super();
		this.isMale = isMale;
	}

	@Override
	public int compare(SortSeason o1, SortSeason o2) {
		return isMale ? o1.getGender().compareTo(o2.getGender()) : o2
				.getGender().compareTo(o1.getGender());
	}

}
