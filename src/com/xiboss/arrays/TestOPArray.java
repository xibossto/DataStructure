package com.xiboss.arrays;

import java.util.Arrays;

/**
 * ����Ԫ�ص����
 * @author xiboss
 *
 */
public class TestOPArray {
	
	public static void main(String[] args) {
		//������鳤�Ȳ��ɱ������
		int[] arr = new int[] {9,8,7} ;
		//���ٲ鿴�����е�Ԫ��
		System.out.println(Arrays.toString(arr));
		//Ҫ���������Ŀ��Ԫ��
		int target = 6 ;
		//1.����һ���µ����飬������ԭ���鳤�ȼ�1
		int[] newArr = new int[arr.length+1] ;
		//2.��ԭ�����е����ݷ�����������
		for(int i = 0 ; i < arr.length; i++) {
			newArr[i] = arr[i] ;
		}
		//3.��Ŀ��Ԫ�ط����������е����
		newArr[arr.length] = target ;
		//4.�������滻ԭ����
		arr = newArr ;
		System.out.println(Arrays.toString(arr));
	}
}
