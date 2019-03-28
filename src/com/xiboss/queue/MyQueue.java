package com.xiboss.queue;

/**
 * ����
 * @author xiboss
 *
 */
public class MyQueue {
	int[] elements ;
	
	public MyQueue() {
		elements = new int[0] ;
	}
	
	/**
	 * ���
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
	 * ����
	 */
	public int poll() {
		//�������е�0��Ԫ��ȡ��
		int element = elements[0] ;
		int[] newArr = new int[elements.length-1] ;
		//����ԭ�����е�Ԫ�ص���������
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = elements[i+1] ;
		}
		//�滻����
		elements = newArr ;
		return element ;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return elements.length == 0 ;
	}
}
