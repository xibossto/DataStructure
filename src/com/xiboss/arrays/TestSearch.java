package com.xiboss.arrays;

import java.util.Scanner;

/**
 * ���Բ���
 * @author xiboss
 *
 */
public class TestSearch {
	public static void main(String[] args) {
		//Ŀ������
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10} ;
		//Ŀ��Ԫ��
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("������Ŀ��Ԫ�أ�");
		int target = 8 ;
		target = scanner.nextInt() ;
		//Ŀ��Ԫ�������±�
		int index = -1 ;    //Ĭ��-1��û��
		//��������
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				index = i ;
				break ; 
			}
		}
		System.out.println(index);
	}
}
