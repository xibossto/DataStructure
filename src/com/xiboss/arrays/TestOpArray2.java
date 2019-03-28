package com.xiboss.arrays;

import java.util.Arrays;

/**
 * 数组元素删除
 * @author xiboss
 *
 */
public class TestOpArray2 {
	
	public static void main(String[] args) {
		//目标数组
		int[] arr = new int[] {1,2,3,4,5,6,7} ;
		System.out.println(Arrays.toString(arr));
		//要删除的数组下标
		int dst_index = arr.length-1 ;		//最后的数组下标
		//创建一个新的数组，长度原来数组的-1
		int[] newArr = new int[arr.length-1] ;
		//复制原数组中没删除的数据到新数组中
		for(int i = 0 ; i < newArr.length ; i++) {
			//要删除的元素之前的元素
			if(i < dst_index) {
				newArr[i] = arr[i] ;
			}else {		//要删除元素之后的元素
				newArr[i] = arr[i+1] ;
			}
		}
		//新数组替换旧的数组
		arr = newArr ;
		System.out.println(Arrays.toString(arr));
	}
}
