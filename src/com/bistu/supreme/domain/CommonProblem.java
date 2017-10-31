package com.bistu.supreme.domain;

/*常见问题的基本类*/
public class CommonProblem {
	/* 常见问题的id号 */
	private int CPid;

	/* 常见问题的题设 */
	private String CPquestion;

	/* 常见问题的答案 */
	private String CPanswer;

	/* 常见问题的链接地址 */
	private String CPWebLinks;

	public CommonProblem() {

		super();
	}

	public CommonProblem(int CPid) {

		super();
		this.CPid = CPid;
	}

	public int getCPid() {
		return CPid;
	}

	public void setCPid(int cPid) {
		CPid = cPid;
	}

	public String getCPquestion() {
		return CPquestion;
	}

	public void setCPquestion(String cPquestion) {
		CPquestion = cPquestion;
	}

	public String getCPanswer() {
		return CPanswer;
	}

	public void setCPanswer(String cPanswer) {
		CPanswer = cPanswer;
	}

	public String getCPWebLinks() {
		return CPWebLinks;
	}

	public void setCPWebLinks(String cPWebLinks) {
		CPWebLinks = cPWebLinks;
	}

}
