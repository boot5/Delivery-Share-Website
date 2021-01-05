package kr.spring.message_request.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberDTO;
import kr.spring.message_request.domain.Message_requestDTO;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

public interface Message_requestService {
	public List<Message_requestDTO> selectListM(Map<String,Object> map);
	public int selectRowCountM(Map<String,Object> map);
	public void insertM(Message_requestDTO message_request);
	public Message_requestDTO selectBoardM(Integer num);
	public Message_requestDTO getRequestM(Integer req_num);
	public void updateHitM(Integer num);
	public void updateRequestM(Message_requestDTO message_request);
	public void deleteRequestM(Integer num);
	public int checkMessageCount(String mess_deli);
	
}
