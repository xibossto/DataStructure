package com.xiboss.list;

/**
 * �ڵ�
 * @author xiboss
 *
 */
public class Node {
	//�ڵ�����
	int data ;
	//�¸��ڵ� 
	Node next ;
	
	public Node(int data) {
		this.data = data ;
	}
	
	/**
	 *׷����һ�ڵ�
	 * @param node
	 */
	public void append(Node node) {
		//��ǰ�ڵ�
		Node currentNode = this ;
		//ѭ�������
		while(true) {
			//ȡ����һ���ڵ� 
			Node nextNode = currentNode.next ;
			//�����һ���ڵ�Ϊnull��˵����ǰ�ڵ��������һ��
			if(nextNode == null) {
				break ;
			}
			//������ǰ�ڵ�
			currentNode = nextNode ;
		}
		currentNode.next = node ;
	}
	
	/**
	 * ��ȡ�¸��ڵ�
	 * @return
	 */
	public Node next() {
		return this.next ;
	}
	
	/**
	 * ��ȡ��ǰ�ڵ������
	 * @return
	 */
	public int getData() {
		return this.data ;
	}
}
