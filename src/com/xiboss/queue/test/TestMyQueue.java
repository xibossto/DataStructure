package com.xiboss.queue.test;

import com.xiboss.queue.MyQueue;

/**
 * ≤‚ ‘∂”¡–
 * @author xiboss
 *
 */
public class TestMyQueue {
	public static void main(String[] args) {
		MyQueue mq = new MyQueue() ;
		mq.add(9);
		mq.add(8);
		mq.add(7);
		mq.add(6);
		System.out.println(mq.poll());
	}
}
