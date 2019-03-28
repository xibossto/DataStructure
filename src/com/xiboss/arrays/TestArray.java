package com.xiboss.arrays;

/**
 * 数组的基本使用
 * @author xiboss
 *
 */
public class TestArray {
	public static void main(String[] args) {
		//初始化数据
		int[] arr1 = new int[3]  ;
		//获取数组长度
		int length1 = arr1.length ;
		System.out.println("arr1's length" +length1);
		//访问数组元素
		int element0 = arr1[0] ;
		System.out.println("element0："+element0);
		//维数组中的元素赋值
		arr1[0] = 99 ;
		element0 = arr1[0] ;
		System.out.println("element0："+element0);
		arr1[1] = 88 ;
		arr1[2] = 77 ;
		//遍历数组
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println("arr element "+i+":"+arr1[i]);
		}
		//创建数组的同时为数组中的元素赋值
		int[] arr2 = new int[] {90,80,70,60,50} ;
		//遍历数组 arr2
		for(int i = 0 ; i < arr2.length ; i++) {
			System.out.println("arr2 element "+i+":"+arr2[i]);
		}
	}
}
