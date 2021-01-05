package kr.spring.request.domain;

import kr.spring.util.DurationFromNow;

public class RequestReplyDTO {
	private int re_num;
	private String re_content;
	private String re_date;
	private String mess_date;
	private String re_ip;
	private int re_accept;	
	private int req_num;
	private String id;
	
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = DurationFromNow.getTimeDiffLabel(re_date);
		setMess_date(re_date);
	}
	
	public String getMess_date() {
		return mess_date;
	}
	public void setMess_date(String mess_date) {
		this.mess_date = mess_date;
	}
	public String getRe_ip() {
		return re_ip;
	}
	public void setRe_ip(String re_ip) {
		this.re_ip = re_ip;
	}
	
	public int getRe_accept() {
		return re_accept;
	}
	public void setRe_accept(int re_accept) {
		this.re_accept = re_accept;
	}
	public int getReq_num() {
		return req_num;
	}
	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "RequestReplyDTO [re_num=" + re_num + ", re_content=" + re_content + ", re_date=" + re_date + ", re_ip="
				+ re_ip + ", re_accept=" + re_accept + ", req_num=" + req_num + ", id=" + id + "]";
	}
}
