package com.predicate;

import java.util.function.Predicate;

public class Addition implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if (t % 2 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Addition addition = new Addition();
		Boolean result = addition.test(3);
		System.out.println(result);
	}

}
