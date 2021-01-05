package kr.spring.notice.domain;

import java.sql.Date;

public class NoticeDTO {
	private int noti_num;
	private String noti_title;
	private String id;
	private String noti_content;
	private Date noti_date;
	private int noti_hit;
	
	public int getNoti_num() {
		return noti_num;
	}
	public void setNoti_num(int noti_num) {
		this.noti_num = noti_num;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	public Date getNoti_date() {
		return noti_date;
	}
	public void setNoti_date(Date noti_date) {
		this.noti_date = noti_date;
	}
	public int getNoti_hit() {
		return noti_hit;
	}
	public void setNoti_hit(int noti_hit) {
		this.noti_hit = noti_hit;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [noti_num=" + noti_num + ", noti_title=" + noti_title + ", id=" + id + ", noti_content="
				+ noti_content + ", noti_date=" + noti_date + ", noti_hit=" + noti_hit + "]";
	}
	
	
}
