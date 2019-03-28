package com.xiboss.queue;
/**
 * 栈
 * @author xiboss
 *
 */
public class MyStack {
	//栈的底层使用数组实现
	int[] elements ;
	
	public MyStack() {
		elements = new int[0] ;
	}
	
	/**
	 * 压入元素
	 * @param element
	 */
	public void push(int element) {
		//定义新数组
		int[] newArr = new int[elements.length+1] ;
		//把就数组中的元素复制到新数组中
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i] ;
		}
		//把加入的元素放入新数组中
		newArr[elements.length] = element ;
		//替换旧数组
		elements = newArr ;
	}
	
	/**
	 * 取出栈顶元素
	 * @return  返回栈顶值
	 */
	public int pop() {
		//如果栈为空
		if(elements.length == 0) {
			throw new RuntimeException("stack is empty") ;
		}
		//取出数组中的最后一个元素
		int element = elements[elements.length-1] ;
		//创建一个新的数组
		int[] newArr = new int[elements.length -1 ] ;
		//原数组中除了最后一个元素其他的都复制到新数组中
		for (int i = 0; i < elements.length - 1; i++) {
			newArr[i] = elements[i] ;
		}
		//替换数组
		elements = newArr ;
		return element ;
	}
	
	/**
	 * 查看栈顶元素
	 * @return
	 */
	public int peek() {
		return elements[elements.length-1] ;
	}
	
	public boolean isEmpty() {
		return elements.length == 0 ;
	}
}
