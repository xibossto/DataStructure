package com.xiboss.arrays;

public class TestMyArraySearch {
	public static void main(String[] args) {
		MyArray myArray = new MyArray() ;
		myArray.add(1);
		myArray.add(11);
		myArray.add(12);
		myArray.add(13);
		myArray.add(14);
		myArray.add(16);
		myArray.show();
		System.out.println(myArray.serach(4211));
		System.out.println(myArray.binarySerach(20));
	}
}
