package com.xiboss.list;

/**
 * 节点
 * @author xiboss
 *
 */
public class Node {
	//节点内容
	int data ;
	//下个节点 
	Node next ;
	
	public Node(int data) {
		this.data = data ;
	}
	
	/**
	 *追加下一节点
	 * @param node
	 */
	public void append(Node node) {
		//当前节点
		Node currentNode = this ;
		//循环向后找
		while(true) {
			//取出下一个节点 
			Node nextNode = currentNode.next ;
			//如果下一个节点为null，说明当前节点已是最后一个
			if(nextNode == null) {
				break ;
			}
			//赋给当前节点
			currentNode = nextNode ;
		}
		currentNode.next = node ;
	}
	
	/**
	 * 获取下个节点
	 * @return
	 */
	public Node next() {
		return this.next ;
	}
	
	/**
	 * 获取当前节点的数据
	 * @return
	 */
	public int getData() {
		return this.data ;
	}
}
