package kr.spring.member.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.member.domain.MemberDTO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insert(MemberDTO member) {
		sqlSession.insert("insertMember",member);
		
	}

	@Override
	public void insertDetail(MemberDTO member) {
		sqlSession.insert("insertDetailMember",member);
		
	}

	@Override
	public MemberDTO selectMember(String id) {
		return sqlSession.selectOne("selectMember",id);
	}

	@Override
	public void update(MemberDTO member) {
		sqlSession.update("updateMember",member);
	}

	@Override
	public void delete(String id) {
		sqlSession.update("deleteMember",id);
	}

	@Override
	public void deleteDetail(String id) {
		sqlSession.delete("deleteDetailMember",id);
		
	}
}
