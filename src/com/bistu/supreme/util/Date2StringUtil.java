package com.bistu.supreme.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 将Date的time转换成String的time
 * */
public final class Date2StringUtil {
	public static Map<String, String> getMandD(String str){
		Map<String,String> map = new HashMap<String,String>();
		String month = "";
		String year = "";
		int start = 0;
		int middle = 0;
		int end = 0;
		String day = "";
		start = str.indexOf("-");
		middle = str.lastIndexOf("-");
		end = str.indexOf(" ");
		year = str.substring(0, start);
		month = str.substring(start+1, middle);
		day = str.substring(middle+1, end);
		map.put("year",year);
		map.put("month", month);
		map.put("day", day);
		return map;
	}
	
	public static void main(String[] args){
		Date2StringUtil.getMandD("2017-11-13 15:43:26.0");
	}
	
}
