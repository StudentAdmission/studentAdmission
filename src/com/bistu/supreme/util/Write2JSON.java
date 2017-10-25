package com.bistu.supreme.util;

import java.io.FileOutputStream;

/**
 * 工具类，实现将字符串写入JSON文件
 * */
public final class Write2JSON {
	public static void write2Json(String data) {
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("WebContent/res/data/manualData.json");
			String s = data;
			byte array[] = new byte[1024];
			array = s.getBytes("utf-8");  //将字符串s转化为字节数组
			fos.write(array);
			fos.close();
		}
		catch(Exception e){
			System.out.println("此文件不存在");
		}
	}
}
