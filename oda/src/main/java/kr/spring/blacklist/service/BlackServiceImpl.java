package kr.spring.blacklist.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.blacklist.dao.BlackDAO;
import kr.spring.blacklist.domain.BlackDTO;

@Service("blackService")
public class BlackServiceImpl implements BlackService{

	@Resource
	private BlackDAO blackDAO;
	
	@Override
	public List<BlackDTO> selectList(Map<String, Object> map) {
		return blackDAO.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return blackDAO.selectRowCount(map);
	}

	@Override
	public void insert(BlackDTO black) {
		blackDAO.insert(black);
	}

	@Override
	public BlackDTO selectBlack(Integer num) {
		return blackDAO.selectBlack(num);
	}

	@Override
	public void updateHit(Integer num) {
		blackDAO.updateHit(num);
	}

	@Override
	public void updateBlack(BlackDTO black) {
		blackDAO.updateBlack(black);
		
	}

	@Override
	public void deleteBlack(Integer num) {
		blackDAO.deleteBlack(num);
		
	}

}
