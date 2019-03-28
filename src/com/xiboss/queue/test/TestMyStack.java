package com.xiboss.queue.test;

import com.xiboss.queue.MyStack;

public class TestMyStack {
	public static void main(String[] args) {
		MyStack ms = new MyStack() ;
		System.out.println(ms.isEmpty());
		//压入数组
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(8);
		//取出栈顶元素
//		System.out.println(ms.pop());
//		System.out.println(ms.pop());
		//查看栈顶元素
		System.out.println(ms.peek());
		ms.pop() ;
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
	}
}
