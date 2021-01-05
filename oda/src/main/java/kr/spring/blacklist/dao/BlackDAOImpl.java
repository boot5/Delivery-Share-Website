package kr.spring.blacklist.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.blacklist.domain.BlackDTO;

@Repository("BlackDAO")
public class BlackDAOImpl implements BlackDAO{
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BlackDTO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("selectListBlack",map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountBlack",map);
	}

	@Override
	public void insert(BlackDTO black) {
		sqlSession.insert("insertBlack",black);
	}

	@Override
	public BlackDTO selectBlack(Integer num) {
		return sqlSession.selectOne("selectBlack", num);
	}

	@Override
	public void updateHit(Integer num) {
		sqlSession.update("updateHitBlack",num);
		
	}

	@Override
	public void updateBlack(BlackDTO black) {
		sqlSession.update("updateBlack",black);
		
	}

	@Override
	public void deleteBlack(Integer num) {
		sqlSession.delete("deleteBlack", num);
		
	}

}
