package com.xiboss.arrays;

import java.util.Scanner;

/**
 * 线性查找
 * @author xiboss
 *
 */
public class TestSearch {
	public static void main(String[] args) {
		//目标数组
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10} ;
		//目标元素
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("请输入目标元素：");
		int target = 8 ;
		target = scanner.nextInt() ;
		//目标元素所在下标
		int index = -1 ;    //默认-1，没有
		//遍历数组
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				index = i ;
				break ; 
			}
		}
		System.out.println(index);
	}
}
