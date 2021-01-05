package kr.spring.blacklist.service;

import java.util.List;
import java.util.Map;

import kr.spring.blacklist.domain.BlackDTO;

public interface BlackService {
	public List<BlackDTO> selectList(Map<String, Object> map);
	public int selectRowCount(Map<String, Object> map);
	public void insert(BlackDTO black);
	public BlackDTO selectBlack(Integer num);
	public void updateHit(Integer num);
	public void updateBlack(BlackDTO black);
	public void deleteBlack(Integer num);
}
