package com.supplier;

import java.util.function.Supplier;

public class SupplierExample {
	
	static String data = "HelO WoRld";

	public static void main(String[] args) {
		Supplier<Integer> length = () -> data.length();
		Supplier<Boolean> getBoolean = () -> data.length() == 10;
		
		System.out.println(length.get());
		System.out.println(getBoolean.get());

	}
}
