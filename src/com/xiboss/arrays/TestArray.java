package com.xiboss.arrays;

/**
 * ����Ļ���ʹ��
 * @author xiboss
 *
 */
public class TestArray {
	public static void main(String[] args) {
		//��ʼ������
		int[] arr1 = new int[3]  ;
		//��ȡ���鳤��
		int length1 = arr1.length ;
		System.out.println("arr1's length" +length1);
		//��������Ԫ��
		int element0 = arr1[0] ;
		System.out.println("element0��"+element0);
		//ά�����е�Ԫ�ظ�ֵ
		arr1[0] = 99 ;
		element0 = arr1[0] ;
		System.out.println("element0��"+element0);
		arr1[1] = 88 ;
		arr1[2] = 77 ;
		//��������
		for(int i = 0 ; i < arr1.length ; i++) {
			System.out.println("arr element "+i+":"+arr1[i]);
		}
		//���������ͬʱΪ�����е�Ԫ�ظ�ֵ
		int[] arr2 = new int[] {90,80,70,60,50} ;
		//�������� arr2
		for(int i = 0 ; i < arr2.length ; i++) {
			System.out.println("arr2 element "+i+":"+arr2[i]);
		}
	}
}
