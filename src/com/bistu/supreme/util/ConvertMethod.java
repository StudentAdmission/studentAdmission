package com.bistu.supreme.util;

import java.util.ArrayList;
import java.util.List;

import com.bistu.supreme.domain.Handbook;

public final class ConvertMethod {
	public static String ConvertHandBookList2JSON(List<Handbook> list) {
		String str = "";
		str = "{" + "\"data\":[" + ConvertHandbook2JSON(list.get(0));
		for(int i=1;i<list.size();i++) {
			str = str + "," + ConvertHandbook2JSON(list.get(i));
		}
		str = str + "]}";
		return str;
	}
	public static String ConvertHandbook2JSON(Handbook hb) {
		String str = "{" + "\"hb_grade\":" + hb.getHbGrade() + "," +
				           "\"hb_cname\":\"" + hb.getHbCname() + "\"," +
				           "\"hb_ename\":\"" + hb.getHbEname() + "\"" +
				     "}";
		return str;
	}
	
	public static void main(String[] args) {
		Handbook hb = new Handbook();
		hb.setHbCname("2222");
		hb.setHbEname("111");
		hb.setHbGrade(2017);
		List<Handbook> list = new ArrayList<Handbook>();
		list.add(hb);
		list.add(hb);
		list.add(hb);
		System.out.println(ConvertMethod.ConvertHandBookList2JSON(list));
	}
}
