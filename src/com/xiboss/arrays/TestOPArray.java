package com.xiboss.arrays;

import java.util.Arrays;

/**
 * 数组元素的添加
 * @author xiboss
 *
 */
public class TestOPArray {
	
	public static void main(String[] args) {
		//解决数组长度不可变的问题
		int[] arr = new int[] {9,8,7} ;
		//快速查看数组中的元素
		System.out.println(Arrays.toString(arr));
		//要加入数组的目标元素
		int target = 6 ;
		//1.创建一个新的数组，长度是原数组长度加1
		int[] newArr = new int[arr.length+1] ;
		//2.把原数组中的数据放入新数组中
		for(int i = 0 ; i < arr.length; i++) {
			newArr[i] = arr[i] ;
		}
		//3.把目标元素放入新数组中的最后
		newArr[arr.length] = target ;
		//4.新数组替换原数组
		arr = newArr ;
		System.out.println(Arrays.toString(arr));
	}
}
