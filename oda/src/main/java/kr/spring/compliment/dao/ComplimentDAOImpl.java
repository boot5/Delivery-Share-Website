package kr.spring.compliment.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.compliment.domain.ComplimentDTO;
import kr.spring.member.domain.MemberDTO;

@Repository("compliment.DAO")
public class ComplimentDAOImpl implements ComplimentDAO{

	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ComplimentDTO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("selectList",map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCount",map);
	}

	@Override
	public void insert(ComplimentDTO compliment) {
		sqlSession.insert("insertCompliment",compliment);
	}

	@Override
	public ComplimentDTO selectCompliment(Integer com_num) {
		return sqlSession.selectOne("selectCompliment",com_num);
	}

	@Override
	public void updatecom_hit(Integer com_num) {
		sqlSession.update("updatecom_hit",com_num);
	}

	@Override
	public void updatecom(ComplimentDTO compliment) {
		sqlSession.update("updatecom",compliment);
		
	}

	@Override
	public void deletecom(Integer com_num) {
			sqlSession.delete("deletecom",com_num);
		
	}
	@Override
	public ComplimentDTO getCom(Integer com_num) {
		return sqlSession.selectOne("getCom",com_num);
	}

}
