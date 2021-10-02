package com.sageconsulting.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SeasonChainedComparator implements Comparator<SortSeason> {

	List<Comparator<SortSeason>> listComparators;

	public SeasonChainedComparator(Comparator<SortSeason>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(SortSeason emp1, SortSeason emp2) {
		for (Comparator<SortSeason> comparator : listComparators) {
			int result = comparator.compare(emp1, emp2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

}
