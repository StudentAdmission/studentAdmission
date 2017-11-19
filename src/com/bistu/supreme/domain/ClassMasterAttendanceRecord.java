package com.bistu.supreme.domain;
/**
 * 对应数据库中的sa_classmaster_attendance_record表
 * */
public class ClassMasterAttendanceRecord {
	/**
	 * 记录id
	 * */
	private int carId;
	/**
	 * 班主任的职工号
	 * */
	private String carClassMasterNum;
	/**
	 * 听课时间
	 * */
	private String carTime;
	/**
	 * 听课教室
	 * */
	private String carClassRoom;
	/**
	 * 课程名称
	 * */
	private String carCourseTitle;
	/**
	 * 任课教师职工号
	 * */
	private String carTeacherNum;
	/**
	 * 应到人数
	 * */
	private int carShouldBeNumber;
	/**
	 * 实际到课人数
	 * */
	private int carReachedTheNumber;
	/**
	 * 情况记录
	 * */
	private String carSituationRecord;
	/**
	 * 班主任姓名
	 * */
	private String carClassMasterName;
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarClassMasterNum() {
		return carClassMasterNum;
	}
	public void setCarClassMasterNum(String carClassMasterNum) {
		this.carClassMasterNum = carClassMasterNum;
	}
	public String getCarTime() {
		return carTime;
	}
	public void setCarTime(String carTime) {
		this.carTime = carTime;
	}
	public String getCarClassRoom() {
		return carClassRoom;
	}
	public void setCarClassRoom(String carClassRoom) {
		this.carClassRoom = carClassRoom;
	}
	public String getCarCourseTitle() {
		return carCourseTitle;
	}
	public void setCarCourseTitle(String carCourseTitle) {
		this.carCourseTitle = carCourseTitle;
	}
	public String getCarTeacherNum() {
		return carTeacherNum;
	}
	public void setCarTeacherNum(String carTeacherNum) {
		this.carTeacherNum = carTeacherNum;
	}
	public int getCarShouldBeNumber() {
		return carShouldBeNumber;
	}
	public void setCarShouldBeNumber(int carShouldBeNumber) {
		this.carShouldBeNumber = carShouldBeNumber;
	}
	public int getCarReachedTheNumber() {
		return carReachedTheNumber;
	}
	public void setCarReachedTheNumber(int carReachedTheNumber) {
		this.carReachedTheNumber = carReachedTheNumber;
	}
	public String getCarSituationRecord() {
		return carSituationRecord;
	}
	public void setCarSituationRecord(String carSituationRecord) {
		this.carSituationRecord = carSituationRecord;
	}
	public String getCarClassMasterName() {
		return carClassMasterName;
	}
	public void setCarClassMasterName(String carClassMasterName) {
		this.carClassMasterName = carClassMasterName;
	}
}
