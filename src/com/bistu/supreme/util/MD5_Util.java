package com.bistu.supreme.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by LiDafei on 2017/10/18.
 * MD5加密工具类
 */

public final class MD5_Util {

    public MD5_Util(){}

    /**
     * 32位的加密
     * */
    public static String encrypByMd5_32(String context) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(context.getBytes());//update处理
            byte [] encryContext = md.digest();//调用该方法完成计算

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 16位的加密
     * */
    public static String encrypByMd5_16(String context){
        String str = encrypByMd5_32(context);
        if(str == null)
            return null;
        else
            return str.substring(8, 24).toLowerCase();
    }
    
    public static void main(String[] args) {
    	System.out.println(MD5_Util.encrypByMd5_32("good"));
    }
}
