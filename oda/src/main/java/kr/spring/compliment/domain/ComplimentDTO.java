package kr.spring.compliment.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ComplimentDTO {
	private int com_num;
	private String com_title;
	private String com_content;
	private int com_hit;
	private Date com_date;
	private String id;
	private String com_deli;


	
	public int getCom_num() {
		return com_num;
	}


	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}


	public String getCom_title() {
		return com_title;
	}


	public void setCom_title(String com_title) {
		this.com_title = com_title;
	}


	public String getCom_content() {
		return com_content;
	}


	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}


	public int getCom_hit() {
		return com_hit;
	}


	public void setCom_hit(int com_hit) {
		this.com_hit = com_hit;
	}


	public Date getCom_date() {
		return com_date;
	}


	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}


	public String getCom_deli() {
		return com_deli;
	}


	public void setCom_deli(String com_deli) {
		this.com_deli = com_deli;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	}
	
