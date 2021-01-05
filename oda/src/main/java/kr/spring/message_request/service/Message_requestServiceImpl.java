package kr.spring.message_request.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.domain.MemberDTO;
import kr.spring.message_request.dao.Message_requestDAO;
import kr.spring.message_request.domain.Message_requestDTO;
import kr.spring.request.dao.RequestDAO;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

@Service("message_requestService")
public class Message_requestServiceImpl implements Message_requestService{

	@Resource 
	private Message_requestDAO message_requestDAO;
	
	@Override
	public List<Message_requestDTO> selectListM(Map<String, Object> map) {
		return message_requestDAO.selectListM(map);
	}

	@Override
	public int selectRowCountM(Map<String, Object> map) {
		return message_requestDAO.selectRowCountM(map);
	}

	@Override
	public void insertM(Message_requestDTO message_request) {
		message_requestDAO.insertM(message_request);
		
	}

	@Override
	public Message_requestDTO selectBoardM(Integer num) {
		return message_requestDAO.selectBoardM(num);
	}

	@Override
	public Message_requestDTO getRequestM(Integer req_num) {
		return message_requestDAO.getRequestM(req_num);
	}

	@Override
	public void updateHitM(Integer num) {
		message_requestDAO.updateHitM(num);
		
	}

	@Override
	public void updateRequestM(Message_requestDTO message_request) {
		message_requestDAO.updateRequestM(message_request);	
	}

	@Override
	public void deleteRequestM(Integer num) {
		message_requestDAO.deleteRequestM(num);
		
	}

	@Override
	public int checkMessageCount(String mess_deli) {
		return message_requestDAO.checkMessageCount(mess_deli);
	}


}
