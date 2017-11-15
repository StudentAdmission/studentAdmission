package com.bistu.supreme.domain;


/**
 * 对应数据库中的sa_student表
 * */
public class Student {
	/**
	 * 学生的学号
	 * */
	private String stdNum;
	/**
	 * 学生姓名
	 * */
	private String stdName;
	/**
	 * 学生性别
	 * */
	private String stdGender;
	/**
	 * 学生主修专业
	 * */
	private String stdMajor;
	/**
	 * 学生班级号
	 * */
	private String stdClassNum;
	/**
	 * 学生宿舍号
	 * */
	private String stdDormNum;
	/**
	 * 学生学院
	 * */
	private String stdCollege;
	/**
	 * 学生电话
	 * */
	private Long stdTele;
	/**
	 * 学生民族
	 * */
	private String stdNation;
	/**
	 * 学生地址
	 * */
	private String stdAddress;
	/**
	 * 学生的邮编
	 * */
	private int stdPostCode;
	/**
	 * 学生身份证号
	 * */
	private String stdIdentification;
	/**
	 * 学生邮箱
	 * */
	private String stdEmail;
	/**
	 * 学生的年级
	 * */
	private int stdGrade;
	/**
	 * 学生的籍贯
	 * */
	private String stdNativePlace;
	/**
	 * 学生父亲姓名
	 * */
	private String stdFatherName;
	/**
	 * 学生父亲电话
	 * */
	private long stdFatherTele;
	/**
	 * 学生母亲姓名
	 * */
	private String stdMotherName;
	/**
	 * 学生母亲电话
	 * */
	private long stdMotherTele;
	/**
	 * 学生的政治面貌
	 * */
	private String stdPoliticalStatus;
	/**
	 * 学生生日
	 * */
	private String stdBirth;
	/**
	 * 学生的QQ
	 * */
	private long stdQQ;
	/**
	 * 学生的微信
	 * */
	private String stdWechat;
	/**
	 * 学生的户口迁移情况
	 * */
	private String stdAccountMigration;
	/**
	 * 学生的照片
	 * */
	private String stdIdPhoto;
	/**
	 * 学历
	 * */
	private String stdEducation;
	
	/**
	 * 准考证号
	 * */
	private long stdTicketNumber;
	/**
	 * 生源地
	 * */
	private String stdSourceOfHealth;
	public String getStdEducation() {
		return stdEducation;
	}
	public void setStdEducation(String stdEducation) {
		this.stdEducation = stdEducation;
	}
	public long getStdTicketNumber() {
		return stdTicketNumber;
	}
	public void setStdTicketNumber(long stdTicketNumber) {
		this.stdTicketNumber = stdTicketNumber;
	}
	public String getStdSourceOfHealth() {
		return stdSourceOfHealth;
	}
	public void setStdSourceOfHealth(String stdSourceOfHealth) {
		this.stdSourceOfHealth = stdSourceOfHealth;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdGender() {
		return stdGender;
	}
	public void setStdGender(String stdGender) {
		this.stdGender = stdGender;
	}
	public String getStdMajor() {
		return stdMajor;
	}
	public void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}
	public String getStdClassNum() {
		return stdClassNum;
	}
	public void setStdClassNum(String stdClassNum) {
		this.stdClassNum = stdClassNum;
	}
	public String getStdDormNum() {
		return stdDormNum;
	}
	public void setStdDormNum(String stdDormNum) {
		this.stdDormNum = stdDormNum;
	}
	public String getStdCollege() {
		return stdCollege;
	}
	public void setStdCollege(String stdCollege) {
		this.stdCollege = stdCollege;
	}
	public long getStdTele() {
		return stdTele;
	}
	public void setStdTele(long stdTele) {
		this.stdTele = stdTele;
	}
	public String getStdNation() {
		return stdNation;
	}
	public void setStdNation(String stdNation) {
		this.stdNation = stdNation;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public int getStdPostCode() {
		return stdPostCode;
	}
	public void setStdPostCode(int stdPostCode) {
		this.stdPostCode = stdPostCode;
	}
	public String getStdIdentification() {
		return stdIdentification;
	}
	public void setStdIdentification(String stdIdentification) {
		this.stdIdentification = stdIdentification;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public int getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(int stdGrade) {
		this.stdGrade = stdGrade;
	}
	public String getStdNativePlace() {
		return stdNativePlace;
	}
	public void setStdNativePlace(String stdNativePlace) {
		this.stdNativePlace = stdNativePlace;
	}
	public String getStdFatherName() {
		return stdFatherName;
	}
	public void setStdFatherName(String stdFatherName) {
		this.stdFatherName = stdFatherName;
	}
	public long getStdFatherTele() {
		return stdFatherTele;
	}
	public void setStdFatherTele(long stdFatherTele) {
		this.stdFatherTele = stdFatherTele;
	}
	public String getStdMotherName() {
		return stdMotherName;
	}
	public void setStdMotherName(String stdMotherName) {
		this.stdMotherName = stdMotherName;
	}
	public long getStdMotherTele() {
		return stdMotherTele;
	}
	public void setStdMotherTele(long stdMotherTele) {
		this.stdMotherTele = stdMotherTele;
	}
	public String getStdPoliticalStatus() {
		return stdPoliticalStatus;
	}
	public void setStdPoliticalStatus(String stdPoliticalStatus) {
		this.stdPoliticalStatus = stdPoliticalStatus;
	}
	public String getStdBirth() {
		return stdBirth;
	}
	public void setStdBirth(String stdBirth) {
		this.stdBirth = stdBirth;
	}
	public long getStdQQ() {
		return stdQQ;
	}
	public void setStdQQ(long stdQQ) {
		this.stdQQ = stdQQ;
	}
	public String getStdWechat() {
		return stdWechat;
	}
	public void setStdWechat(String stdWechat) {
		this.stdWechat = stdWechat;
	}
	public String getStdAccountMigration() {
		return stdAccountMigration;
	}
	public void setStdAccountMigration(String stdAccountMigration) {
		this.stdAccountMigration = stdAccountMigration;
	}
	public String getStdIdPhoto() {
		return stdIdPhoto;
	}
	public void setStdIdPhoto(String stdIdPhoto) {
		this.stdIdPhoto = stdIdPhoto;
	}
	
}
