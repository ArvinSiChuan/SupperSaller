package com.superSaller.beans.checkout.Impl;

import java.util.Map;
import java.util.Set;

public class BasicGoodsMatcher {

	public boolean matchBundle(Map<String, Double> toCantain, Map<String, Double> toBeCotained) {
		// TODO might happen that goods in chart is zero
		boolean matched = false;
		Set<String> keysToBeContained = toBeCotained.keySet();
		if (toCantain.keySet().containsAll(keysToBeContained)) {
			matched = true;
			for (String string : keysToBeContained) {
				if (toCantain.get(string) < toBeCotained.get(string)) {
					matched = false;
					break;
				}
			}
		}
		return matched;
	}

}
