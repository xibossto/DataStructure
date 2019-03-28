package com.xiboss.queue;

/**
 * 队列
 * @author xiboss
 *
 */
public class MyQueue {
	int[] elements ;
	
	public MyQueue() {
		elements = new int[0] ;
	}
	
	/**
	 * 入队
	 * @param element
	 */
	public void add(int element) {
		int[] newArr = new int[elements.length+1] ;
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i] ;
		}
		newArr[elements.length] = element ;
		elements = newArr ;
	}
	
	/**
	 * 出队
	 */
	public int poll() {
		//把数组中第0个元素取出
		int element = elements[0] ;
		int[] newArr = new int[elements.length-1] ;
		//复制原数组中的元素到新数组中
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = elements[i+1] ;
		}
		//替换数组
		elements = newArr ;
		return element ;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return elements.length == 0 ;
	}
}
