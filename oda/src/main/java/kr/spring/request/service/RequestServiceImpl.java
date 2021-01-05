package kr.spring.request.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.domain.MemberDTO;
import kr.spring.message_request.dao.Message_requestDAO;
import kr.spring.message_request.domain.Message_requestDTO;
import kr.spring.point.dao.PointDAO;
import kr.spring.point.domain.PointDTO;
import kr.spring.request.dao.RequestDAO;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

@Service("requestService")
public class RequestServiceImpl implements RequestService{

	@Resource 
	private RequestDAO requestDAO;
	@Resource
	private PointDAO pointDAO;
	@Resource
	private Message_requestDAO message_requestDAO;
	
	@Override
	public List<RequestDTO> selectList(Map<String, Object> map) {
		return requestDAO.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return requestDAO.selectRowCount(map);
	}

	@Override
	public void insert(RequestDTO request) {
		requestDAO.insert(request);
		
	}

	@Override
	public RequestDTO selectBoard(Integer num) {
		return requestDAO.selectBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		requestDAO.updateHit(num);
	}

	@Override
	public void updateRequest(RequestDTO request) {
		requestDAO.updateRequest(request);	
		
	}
	@Override
	public void deleteRequest(Integer num) {
		requestDAO.deleteReplyByNum(num);
		requestDAO.deleteRequest(num);
		
	}
	@Override
	public RequestDTO getRequest(Integer req_num) {
		return requestDAO.getRequest(req_num);
	}

	@Override
	public List<RequestReplyDTO> selectListReply(Map<String, Object> map) {
		return requestDAO.selectListReply(map);
	}

	@Override
	public int selectRowCountReply(Map<String, Object> map) {
		return requestDAO.selectRowCountReply(map);
	}

	@Override
	public void insertReply(RequestReplyDTO requestReply) {
		requestDAO.insertReply(requestReply);
	}

	@Override
	public void updateReply(RequestReplyDTO requestReply) {
		requestDAO.updateReply(requestReply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		requestDAO.deleteReply(re_num);
	}

	@Override
	public void updateAccept(Integer req_num, Integer re_num) {
		requestDAO.updateAccept(req_num);
		requestDAO.updateAcceptReply(re_num);
		RequestDTO requestDTO = requestDAO.getIdFromRequest(req_num);
		RequestReplyDTO request_reply = requestDAO.getIdFromReply(re_num);
		
		//포인트 차감
		PointDTO point = new PointDTO();
		point.setId(requestDTO.getId());
		point.setPoi_mipoint(requestDTO.getReq_point());
		point.setPoi_kind(4);
		pointDAO.insert(point);
		
		//포인트 적립
		PointDTO reply_point = new PointDTO();
		reply_point.setId(request_reply.getId());
		reply_point.setPoi_plpoint(requestDTO.getReq_point());
		reply_point.setPoi_kind(3);
		pointDAO.insert(reply_point);
		
		//메시지 발송
		Message_requestDTO message = new Message_requestDTO();
		message.setId(requestDTO.getId());//주문요청자
		message.setReq_num(req_num);//주문 번호
		message.setMess_deli(request_reply.getId());//배달자
		message.setRe_num(re_num);//배달 번호
		
		message_requestDAO.insertM(message);
	}

	@Override
	public RequestReplyDTO getIdFromReply(Integer re_num) {
		return requestDAO.getIdFromReply(re_num);
	}
}
