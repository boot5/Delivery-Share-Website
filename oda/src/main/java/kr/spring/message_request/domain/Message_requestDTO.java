package kr.spring.message_request.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class Message_requestDTO {
	private int mess_num ; //주문메시지 번호
	private int req_num ; //주문메시지 번호
	private String mess_deli; //배달자 id
	private int mess_check; //주문여부
	private int re_num; //주문 가게명
	private Date re_date;
	private String id;
	
	private String req_pname;
	
	public int getMess_num() {
		return mess_num;
	}
	public void setMess_num(int mess_num) {
		this.mess_num = mess_num;
	}
	public int getReq_num() {
		return req_num;
	}
	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	public String getMess_deli() {
		return mess_deli;
	}
	public void setMess_deli(String mess_deli) {
		this.mess_deli = mess_deli;
	}
	public int getMess_check() {
		return mess_check;
	}
	public void setMess_check(int mess_check) {
		this.mess_check = mess_check;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReq_pname() {
		return req_pname;
	}
	public void setReq_pname(String req_pname) {
		this.req_pname = req_pname;
	}
	
}
