package kr.spring.point.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.point.dao.PointDAO;
import kr.spring.point.domain.PointDTO;
import kr.spring.point.service.PointService;

@Service("pointService")
public class PointServiceImpl implements PointService {
	@Resource
	private PointDAO pointDAO;
	
	@Override
	public List<PointDTO> selectList(Map<String, Object> map) {
		return pointDAO.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return pointDAO.selectRowCount(map);
	}

	@Override
	public void insert(PointDTO point) {
		pointDAO.insert(point);
	}
	
	@Override
	public PointDTO getTotalPoint(String id) {
		return pointDAO.getTotalPoint(id);
	}

	@Override
	public PointDTO selectPoint(Integer num) {
		return pointDAO.selectPoint(num);
	}

	@Override
	public void update(PointDTO point) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer num) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
