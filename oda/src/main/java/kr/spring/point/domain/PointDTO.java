package kr.spring.point.domain;

import java.sql.Date;

public class PointDTO {
	private int poi_num;
	private int poi_kind;
	private int poi_plpoint;
	private int poi_mipoint;
	private int poi_sum;
	private Date poi_date;
	private String id;
	
	public int getPoi_sum() {
		return poi_sum;
	}
	public void setPoi_sum(int poi_sum) {
		this.poi_sum = poi_sum;
	}
	public int getPoi_num() {
		return poi_num;
	}
	public void setPoi_num(int poi_num) {
		this.poi_num = poi_num;
	}
	public int getPoi_kind() {
		return poi_kind;
	}
	public void setPoi_kind(int poi_kind) {
		this.poi_kind = poi_kind;
	}
	public int getPoi_plpoint() {
		return poi_plpoint;
	}
	public void setPoi_plpoint(int poi_plpoint) {
		this.poi_plpoint = poi_plpoint;
	}
	public int getPoi_mipoint() {
		return poi_mipoint;
	}
	public void setPoi_mipoint(int poi_mipoint) {
		this.poi_mipoint = poi_mipoint;
	}
	public Date getPoi_date() {
		return poi_date;
	}
	public void setPoi_date(Date poi_date) {
		this.poi_date = poi_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
