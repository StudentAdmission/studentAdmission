package com.bistu.supreme.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bistu.supreme.domain.Response;
import com.bistu.supreme.util.File_Utils;


@Controller
public class FileController {
	/**
     * 文件下载
     * @param request
     * @param response
     */
    @RequestMapping(value = "/fileDownload")
    @ResponseBody
    public Response fileDownload_servlet(HttpServletRequest request, 
    		HttpServletResponse response, @RequestBody String fileName) {
    	Response response_return  = new Response();
        File_Utils.FilesDownload_stream(request,response,"/files/download" , fileName);
        return response_return.success();
    }
    
    /**
     * 文件上传
     * */
    @RequestMapping(value = "/fileUpload", method=RequestMethod.POST)
    @ResponseBody
    public Response fileUpload(HttpServletRequest request, @RequestParam("file_upload") MultipartFile file, 
    		@RequestParam("file_url") String filePath, @RequestParam("login_num") String num) {
    	Response response = new Response();
    	if(request instanceof MultipartHttpServletRequest) {
        	String fileName= File_Utils.FilesUpload_stream(request,file,filePath,num);
        	if(fileName == null) {
        		return response.failure("file_upload_fail");
        	}
        	else {
        		return response.success(fileName);
        	}
        }
        else {
        	return response.failure("bad_request");
        }
    }
    
    /**
     * 测试文件路径
     * */
    @RequestMapping(value = "/filePath", method=RequestMethod.POST)
    @ResponseBody
    public Response getFilePath(HttpServletRequest request) {
    	Response response = new Response();
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("os_name", System.getProperty("os.name"));
    	map.put("user_dir", System.getProperty("user.dir"));
    	return response.success(map);
    }
}
