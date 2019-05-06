package com.xiboss.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 操作文件-批量重名名
 * @author xiboss
 *
 */
public class OperaterFile {

	private static ArrayList<Object> scanFiles = new ArrayList<Object>();
	private static int count=0;
	private static String AD = "Day10-Foundation框架" ;
	
	public static void main(String[] args) throws FileNotFoundException {
		String path = "E:\\IOS开发\\2016年最新Objective-C-video\\"+AD+"\\" ;
		System.out.println(path.length());
		scanFilesWithRecursion(path) ;
		System.out.println("count:"+count) ;
	}
	
	  /**
     * 批量重命名
     * 将传入路径中的所有文件,重命名为前缀+序号+文件后缀名的形式
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
	 * TODO:递归扫描指定文件夹下面的指定文件
	 * @return ArrayList<Object>
	 * @throws FileNotFoundException 
	 */
	public static void scanFilesWithRecursion(String folderPath) throws FileNotFoundException{
		File directory = new File(folderPath);
		if(!directory.isDirectory()){
			System.out.println("扫描结束！");
			throw new FileNotFoundException('"' + folderPath + '"' + " input path is not a Directory , please input the right path of the Directory. ^_^...^_^");
		}
		if(directory.isDirectory()){
			File [] filelist = directory.listFiles();
			for(int i = 0; i < filelist.length; i ++){
				/**如果当前是文件夹，进入递归扫描文件夹**/
				if(filelist[i].isDirectory()){
					/**递归扫描下面的文件夹**/
					count++;
					scanFilesWithRecursion(filelist[i].getAbsolutePath());
				}else{			
					/**非文件夹**/
					scanFiles.add(filelist[i].getAbsolutePath());
					System.out.println(filelist[i]);
					if (filelist[i].getName().contains(AD)) {
//						filelist[i].renameTo(new File(filelist[i].getAbsoluteFile()+filelist[i].getName().replace("Day01-Objective-C语法基础", "")));
						filelist[i].renameTo(new File(folderPath+filelist[i].getName().replace(AD, "")));
					 }
				}
			}
		}
	}
    
}
