package kr.spring.point.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.point.dao.PointDAO;
import kr.spring.point.domain.PointDTO;

@Repository("pointDAO")
public class PointDAOImpl implements PointDAO{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<PointDTO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("selectListPoint",map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountPoint",map);
	}

	@Override
	public void insert(PointDTO point) {
		sqlSession.insert("insertPoint",point);
		
	}

	@Override
	public PointDTO getTotalPoint(String id) {
		return sqlSession.selectOne("getTotalPoint",id);
	}
	
	@Override
	public PointDTO selectPoint(Integer num) {
		return sqlSession.selectOne("selectPoint",num);
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

