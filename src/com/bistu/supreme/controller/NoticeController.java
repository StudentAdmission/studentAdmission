/**
 * 
 */
package com.bistu.supreme.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.dao.IStudentDao;
import com.bistu.supreme.dao.IStudentMessageBoxDao;
import com.bistu.supreme.domain.Notice;
import com.bistu.supreme.domain.Response;
import com.bistu.supreme.util.File_Utils;

@Controller
public class NoticeController {
	@Autowired
	private INoticeDao noticeDao;
	@Autowired
	private IStudentMessageBoxDao sMBoxDao;
	@Autowired
	private IStudentDao studentDao;
	
	@RequestMapping(value="/getAllNotice",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getAllNotice(@RequestBody String studentId){
		Response response = new Response();
		List<Notice> getAllNotice = noticeDao.getAllNoticeOfStudent(studentId);
		if(getAllNotice.get(0).getNoticeId()!=-1&&getAllNotice!=null){
			return response.success(getAllNotice);
		}
		else if(getAllNotice.get(0).getNoticeId()==-1){
			return response.success("the student hasn't messages",getAllNotice);
		}
		else
			return response.failure();
		
	}
	/**
	 * 添加通知信息及附件
	 * */
	@RequestMapping(value = "/setNotice")
    @ResponseBody
	public Response setNotice(HttpServletRequest request,@RequestParam("noticeFile") MultipartFile file) {
		Notice notice = new Notice();
		Response response = new Response();
		if(request instanceof MultipartHttpServletRequest) {
        	File_Utils.checkDir("/files/upload");
        	String filePath= File_Utils.FilesUpload_stream(request,file,"/files/upload");
        	System.out.println("****"+notice.getNoticeReceiveClassNum()+"****");
    		notice.setNoticePushTheNumber(studentDao.calculateNumbyClassNum(
    				notice.getNoticeReceiveClassNum()));
    		System.out.println(studentDao.calculateNumbyClassNum(
    				notice.getNoticeReceiveClassNum()));
        	if(noticeDao.setNewNotice(notice)) {
        		sMBoxDao.createStudentMessagebyClassNum(notice.getNoticeId(), notice.getNoticeReceiveClassNum());
        		return response.success(filePath);
        	}
        	else {
        		return response.failure("sql_exception");
        	}
        }
        else {
        	return response.failure("bad_request");
        }
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getAllNoticeFeedback",method=RequestMethod.POST,
			produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public Response getTeacherNotices(@RequestBody String num) {
		Response response = new Response();
		int readNum = 0;
		int unreadNum = 0;
		List<Notice> list = noticeDao.getNoticesbyNum(num);
		if(list == null || list.size() == 0) {
			return response.success("notice_not_found");
		}
		else 
			if(list.get(0).getNoticeId() == -1) {
				return response.failure("sql_exception");
			}
			else {
				for(int i=0;i<list.size();i++) {
					List<String> read = new ArrayList<String>();
					List<String> unread = new ArrayList<String>();
					Map<String, Object> readMap = sMBoxDao.getReadList(list.get(i).getNoticeId()); 
					Map<String, Object> unreadMap = sMBoxDao.getUnReadList(list.get(i).getNoticeId());
					readNum = (int)readMap.get("read_num");
					read = (List<String>)readMap.get("read_list");
					unreadNum = (int)unreadMap.get("unread_num");
					unread = (List<String>)unreadMap.get("unread_list");
					list.get(i).setNoticeReadNumber(readNum);
					list.get(i).setNoticeUnreadNumber(unreadNum);
					list.get(i).setNoticeReadList(read);
					list.get(i).setNoticeUnReadList(unread);
				}
				return response.success(list);
			}
	}
}
