package com.xiboss.arrays;

import java.util.Arrays;

/**
 * 面向对象的数组
 * @author xiboss
 *
 */
public class MyArray {
	
	//用于存储数据的数组
	private int[] elements ;
	
	public MyArray() {
		elements = new int[0] ;
	}
	
	/**
	 * 获取数组长度
	 * @return 返回长度值
	 */
	public int size() {
		return elements.length ; 
	}
	
	/**
	 * 在数组的末尾添加一个元素
	 * @param element 添加的数组元素
	 */
	public void add(int element) {
		//创建一个新的数组
		int[] newArr = new int[elements.length+1] ;
		//在原数组中的元素复制到新数组中
		for(int i = 0 ; i < elements.length ; i++) {
			newArr[i] = elements[i] ;
		}
		//把添加的元素放入到新数组中
		newArr[elements.length] = element ;
		//使用新数组替换原数组
		elements = newArr ;
	}
	
	/**
	 * 打印数组
	 */
	public void show() {
		System.out.println(Arrays.toString(elements));
	}
	
	/**
	 * 删除数组中的元素
	 * @param index 索引
	 */
	public void delete(int index) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("下标越界") ;
		}
		//创建一个新的数组，长度为原数组长度-1
		int[] newArr = new int[elements.length-1] ;
		//复制原有数据到数组
		for (int i = 0; i < newArr.length; i++) {
			//删除元素之前的数据--直接复制
			if(i < index) {
				newArr[i] = elements[i] ;
			}else {	//删除元素之后的数据，index+1
				newArr[i] = elements[i+1] ;
			}
		}
		//使用新数组替换原有数组
		elements = newArr ;
	}
	
	//获取某个元素
	public Object get(int index) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("下标越界") ;
		}
		return elements[index] ;
	}
	
	/**
	 * 插入一个元素到指定的位置
	 * @param index  数组插入索引
	 * @param element 数组插入元素
	 */
	public void insert(int index, int element) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("下标越界") ;
		}
		int[] newArr = new int[elements.length+1] ;
		for (int i = 0; i < elements.length; i++) {
			if(i < index) {
				newArr[i] = elements[i] ;
			}else {
				newArr[i+1] = elements[i] ;
			}
		}
		newArr[index] = element ;
		elements = newArr ;
	}
	
	/**
	 * 线性查找
	 * @param target 目标元素
	 * @return    返回目标元素的下标值
	 */
	public int serach(int target) {
		//遍历查找
		for (int i = 0; i < elements.length; i++) {
			if(elements[i] == target) {
				return i ;
			}
		}
		return -1 ;
	}
	
	/**
	 * 二分法查找
	 * @param target 目标元素
	 * @return    目标所在位置
	 */
	public int binarySerach(int target) {
		int begin = elements[0] ;
		int end = elements.length -1 ;
		int mid = (begin+end)/2 ;
		int index = -1 ;
		while(true) {
			//判断中间元素是否是目标元素
			if(elements[mid] == target) {
				index = mid ;
				break ;
			}else {
				if(elements[mid] > target) {
					end = mid - 1 ;
				}else {
					begin = mid + 1 ;
				}
				if(begin > end) {
					break ;
				}
				//更新中间位置索引
				mid = (begin+end)/2 ;
			}
		}
		return index ;
	}
}
