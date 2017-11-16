/**
 * 
 */
package com.bistu.supreme.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bistu.supreme.dao.IClassDao;
import com.bistu.supreme.dao.INoticeDao;
import com.bistu.supreme.dao.IStudentMessageBoxDao;
import com.bistu.supreme.dao.ITeacherDao;
import com.bistu.supreme.domain.Notice;
import com.bistu.supreme.domain.Response;

@Controller
public class NoticeController {
	@Autowired
	private INoticeDao noticeDao;
	@Autowired
	private IStudentMessageBoxDao sMBoxDao;
	@Autowired
	private IClassDao classDao;
	@Autowired
	private ITeacherDao teacherDao;
	
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
	@RequestMapping(value = "/setNotice",method=RequestMethod.POST)
    @ResponseBody
	public Response setNotice(@RequestParam("notice_title")String title, @RequestParam("notice_content")String content, @RequestParam("notice_num")String num) {
		Response response = new Response();
		Notice notice = new Notice();
		String file_c_name = "";
		String file_e_name = "";
		notice.setNoticeAnnouncerNum(num);
		notice.setNoticeContent(content);
		notice.setNoticeTitle(title);
		notice.setNoticeFileCName(file_c_name);
		notice.setNoticeFileEName(file_e_name);
		List<String> class_num = new ArrayList<String>();
		Map<String, Object> map = teacherDao.getTeacherInfobyNum(num);
		if((int)map.get("grade") == 0) {
			response.failure("teacher_not_found");
		}
		else
			if((int)map.get("grade")==-1) {
				response.failure("sql_exception");
			}
			else {
				switch((String)map.get("identity")) {
				//班主任
				case "1":
					class_num.add(classDao.getClassNumbyNum(num));
					break;
				//辅导员
				case "2":
					class_num = classDao.getClassNumsbyCollegeandGrade(
							(String)map.get("college"), (int)map.get("grade"));
					break;
				default:
					return response.failure("have_no_permission");
				}
			}
		for(int i=0;i<class_num.size();i++) {
			notice.setNoticeReceiveClassNum(class_num.get(i));
			if(noticeDao.setNewNotice(notice)) {
				sMBoxDao.createStudentMessagebyClassNum(notice.getNoticeId(), 
						notice.getNoticeReceiveClassNum());
			}
			else {
				return response.failure("sql_exception");
			}
		}
		return response.success();
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
