package com.consumer;

import java.util.function.Consumer;

public class Addition1 {
//implements Consumer<Integer> {
//
//	@Override
//	public void accept(Integer t) {
//		System.out.println(t);
//	}

	public static void main(String[] args) {
		//Addition1 addition = new Addition1();
		//addition.accept(6);
		
		Consumer<Integer> result =  t -> System.out.println(t);
		
		result.accept(6);
	}
}
