package com.xiboss.arrays;

/**
 * ���ַ�����
 * @author xiboss
 *
 */
public class TestBinarySearch {

	public static void main(String[] args) {
		//Ŀ������
		int arr[] = new int[] {1,2,3,4,5,6,7,8,9,10} ;
		//Ŀ��Ԫ��
		int target = 45 ;
		//��¼��ʼλ��
		int begin = 0 ;
		//��¼����λ��
		int end = arr.length -1 ;
		//��¼�м�λ��
		int mid = (begin+end)/2 ;
		//��¼Ŀ��Ԫ�ص�λ��
		int index  = -1 ;
		//ѭ������
		while(true) {
			//1���ж��м��Ԫ���Ƿ���Ҫ���ҵ�Ԫ��
			if(arr[mid] == target) {
				index = mid ;
				break ;
			}else {
				//2���ж��м�Ԫ���Ƿ��Ŀ��Ԫ�ش�
				if(arr[mid] > target) {
					end = mid - 1 ;
				}else {	//3���м����Ԫ�ر�Ŀ��Ԫ��С
					begin = mid + 1;
				}
				//4��*********��ʾû�ҵ�������ѭ��*********
				if(begin > end) {
					break ;   	
				}
				//5��ȡ���µ��м�λ��
				mid = (begin+end)/2 ;
			}
		}
		if(index == -1) {
			System.out.println("û���ҵ���Ԫ�أ�");
		}else {
			System.out.println("index:"+index);
		}
	}

}
