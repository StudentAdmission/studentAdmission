package com.bistu.supreme.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public final class File_Utils {

	private File_Utils() {}
	
	/**
     * 以流的形式上传文件
     * @param request       HttpServletRequest
     * @param multipartFile MultipartFile  support CommonsMultipartFile file
     * @param filePath      filePath example "/files/Upload"
     * @return
     */
    public static String FilesUpload_stream(HttpServletRequest request,MultipartFile multipartFile,String filePath) {
        if (multipartFile != null) {
            //获取文件的后缀
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            //获取文件的完整路径
            String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
            //获取文件的相对路径
            String relativePath = getRelativePath(filePath, suffix);
            try{
                InputStream inputStream = multipartFile.getInputStream();
                long size = multipartFile.getSize();
                System.out.println("文件长度为：" + size);
                FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                byte buffer[] = new byte[4096]; //create a buffer
                long fileSize = multipartFile.getSize();
                if(fileSize<=buffer.length){//if fileSize < buffer
                    buffer = new byte[(int)fileSize];
                }
                int line =0;
                while((line = inputStream.read(buffer)) >0 )
                {
                    fileOutputStream.write(buffer,0,line);
                }
                fileOutputStream.close();
                inputStream.close();
                return relativePath;
            }catch (Exception e){
                e.printStackTrace();
            }
        } else
            return null;
        return null;
    }
	
    /**
     * 获取服务器中的路径
     * */
    public static String getServerPath(HttpServletRequest request, String filePath) {
        return request.getSession().getServletContext().getRealPath(filePath);
    }

    /**
     * 以“年月日”的形式获取当前时间
     * */
    public static String getDataPath() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 查看文件的目录是否被创建
     * */
    public static void checkDir(String savePath) {
        File dir = new File(savePath);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
    }

    /**
     * 获取文件的通用唯一识别码名称
     * */
    public static String getUUIDName(String suffix) {
        return UUID.randomUUID().toString() + suffix;// 创建新的文件名
    }

    /**
     * 获取文件的绝对路径
     * */
    public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String suffix) {
        String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
        checkDir(savePath);
        return savePath + getUUIDName(suffix);
    }

    /**
     * 获取文件的相对路径
     * */
    public static String getRelativePath(String filePath, String suffix) {
        return filePath + File.separator + getDataPath() + File.separator + getUUIDName(suffix);//example:/files/Upload/20160912/
    }
}
