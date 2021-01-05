package kr.spring.message_request.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.message_request.domain.Message_requestDTO;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

@Repository("message_requestDAO")
public class Message_requestDAOImpl implements Message_requestDAO{
	
	@Resource 
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Message_requestDTO> selectListM(Map<String, Object> map) {
		return sqlSession.selectList("selectListRequestM",map);
	}

	@Override
	public int selectRowCountM(Map<String, Object> map) {
		return sqlSession.selectOne("selectRowCountRequestM",map);
	}

	@Override
	public void insertM(Message_requestDTO message_request) {
		sqlSession.insert("insertRequestM",message_request);
		
	}

	@Override
	public Message_requestDTO selectBoardM(Integer num) {
		return sqlSession.selectOne("selectRequestM",num);
	}

	@Override
	public Message_requestDTO getRequestM(Integer mess_num) {
		return sqlSession.selectOne("getRequestM",mess_num);
	}

	@Override
	public void updateHitM(Integer num) {
		sqlSession.update("updateHitRequestM",num);
		
	}

	@Override
	public void updateRequestM(Message_requestDTO message_request) {
		sqlSession.update("updateRequestM",message_request);
		
	}

	@Override
	public void deleteRequestM(Integer num) {
		sqlSession.delete("deleteRequestM",num);
		
	}

	@Override
	public int checkMessageCount(String mess_deli) {
		return sqlSession.selectOne("checkMessageCount",mess_deli);
	}
	
	

}
