package com.comet;


public class test {
	static String[] array = {"apple", "dog"};
	public static String[] getArray() {
		System.out.println("=========");
		return array;
	}
	

	public static void main(String[] args) throws Exception {
		for (String s : getArray()) {
			System.out.println(s);
		}
	}

}
