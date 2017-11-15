package com.bistu.supreme.util;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import com.bistu.supreme.util.File_Utils;

/**
 * 工具类，实现将字符串写入JSON文件
 * */
public final class Write2JSON {
	public static void write2Json(HttpServletRequest request, String data, String fileName) {
		String filePath = request.getSession().getServletContext().getRealPath("/res/data");
		File_Utils.checkDir(filePath);
		FileOutputStream fos = null;
		try{
			File file = new File(filePath + File.separator +fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			String s = data;
			byte array[] = new byte[1024];
			array = s.getBytes("utf-8");  //将字符串s转化为字节数组
			fos.write(array);
			fos.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("此文件不存在");
		}
	}
}
