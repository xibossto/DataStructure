package com.xiboss.queue.test;

import com.xiboss.queue.MyStack;

public class TestMyStack {
	public static void main(String[] args) {
		MyStack ms = new MyStack() ;
		System.out.println(ms.isEmpty());
		//ѹ������
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(8);
		//ȡ��ջ��Ԫ��
//		System.out.println(ms.pop());
//		System.out.println(ms.pop());
		//�鿴ջ��Ԫ��
		System.out.println(ms.peek());
		ms.pop() ;
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
	}
}
