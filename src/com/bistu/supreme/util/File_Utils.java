package com.bistu.supreme.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public static String FilesUpload_stream(HttpServletRequest request,MultipartFile multipartFile,String filePath,String name) {
        if (multipartFile != null) {
            //获取文件的后缀
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            String fileName = name + "_" + getDate() + suffix;
            String absolutePath = getServerPath(request, filePath);
            checkDir(absolutePath);
            System.out.println(absolutePath + File.separator + fileName);
            try{
                InputStream inputStream = multipartFile.getInputStream();
                long size = multipartFile.getSize();
                System.out.println("文件长度为：" + size);
                FileOutputStream fileOutputStream = new FileOutputStream(absolutePath + File.separator + fileName);
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
                return fileName;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        } else {
        	return null;
        }
    }
	
    /**
     * 以流的方式下载文件
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param filePath example "/filesOut/Download/mst.txt"
     * @return
     */
    public static void FilesDownload_stream(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) {
        //get server path (real path)
        String realPath = getServerPath(request, filePath) + "/" +fileName;
        File file = new File(realPath);
        String filenames = file.getName();
        InputStream inputStream;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);// 输出文件
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取服务器路径
     * */
    public static String getServerPath(HttpServletRequest request, String filePath) {
    	if(System.getProperty("os.name").equals("Linux")) {
    		String path = System.getProperty("user.dir");
    		return path.substring(0,path.lastIndexOf(File.separator)) + "/webapps" + filePath;
    	}
    	String fp = request.getSession().getServletContext().getRealPath("");
    	System.out.println(fp);
    	return fp.substring(0,fp.lastIndexOf("\\studentAdmission")) + filePath;
    }

    /**
     * 以“年月日”的形式获取当前时间
     * */
    public static String getDate() {
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
}
