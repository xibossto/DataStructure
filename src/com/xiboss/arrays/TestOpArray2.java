package com.xiboss.arrays;

import java.util.Arrays;

/**
 * ����Ԫ��ɾ��
 * @author xiboss
 *
 */
public class TestOpArray2 {
	
	public static void main(String[] args) {
		//Ŀ������
		int[] arr = new int[] {1,2,3,4,5,6,7} ;
		System.out.println(Arrays.toString(arr));
		//Ҫɾ���������±�
		int dst_index = arr.length-1 ;		//���������±�
		//����һ���µ����飬����ԭ�������-1
		int[] newArr = new int[arr.length-1] ;
		//����ԭ������ûɾ�������ݵ���������
		for(int i = 0 ; i < newArr.length ; i++) {
			//Ҫɾ����Ԫ��֮ǰ��Ԫ��
			if(i < dst_index) {
				newArr[i] = arr[i] ;
			}else {		//Ҫɾ��Ԫ��֮���Ԫ��
				newArr[i] = arr[i+1] ;
			}
		}
		//�������滻�ɵ�����
		arr = newArr ;
		System.out.println(Arrays.toString(arr));
	}
}
