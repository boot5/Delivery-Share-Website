package kr.spring.request.domain;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class RequestDTO {
	private int req_num ;
	private String req_pname;
	private String req_region;
	private String req_shop;
	private int req_accept;
	private int req_point;
	private String req_content;
	private int req_hit;
	private Date req_date;
	private MultipartFile upload; // 폼에서 전송된 파일
	private byte[] req_uploadfile;//DB에 저장하기 위해 byte[]로 변환
	private String req_filename;//파일명
	private String id;
	private String ip;
	
	public void setUpload(MultipartFile upload) throws IOException{
		this.upload = upload;
		//MutipartFile -> byte[]
		setReq_uploadfile(upload.getBytes());
		//파일명
		setReq_filename(upload.getOriginalFilename());
	}
	
	public int getReq_num() {
		return req_num;
	}
	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	public String getReq_pname() {
		return req_pname;
	}
	public void setReq_pname(String req_pname) {
		this.req_pname = req_pname;
	}
	public String getReq_region() {
		return req_region;
	}
	public void setReq_region(String req_region) {
		this.req_region = req_region;
	}
	public String getReq_shop() {
		return req_shop;
	}
	public void setReq_shop(String req_shop) {
		this.req_shop = req_shop;
	}
	public int getReq_accept() {
		return req_accept;
	}
	public void setReq_accept(int req_accept) {
		this.req_accept = req_accept;
	}
	public int getReq_point() {
		return req_point;
	}
	public void setReq_point(int req_point) {
		this.req_point = req_point;
	}
	public String getReq_content() {
		return req_content;
	}
	public void setReq_content(String req_content) {
		this.req_content = req_content;
	}
	public int getReq_hit() {
		return req_hit;
	}
	public void setReq_hit(int req_hit) {
		this.req_hit = req_hit;
	}
	
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	
	
	public byte[] getReq_uploadfile() {
		return req_uploadfile;
	}

	public void setReq_uploadfile(byte[] req_uploadfile) {
		this.req_uploadfile = req_uploadfile;
	}

	public String getReq_filename() {
		return req_filename;
	}

	public void setReq_filename(String req_filename) {
		this.req_filename = req_filename;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "RequestDTO [req_num=" + req_num + ", req_pname=" + req_pname + ", req_region=" + req_region
				+ ", req_shop=" + req_shop + ", req_accept=" + req_accept + ", req_point=" + req_point
				+ ", req_content=" + req_content + ", req_hit=" + req_hit + ", req_date=" + req_date + ", upload="
				+ upload + ", req_uploadfile=" + Arrays.toString(req_uploadfile) + ", req_filename=" + req_filename
				+ ", id=" + id + ", ip=" + ip + "]";
	}
	
	
	
}
