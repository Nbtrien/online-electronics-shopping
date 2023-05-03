package com.shopping.paging;

import com.shopping.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}