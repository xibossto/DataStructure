package com.xiboss.test;

import java.io.File;

/**
 * 操作文件-批量重名名
 * @author xiboss
 *
 */
public class OperaterFile {
	public static void main(String[] args) {
		
	}
	
	  /**
     * 批量重命名
     * 将传入路径中的所有文件,重命名为前缀+序号+文件后缀名的形式
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
