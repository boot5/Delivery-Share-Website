package kr.spring.compliment.service;

import java.util.List;
import java.util.Map;

import kr.spring.compliment.domain.ComplimentDTO;
import kr.spring.member.domain.MemberDTO;

public interface ComplimentService {
	public List<ComplimentDTO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(ComplimentDTO compliment);
	public ComplimentDTO selectCompliment(Integer num);
	public void updatecom_hit(Integer num);
	public ComplimentDTO getCom(Integer com_num);
	public void updatecom(ComplimentDTO compliment);
	public void deletecom(Integer com_num);
}
