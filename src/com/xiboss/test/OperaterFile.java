package com.xiboss.test;

import java.io.File;

/**
 * �����ļ�-����������
 * @author xiboss
 *
 */
public class OperaterFile {
	public static void main(String[] args) {
		
	}
	
	  /**
     * ����������
     * ������·���е������ļ�,������Ϊǰ׺+���+�ļ���׺������ʽ
     * @param dirPath
     * @param prefix
     */
    public static void renameFiles(String dirPath,String prefix){
        File file=new File(dirPath);
        if(!file.isDirectory()){
            return;
        }
        File files[]=file.listFiles();
        int index=1;

        for(File f:files){
            File newFile=new File(dirPath,prefix+String.valueOf(index++)+".png");
            f.renameTo(newFile);
        }
    }
}
