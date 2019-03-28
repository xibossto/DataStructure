package com.xiboss.arrays;

/**
 * 二分法查找
 * @author xiboss
 *
 */
public class TestBinarySearch {

	public static void main(String[] args) {
		//目标数组
		int arr[] = new int[] {1,2,3,4,5,6,7,8,9,10} ;
		//目标元素
		int target = 45 ;
		//记录开始位置
		int begin = 0 ;
		//记录结束位置
		int end = arr.length -1 ;
		//记录中间位置
		int mid = (begin+end)/2 ;
		//记录目标元素的位置
		int index  = -1 ;
		//循环查找
		while(true) {
			//1、判断中间的元素是否是要查找的元素
			if(arr[mid] == target) {
				index = mid ;
				break ;
			}else {
				//2、判断中间元素是否比目标元素大
				if(arr[mid] > target) {
					end = mid - 1 ;
				}else {	//3、中间这个元素比目标元素小
					begin = mid + 1;
				}
				//4、*********表示没找到，跳出循环*********
				if(begin > end) {
					break ;   	
				}
				//5、取出新的中间位置
				mid = (begin+end)/2 ;
			}
		}
		if(index == -1) {
			System.out.println("没有找到此元素！");
		}else {
			System.out.println("index:"+index);
		}
	}

}
