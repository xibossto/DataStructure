package com.xiboss.arrays;

import java.util.Arrays;

/**
 * ������������
 * @author xiboss
 *
 */
public class MyArray {
	
	//���ڴ洢���ݵ�����
	private int[] elements ;
	
	public MyArray() {
		elements = new int[0] ;
	}
	
	/**
	 * ��ȡ���鳤��
	 * @return ���س���ֵ
	 */
	public int size() {
		return elements.length ; 
	}
	
	/**
	 * �������ĩβ���һ��Ԫ��
	 * @param element ��ӵ�����Ԫ��
	 */
	public void add(int element) {
		//����һ���µ�����
		int[] newArr = new int[elements.length+1] ;
		//��ԭ�����е�Ԫ�ظ��Ƶ���������
		for(int i = 0 ; i < elements.length ; i++) {
			newArr[i] = elements[i] ;
		}
		//����ӵ�Ԫ�ط��뵽��������
		newArr[elements.length] = element ;
		//ʹ���������滻ԭ����
		elements = newArr ;
	}
	
	/**
	 * ��ӡ����
	 */
	public void show() {
		System.out.println(Arrays.toString(elements));
	}
	
	/**
	 * ɾ�������е�Ԫ��
	 * @param index ����
	 */
	public void delete(int index) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��") ;
		}
		//����һ���µ����飬����Ϊԭ���鳤��-1
		int[] newArr = new int[elements.length-1] ;
		//����ԭ�����ݵ�����
		for (int i = 0; i < newArr.length; i++) {
			//ɾ��Ԫ��֮ǰ������--ֱ�Ӹ���
			if(i < index) {
				newArr[i] = elements[i] ;
			}else {	//ɾ��Ԫ��֮������ݣ�index+1
				newArr[i] = elements[i+1] ;
			}
		}
		//ʹ���������滻ԭ������
		elements = newArr ;
	}
	
	//��ȡĳ��Ԫ��
	public Object get(int index) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��") ;
		}
		return elements[index] ;
	}
	
	/**
	 * ����һ��Ԫ�ص�ָ����λ��
	 * @param index  �����������
	 * @param element �������Ԫ��
	 */
	public void insert(int index, int element) {
		if(index < 0 || index > elements.length - 1) {
			throw new RuntimeException("�±�Խ��") ;
		}
		int[] newArr = new int[elements.length+1] ;
		for (int i = 0; i < elements.length; i++) {
			if(i < index) {
				newArr[i] = elements[i] ;
			}else {
				newArr[i+1] = elements[i] ;
			}
		}
		newArr[index] = element ;
		elements = newArr ;
	}
	
	/**
	 * ���Բ���
	 * @param target Ŀ��Ԫ��
	 * @return    ����Ŀ��Ԫ�ص��±�ֵ
	 */
	public int serach(int target) {
		//��������
		for (int i = 0; i < elements.length; i++) {
			if(elements[i] == target) {
				return i ;
			}
		}
		return -1 ;
	}
	
	/**
	 * ���ַ�����
	 * @param target Ŀ��Ԫ��
	 * @return    Ŀ������λ��
	 */
	public int binarySerach(int target) {
		int begin = elements[0] ;
		int end = elements.length -1 ;
		int mid = (begin+end)/2 ;
		int index = -1 ;
		while(true) {
			//�ж��м�Ԫ���Ƿ���Ŀ��Ԫ��
			if(elements[mid] == target) {
				index = mid ;
				break ;
			}else {
				if(elements[mid] > target) {
					end = mid - 1 ;
				}else {
					begin = mid + 1 ;
				}
				if(begin > end) {
					break ;
				}
				//�����м�λ������
				mid = (begin+end)/2 ;
			}
		}
		return index ;
	}
}
