package com.xiboss.arrays;

public class TestMyarray {

	public static void main(String[] args) {
		//创建一个可变的数组
		MyArray myArray = new MyArray() ;
		//获取长度
		int size = myArray.size() ;
		System.out.println(size);
		//往可变数组中添加一个元素
		myArray.add(99);
		myArray.add(88);
		myArray.add(77);
		myArray.add(66);
		myArray.add(55);
		myArray.show(); 
		System.out.println(myArray.size());
		
		System.out.println("删除数组中的元素");
		myArray.show();
		myArray.delete(3);
		myArray.show() ;
		
		System.out.println("获取某个元素");
		System.out.println(myArray.get(1));
		
		System.out.println("添加某元素到数组的指定位置") ;
		myArray.insert(2, 104);
		myArray.show(); ;
	}

}
