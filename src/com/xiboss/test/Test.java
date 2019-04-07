package com.xiboss.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 复制多个文件并随机重名名
 * @author xiboss
 * @create 2019-04-05 22:43
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String sourcePath;
        String destPath;
        File source = null ;
        File dest = null ;

        for (int i = 1; i < 59; i++) {
        	sourcePath =  "C:\\Users\\xiboss\\Desktop\\计16.3\\1.jpg"  ;
            destPath = "C:\\Users\\xiboss\\Desktop\\计16.3\\"+ renameFile(i) + ".jpg" ;
            source = new File(sourcePath) ;
            dest = new File(destPath) ;
            copyFile(source,dest);
        }
        
        System.out.println("执行完毕！");
    }

    /*重新命名文件方法*/
    public static String renameFile(int i){
        String s = "201610430" ;     //初始化
        if(i > 0 && i < 10){
            s += "0" + i ;
            return s ;
        }else{
            s +=  i ;
            return s ;
        }

    }

    /**
     * 复制文件
     * @param source   源文件
     * @param dest   目标位置
     */
    public static void copyFile( File source, File dest) throws IOException {
        /*InputStream inputStream = null ;
        OutputStream outputStream = null ;
        try {
            inputStream = new FileInputStream(source) ;
            outputStream = new FileOutputStream(dest) ;
            byte[] buffer = new byte[1024] ;
            int bytes ;
            while((bytes = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,bytes) ;
            }
        }catch (Exception e){
            System.out.println("执行失败");
        }finally {
            inputStream.close();
            outputStream.close();
        }*/
    	
    	FileInputStream ins = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(dest);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        
        ins.close();
        out.close();
    }
}
