package com.consumer;

import java.util.function.Consumer;

public class Addition implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}

	public static void main(String[] args) {
		Addition addition = new Addition();
		addition.accept(6);
	}
}
