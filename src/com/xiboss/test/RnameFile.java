package com.xiboss.test;

import java.io.File;
import java.util.Arrays;

/*
 * 自动扫描文件夹下的所有文件并去除文件名中的广告字段
 * */
public class RnameFile {
	
	// 在此输入要删去的广告内容
	public static final String AD = "（更多视频教程关注微信公众号【菜鸟要飞】";
	
	//定义标志位
	public static boolean flag = true ;
	
	//定义新路径
	public static String newPath = null ;

	public static void main(String[] args) {
		//文件或其文件夹所在路径
		String path = "E:\\ios开发\\小码哥ios11期" ;
//		scanDirectory(path) ;
		scanFile(path) ;
		System.out.println("程序执行完毕！");
	}
	
//	public static void scanDirectory(String path) {
//		File oldFile = new File(path) ;
//		if(path.contains(AD)) {
//			String newPath = path.replace(AD, "") ;
//			File newFile = new File(newPath) ;
//			oldFile.renameTo(newFile) ;
//			scanFile(newPath) ;
//		}else {
//			scanFile(path) ;
//		}
//	}
	
	/**
	 * 递归查找指定文件夹下的所有文件
	 * @param path
	 * @return
	 */
	public static String scanFile(String path) {
		File root = null ;
		if(newPath == null) {
			root = new File(path) ;
		}else {
			root = new File(newPath) ;
		}
		File rootDir = new File(path) ;
		//如果是一个目录就执行
		if(rootDir.isDirectory()) {
			//递归
			String[] fileList = root.list() ;
			System.out.println(Arrays.toString(fileList));
			for (int i = 0; i < fileList.length; i++) {
				path = root.getAbsolutePath() + "\\" + fileList[i];
				rootDir = new File(path) ;
				newPath = path.replace(AD, "") ;
				rootDir.renameTo(new File(newPath)) ;
				rootDir = new File(newPath) ;
//				System.out.println("path:"+path);
//				System.out.println("newPath:"+newPath);
				System.out.println("rootDir =:"+rootDir.getAbsolutePath());
				scanFile(newPath) ;
			}
		}else {
			System.out.println(renameFile(rootDir));
		}
		return null ;
	}
	
	
	
	/**
	 * 重名名
	 * @param file
	 */
//	public static void renameFile(File file) {
//		//获得原文件名
//		String orignName = file.getName() ;
//		//判断原文件名是否包含广告字段
//		if(orignName.contains(AD)) {
//			//获得目录路径
//			String dirPath = file.getAbsolutePath() ;
//			//取除广告字段
//			String newString = dirPath.replace(AD, "") ;
//			System.out.println(newString);		//打印去除后的名字
//			File finalName = new File(newString) ;
//			//更换新名字
//			boolean flag = file.renameTo(finalName) ;
//			System.out.println(flag);
//		}
//	}
	
	 public static boolean renameFile(File f) {
		 String originalName = f.getName();
		 if (originalName.contains(AD)) {
		     String dirPath = f.getAbsolutePath();// 目录路径
		     String newString = dirPath.replace(AD, "");
		     String toFileName = newString;
		     //打印新名字
		     System.out.println(toFileName);
		     File finalName = new File(toFileName);
		     flag = f.renameTo(finalName);
		 }
		return flag;
     }
	
}