package kr.spring.compliment.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.compliment.dao.ComplimentDAO;
import kr.spring.compliment.domain.ComplimentDTO;
import kr.spring.member.domain.MemberDTO;

@Service("complimentService")
public class ComplimentServiceImpl implements ComplimentService{

	@Resource
	private ComplimentDAO complimentDAO;
	
	@Override
	public List<ComplimentDTO> selectList(Map<String, Object> map) {
		return complimentDAO.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return complimentDAO.selectRowCount(map);
	}

	@Override
	public void insert(ComplimentDTO compliment) {
		complimentDAO.insert(compliment);
	}

	@Override
	public ComplimentDTO selectCompliment(Integer com_num) {
		return complimentDAO.selectCompliment(com_num);
	}

	@Override
	public void updatecom_hit(Integer com_num) {
		complimentDAO.updatecom_hit(com_num);
	}

	@Override
	public void updatecom(ComplimentDTO compliment) {
		complimentDAO.updatecom(compliment);
		
	}

	@Override
	public void deletecom(Integer com_num) {
		complimentDAO.deletecom(com_num);
		
	}
	@Override
	public ComplimentDTO getCom(Integer com_num) {
		return complimentDAO.getCom(com_num);
	}

}
