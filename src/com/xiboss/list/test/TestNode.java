package com.xiboss.list.test;

import com.xiboss.list.Node;

public class TestNode {
	public static void main(String[] args) {
		//创建节点
		Node n1 = new Node(1) ;
		Node n2 = new Node(2) ;
		Node n3 = new Node(3) ;
		//追加节点
		n1.append(n2);
		n1.append(n3);
		//取出下个节点
		System.out.println(n1.next().next().getData());
	}
}
