package com.xiboss.arrays;

public class TestMyarray {

	public static void main(String[] args) {
		//����һ���ɱ������
		MyArray myArray = new MyArray() ;
		//��ȡ����
		int size = myArray.size() ;
		System.out.println(size);
		//���ɱ����������һ��Ԫ��
		myArray.add(99);
		myArray.add(88);
		myArray.add(77);
		myArray.add(66);
		myArray.add(55);
		myArray.show(); 
		System.out.println(myArray.size());
		
		System.out.println("ɾ�������е�Ԫ��");
		myArray.show();
		myArray.delete(3);
		myArray.show() ;
		
		System.out.println("��ȡĳ��Ԫ��");
		System.out.println(myArray.get(1));
		
		System.out.println("���ĳԪ�ص������ָ��λ��") ;
		myArray.insert(2, 104);
		myArray.show(); ;
	}

}
