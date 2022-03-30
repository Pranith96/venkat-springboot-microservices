package com.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class GenarateRandomNumber implements Supplier<Integer>{

	@Override
	public Integer get() {
		return new Random().nextInt();
	}

	public static void main(String[] args) {
		GenarateRandomNumber genarateRandomNumber = new GenarateRandomNumber();
		Integer result = genarateRandomNumber.get();
		System.out.println(result);
		
		Supplier<Integer> rst = () -> new Random().nextInt();
		System.out.println(rst.get());
	}
}
