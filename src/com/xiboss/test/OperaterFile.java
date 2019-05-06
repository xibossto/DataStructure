package com.xiboss.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * �����ļ�-����������
 * @author xiboss
 *
 */
public class OperaterFile {

	private static ArrayList<Object> scanFiles = new ArrayList<Object>();
	private static int count=0;
	private static String AD = "Day10-Foundation���" ;
	
	public static void main(String[] args) throws FileNotFoundException {
		String path = "E:\\IOS����\\2016������Objective-C-video\\"+AD+"\\" ;
		System.out.println(path.length());
		scanFilesWithRecursion(path) ;
		System.out.println("count:"+count) ;
	}
	
	  /**
     * ����������
     * ������·���е������ļ�,������Ϊǰ׺+���+�ļ���׺������ʽ
     * @param dirPath
     * @param prefix
     */
    public static void renameFiles(String dirPath,String newFileName){
        File file=new File(dirPath);
        if(!file.isDirectory()){
            return;
        }
        File files[]=file.listFiles();
//        int index=1;

        for(File f:files){
//            File newFile=new File(dirPath,prefix+String.valueOf(index++)+".mp4");
            File newFile=new File(dirPath,newFileName+".mp4");
            f.renameTo(newFile);
        }
    }
    
    
    /**
	 * TODO:�ݹ�ɨ��ָ���ļ��������ָ���ļ�
	 * @return ArrayList<Object>
	 * @throws FileNotFoundException 
	 */
	public static void scanFilesWithRecursion(String folderPath) throws FileNotFoundException{
		File directory = new File(folderPath);
		if(!directory.isDirectory()){
			System.out.println("ɨ�������");
			throw new FileNotFoundException('"' + folderPath + '"' + " input path is not a Directory , please input the right path of the Directory. ^_^...^_^");
		}
		if(directory.isDirectory()){
			File [] filelist = directory.listFiles();
			for(int i = 0; i < filelist.length; i ++){
				/**�����ǰ���ļ��У�����ݹ�ɨ���ļ���**/
				if(filelist[i].isDirectory()){
					/**�ݹ�ɨ��������ļ���**/
					count++;
					scanFilesWithRecursion(filelist[i].getAbsolutePath());
				}else{			
					/**���ļ���**/
					scanFiles.add(filelist[i].getAbsolutePath());
					System.out.println(filelist[i]);
					if (filelist[i].getName().contains(AD)) {
//						filelist[i].renameTo(new File(filelist[i].getAbsoluteFile()+filelist[i].getName().replace("Day01-Objective-C�﷨����", "")));
						filelist[i].renameTo(new File(folderPath+filelist[i].getName().replace(AD, "")));
					 }
				}
			}
		}
	}
    
}
