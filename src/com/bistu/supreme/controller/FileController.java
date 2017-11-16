package com.bistu.supreme.controller;

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
    public Response fileUpload(HttpServletRequest request, @RequestParam("file_upload") MultipartFile file, @RequestParam("login_num") String num) {
    	Response response = new Response();
    	if(request instanceof MultipartHttpServletRequest) {
        	String filePath= File_Utils.FilesUpload_stream(request,file,"/files/upload",num);
        	return response.success(filePath);
        }
        else {
        	return response.failure("bad_request");
        }
    }
}
