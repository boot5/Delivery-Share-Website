package kr.spring.request.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

@Repository("requestDAO")
public class RequestDAOImpl implements RequestDAO{
	
	@Resource 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RequestDTO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("selectListRequest",map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountRequest",map);
	}

	@Override
	public void insert(RequestDTO request) {
		sqlSession.insert("insertRequest",request);
	}

	@Override
	public RequestDTO selectBoard(Integer num) {
		return sqlSession.selectOne("selectRequest",num);
	}

	@Override
	public void updateHit(Integer num) {
		sqlSession.update("updateHitRequest",num);
		
	}

	@Override
	public void updateRequest(RequestDTO request) {
		sqlSession.update("updateRequest",request);
		
	}

	@Override
	public void deleteRequest(Integer num) {
		sqlSession.delete("deleteRequest",num);
		
	}
	@Override
	public RequestDTO getRequest(Integer req_num) {
		return sqlSession.selectOne("getRequest",req_num);
	}

	@Override
	public List<RequestReplyDTO> selectListReply(Map<String, Object> map) {
		return sqlSession.selectList("selectListReply",map);
	}

	@Override
	public int selectRowCountReply(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountReply",map);
	}

	@Override
	public void insertReply(RequestReplyDTO requestReply) {
		sqlSession.insert("insertReply",requestReply);
	}

	@Override
	public void updateReply(RequestReplyDTO requestReply) {
		sqlSession.update("updateReply",requestReply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		sqlSession.delete("deleteReply",re_num);
	}

	@Override
	public void deleteReplyByNum(Integer req_num) {
		sqlSession.delete("deleteReplyByNum",req_num);
	}

	@Override
	public void updateAccept(Integer req_num) {
		sqlSession.update("updateAccept",req_num);
	}

	@Override
	public void updateAcceptReply(Integer re_num) {
		sqlSession.update("updateAcceptReply",re_num);
	}

	@Override
	public RequestDTO getIdFromRequest(Integer req_num) {
		return sqlSession.selectOne("getIdFromRequest",req_num);
	}

	@Override
	public RequestReplyDTO getIdFromReply(Integer re_num) {
		return sqlSession.selectOne("getIdFromReply",re_num);
	}

}
