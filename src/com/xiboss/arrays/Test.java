package com.xiboss.arrays;

import java.util.Scanner;

public class Test {
	/**
	 * ������
	 * @param args
	 */
	public static void main (String[] args) {
         
        int pay = 0;//������
        int cost = 0;//��Ʒ����
        int change = 0;//��Ǯ
         
        Scanner scanner = new Scanner(System.in);
        System.out.println("������˿͸����");
        //����������ݽ��м�⣬�Ƿ���Ϲ���
        try
        {
            pay = scanner.nextInt();
            if (pay > 100 || pay < 0)
            {
                System.out.println("��������ȷ�Ľ��");
                return;
            }
             
        }catch (Exception e)
        {
            System.out.println("������Ϸ�����");
            return;
        }
         
         
        System.out.println("�������̵��Ʒ�۸�");
        //����������ݽ��м�⣬�Ƿ���Ϲ���
        try
        {
            cost = scanner.nextInt();
            if (cost > 100 || cost < 0)
            {
                System.out.println("��������ȷ�Ľ��");
                return;
            }
            else if (cost > pay)
            {
                System.out.println("�������ѽ���֧�����");
                return;
            }
        }catch (Exception e)
        {
            System.out.println("������Ϸ�����");
            return;
        }
         
        change = pay-cost;
         
        //�����ʱ�ĸ������Ʒ�۸�Ӧ�ҽ��
        System.out.println("������" + pay +"   ��Ʒ�۸�" + cost + "     Ӧ���ܽ�" + change);
         
        //��ý�����������
        String end = giveChange(change);
        System.out.println("�˴�����Ӧ�ҽ��  " + change + " Ԫ������Ӧ��  " + end);
         
    }

	/**
	 * ����Ǯ������Ǯ
	 * @param change
	 * @return String//�������յ���Ǯ���
	 */
	public static String giveChange(int change) {
		String str = "";
		int qianshu;// Ӧ����Ǯ������
		int leftmoney = change;// ��ʣ�¶���Ǯ,��ʼֵΪchange

		if (leftmoney / 50 != 0) {
			qianshu = leftmoney / 50;
			str = str + qianshu + "��50Ԫ ";
			leftmoney = leftmoney - qianshu * 50;
		}
		if (leftmoney / 10 != 0) {
			qianshu = leftmoney / 10;
			str = str + qianshu + "��10Ԫ ";
			leftmoney = leftmoney - qianshu * 10;
		}
		if (leftmoney / 5 != 0) {
			qianshu = leftmoney / 5;
			str = str + qianshu + "��5Ԫ ";
			leftmoney = leftmoney - qianshu * 5;
		}
		if (leftmoney / 1 != 0) {
			qianshu = leftmoney / 1;
			str = str + qianshu + "��1Ԫ ";
			leftmoney = leftmoney - qianshu * 1;
		}

		// �����Ƿ���ȫ����
		System.out.println("ʣ��û�������Ǯ��Ϊ��" + leftmoney);
		return str;
	}
}
