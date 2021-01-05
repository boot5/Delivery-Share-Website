package kr.spring.blacklist.domain;

import java.sql.Date;

public class BlackDTO {
	private int bla_num;
	private String bla_id;
	private String bla_title;
	private String bla_content;
	private int bla_hit;
	private Date bla_date;
	private String id;
	public int getBla_num() {
		return bla_num;
	}
	public void setBla_num(int bla_num) {
		this.bla_num = bla_num;
	}
	public String getBla_id() {
		return bla_id;
	}
	public void setBla_id(String bla_id) {
		this.bla_id = bla_id;
	}
	public String getBla_title() {
		return bla_title;
	}
	public void setBla_title(String bla_title) {
		this.bla_title = bla_title;
	}
	public String getBla_content() {
		return bla_content;
	}
	public void setBla_content(String bla_content) {
		this.bla_content = bla_content;
	}
	public int getBla_hit() {
		return bla_hit;
	}
	public void setBla_hit(int bla_hit) {
		this.bla_hit = bla_hit;
	}
	public Date getBla_date() {
		return bla_date;
	}
	public void setBla_date(Date bla_date) {
		this.bla_date = bla_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
