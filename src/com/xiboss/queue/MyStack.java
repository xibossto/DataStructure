package com.xiboss.queue;
/**
 * ջ
 * @author xiboss
 *
 */
public class MyStack {
	//ջ�ĵײ�ʹ������ʵ��
	int[] elements ;
	
	public MyStack() {
		elements = new int[0] ;
	}
	
	/**
	 * ѹ��Ԫ��
	 * @param element
	 */
	public void push(int element) {
		//����������
		int[] newArr = new int[elements.length+1] ;
		//�Ѿ������е�Ԫ�ظ��Ƶ���������
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i] ;
		}
		//�Ѽ����Ԫ�ط�����������
		newArr[elements.length] = element ;
		//�滻������
		elements = newArr ;
	}
	
	/**
	 * ȡ��ջ��Ԫ��
	 * @return  ����ջ��ֵ
	 */
	public int pop() {
		//���ջΪ��
		if(elements.length == 0) {
			throw new RuntimeException("stack is empty") ;
		}
		//ȡ�������е����һ��Ԫ��
		int element = elements[elements.length-1] ;
		//����һ���µ�����
		int[] newArr = new int[elements.length -1 ] ;
		//ԭ�����г������һ��Ԫ�������Ķ����Ƶ���������
		for (int i = 0; i < elements.length - 1; i++) {
			newArr[i] = elements[i] ;
		}
		//�滻����
		elements = newArr ;
		return element ;
	}
	
	/**
	 * �鿴ջ��Ԫ��
	 * @return
	 */
	public int peek() {
		return elements[elements.length-1] ;
	}
	
	public boolean isEmpty() {
		return elements.length == 0 ;
	}
}
