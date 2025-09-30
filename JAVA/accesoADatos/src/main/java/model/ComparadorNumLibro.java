package model;

import java.util.Comparator;

public class ComparadorNumLibro implements Comparator<Editorial>{

	@Override
	public int compare(Editorial o1, Editorial o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
