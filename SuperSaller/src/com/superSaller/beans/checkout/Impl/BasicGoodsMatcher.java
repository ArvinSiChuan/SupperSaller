package com.superSaller.beans.checkout.Impl;

import java.util.Map;

public class BasicGoodsMatcher {

	public static boolean compareMap(Map toCantain, Map toBeCotained) {
		boolean contain = false;
		for (Object o : toBeCotained.keySet()) {
			contain = toCantain.containsKey(o);
			if (contain) {
				contain = toCantain.get(o).equals(toBeCotained.get(o));
			}

		}
		return contain;
	}
}
