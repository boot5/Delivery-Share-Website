package kr.spring.compliment.dao;

import java.util.List;
import java.util.Map;

import kr.spring.compliment.domain.ComplimentDTO;

public interface ComplimentDAO {
	public List<ComplimentDTO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(ComplimentDTO compliment);
	public ComplimentDTO selectCompliment(Integer com_num);
	public void updatecom_hit(Integer com_num);
	public ComplimentDTO getCom(Integer com_num);
	public void updatecom(ComplimentDTO compliment);
	public void deletecom(Integer com_num);
}