package com.xiboss.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import sun.rmi.runtime.Log;

/**
 * ���֤У��
 * @Description: ���֤����, ���Խ������֤����ĸ����ֶΣ��Լ���֤���֤�����Ƿ���Ч
 * ���֤���빹�ɣ�6λ��ַ����+8λ����+3λ˳����+1λУ����
 */
public class CheckIDCardRule {
	
	/*���֤�����еĳ������ڸ�ʽ*/
	private static final String  BIRTH_DATE_FORMAT = "yyyyMMdd" ;
	/*���֤����С�������ڣ�1900��1��1��*/
	private static final Date MIN_BIRTH_DATE = new Date(-2209017600000L) ;
	/*�°����֤���볤��*/
	private static final int NEW_CARD_NUMBER_LENGTH = 18 ;
	/*�ɰ����֤����*/
	private static final int OLD_CARD_NUMBER_LENGTH = 15 ;
	/*18λ���֤�����һλ��У����*/
	private static final char[] VERIFY_CODE = {'x','0','1','2','3','4','5','6','7','8','9'} ;
	/*18λ���֤�У��������ֵ�����У����ʱ��Ȩֵ*/
	private static final int[] VERIFY_CODE_WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1,6, 3, 7, 9, 10, 5, 8, 4, 2};
	/*���������֤����*/
	private final String cardNumber ;
    /*�������֤�Ƿ���Ч����Ϊ��֤��Ч��ʹ��Ƶ���Ҽ��㸴��*/
    private Boolean cacheValidateResult = null;
    
    /*����������ڣ���Ϊ��������ʹ��Ƶ���Ҽ��㸴��*/
    private Date cacheBirthDate = null;
    /**
     * ��ǰʱ��
     */
    private Date currentDate = new Date();

    /**
     * @param cardNumber ��ҪУ������֤����
     */
    public CheckIDCardRule(String cardNumber) {
    	if(null != cardNumber) {
    		cardNumber = cardNumber.trim() ;
    	}
    	this.cardNumber = cardNumber ;
    }
    
    /**
     * @param cardNumber ��ҪУ������֤����
     * @param serTime У�����ڣ���ʽΪyyyy-MM-dd������У����������Ƿ����ڸ����ڡ��紫null����Ĭ��Ϊ��ǰ����
     */
    public CheckIDCardRule(String cardNumber, String serTime) {
        if (null != cardNumber) {
            cardNumber = cardNumber.trim();
            if (OLD_CARD_NUMBER_LENGTH == cardNumber.length()) {
                // �����15λ���֤���룬���Զ�ת��Ϊ18λ
                cardNumber = contertToNewCardNumber(cardNumber);
            }
        }
        if (null != serTime) {
            currentDate = strToDate(serTime, "yyyyMMddhhmmss");
        }
        this.cardNumber = cardNumber;
    }
    

    /**
     * @return boolean
     * @Title: validate
     * @Description: ���֤����У��
     * @author
     */
    public boolean validate() {
        if (null == this.cacheValidateResult) {
            boolean result = true;
            try {
                // ���֤���벻��Ϊ��
                result = result && (null != this.cardNumber);
                // ���֤�ų�����18(��֤)
                result = result
                        && NEW_CARD_NUMBER_LENGTH == this.cardNumber.length();
                char ch;
                // ���֤�ŵ�ǰ17λ�����ǰ���������
                for (int i = 0; i < NEW_CARD_NUMBER_LENGTH - 1; i++) {
                    ch = cardNumber.charAt(i);
                    result = result && ch >= '0' && ch <= '9';
                }
                // ���֤�ŵĵ�18λУ����ȷ
                result = result
                        && (calculateVerifyCode(cardNumber) == cardNumber
                        .charAt(NEW_CARD_NUMBER_LENGTH - 1));
                // �������ڲ������ڵ�ǰʱ�䣬���Ҳ�������1900��
                Date birthDate = getBirthDate();
                result = result && null != birthDate;
                result = result && birthDate.before(currentDate);
                result = result && birthDate.after(MIN_BIRTH_DATE);

                String birthdayPart = getBirthDayPart();
                String realBirthdayPart = this.createBirthDateParser().format(
                        birthDate);
                result = result && (birthdayPart.equals(realBirthdayPart));
            } catch (Exception e) {
               System.out.println("����ִ��ʧ�ܣ�");
                result = false;
            }
            // �������֤�����ʡ�������������
            cacheValidateResult = Boolean.valueOf(result);
        }
        return cacheValidateResult;
    }

    /**
     * ���ܣ����õ�������
     *
     * @return Hashtable ����
     */
    private static Hashtable<String, String> GetAreaCode() {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("11", "����");
        hashtable.put("12", "���");
        hashtable.put("13", "�ӱ�");
        hashtable.put("14", "ɽ��");
        hashtable.put("15", "���ɹ�");
        hashtable.put("21", "����");
        hashtable.put("22", "����");
        hashtable.put("23", "������");
        hashtable.put("31", "�Ϻ�");
        hashtable.put("32", "����");
        hashtable.put("33", "�㽭");
        hashtable.put("34", "����");
        hashtable.put("35", "����");
        hashtable.put("36", "����");
        hashtable.put("37", "ɽ��");
        hashtable.put("41", "����");
        hashtable.put("42", "����");
        hashtable.put("43", "����");
        hashtable.put("44", "�㶫");
        hashtable.put("45", "����");
        hashtable.put("46", "����");
        hashtable.put("50", "����");
        hashtable.put("51", "�Ĵ�");
        hashtable.put("52", "����");
        hashtable.put("53", "����");
        hashtable.put("54", "����");
        hashtable.put("61", "����");
        hashtable.put("62", "����");
        hashtable.put("63", "�ຣ");
        hashtable.put("64", "����");
        hashtable.put("65", "�½�");
        hashtable.put("71", "̨��");
        hashtable.put("81", "���");
        hashtable.put("82", "����");
        hashtable.put("91", "����");
        return hashtable;
    }

    /**
     * @return String
     * @Title: getAddressCode
     * @Description: ��ȡ���֤�����еĵ�ַ����
     * @author
     */
    public String getAddressCode() {
        checkIfValid();
        Hashtable<String, String> h = GetAreaCode();
        if (h.get(cardNumber.substring(0, 2)) == null) {
            throw new RuntimeException("��������벻��ȷ��");
        }
        // return this.cardNumber.substring(0, 6);
        return h.get(cardNumber.substring(0, 2));
    }

    /**
     * @return java.util.Date
     * @Title: getBirthDate
     * @Description: ��ȡ���֤�����е�����
     */
    public Date getBirthDate() {

        if (null == this.cacheBirthDate) {
            try {
                this.cacheBirthDate = createBirthDateParser().parse(
                        getBirthDayPart());
            } catch (ParseException e) {
               System.out.println("��������ʧ��!");
            } catch (Exception e) {
               System.out.println("��������ʧ��!");
            }
        }
        return new Date(this.cacheBirthDate.getTime());
    }

    /**
     * @return boolean
     * @Title: isMale
     * @Description: �ж��Ƿ�Ϊ����
     * @author
     */
    public boolean isMale() {
        return 1 == getGenderCode();
    }

    /**
     * @return boolean
     * @Title: isMale
     * @Description: �ж��Ƿ�ΪŮ��
     * @author
     */
    public boolean isFemal() {
        return false == isMale();
    }

    /**
     * @return int
     * @Title: getGenderCode
     * @Description: ��ȡ���֤�ĵ�17λ������Ϊ���ԣ�ż��ΪŮ��
     * @author
     */
    private int getGenderCode() {
        checkIfValid();
        char genderCode = this.cardNumber.charAt(NEW_CARD_NUMBER_LENGTH - 2);
        return (((int) (genderCode - '0')) & 0x1);
    }

    private String getBirthDayPart() {
        return this.cardNumber.substring(6, 14);
    }

    private SimpleDateFormat createBirthDateParser() {
        return new SimpleDateFormat(BIRTH_DATE_FORMAT);
    }

    private void checkIfValid() {
        if (false == validate()) {
            throw new RuntimeException("���֤���벻��ȷ��");
        }
    }

    /**
     * @param cardNumber
     * @return char
     * @Title: calculateVerifyCode
     * @Description: У���루��ʮ��λ����
     * ʮ��λ���ֱ������Ȩ��͹�ʽ S = Sum(Ai * Wi), i = 0...16 ���ȶ�ǰ17λ���ֵ�Ȩ���
     * Ai:��ʾ��iλ���ϵ����֤��������ֵ
     * Wi:��ʾ��iλ���ϵļ�Ȩ���� Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * ����ģ Y = mod(S, 11)
     * ͨ��ģ�õ���Ӧ��У���� Y: 0 1 2 3 4 5 6 7 8 9 10 У����: 1 0 X 9 8 7 6 5 4 3 2
     */
    private static char calculateVerifyCode(CharSequence cardNumber) {

        int sum = 0;

        char ch;

        for (int i = 0; i < NEW_CARD_NUMBER_LENGTH - 1; i++) {
            ch = cardNumber.charAt(i);
            sum += ((int) (ch - '0')) * VERIFY_CODE_WEIGHT[i];
        }
        return VERIFY_CODE[sum % 11];
    }

    /**
     * @param oldCardNumber 15λ���֤����
     * @Title: contertToNewCardNumber
     * @Description: ��15λ���֤����ת����18λ���֤����
     * @return:
     */
    private static String contertToNewCardNumber(String oldCardNumber) {
          /*
           * 15λ���֤������18λ���֤���������Ϊ��
           * 1: 15λ���֤�����У�"�������"�ֶ���2λ��ת��ʱ��Ҫ����"19"����ʾ20����;
           * 2: 15λ���֤�����һλУ���롣18λ���֤�У�У������ݸ���ǰ17λ����
           */
        StringBuilder buf = new StringBuilder(NEW_CARD_NUMBER_LENGTH);
        buf.append(oldCardNumber.substring(0, 6));
        buf.append("19");
        buf.append(oldCardNumber.substring(6));
        buf.append(CheckIDCardRule.calculateVerifyCode(buf));
        return buf.toString();
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }


    /**
     * String ת���� ʱ��
     *
     * @param str
     * @return
     */
    public static Date strToDate(String str, String patten) {
        if (str != null) {
            if (patten == null)
                patten = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(patten);
            try {
                Date dt = null;
                dt = formatter.parse(str);
                return dt;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		CheckIDCardRule check = new CheckIDCardRule("510 902 19980706 5462") ;
		System.out.println(check.validate());
	}
}
