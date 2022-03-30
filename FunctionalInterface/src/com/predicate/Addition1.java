package com.predicate;

import java.util.function.Predicate;

public class Addition1 {
//implements Predicate<Integer> {
//
//	@Override
//	public boolean test(Integer t) {
//		if (t % 2 == 0) {
//			return true;
//		}
//		return false;
//	}

	public static void main(String[] args) {
		// Addition1 addition = new Addition1();
		// Boolean result = addition.test(3);
		// System.out.println(result);
		Predicate<Integer> result = t -> t%2 == 0;
		System.out.println(result.test(6));
	}
}