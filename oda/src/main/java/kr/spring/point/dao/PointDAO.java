package kr.spring.point.dao;

import java.util.List;
import java.util.Map;


import kr.spring.point.domain.PointDTO;

public interface PointDAO {
	public List<PointDTO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(PointDTO point);
	public PointDTO selectPoint(Integer num);
	public PointDTO getTotalPoint(String id);
	public void update(PointDTO point);
	public void delete(Integer num);
}
