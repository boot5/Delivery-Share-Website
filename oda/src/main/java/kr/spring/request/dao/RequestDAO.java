package kr.spring.request.dao;

import java.util.List;
import java.util.Map;

import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;

public interface RequestDAO {
	public List<RequestDTO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insert(RequestDTO request);
	public RequestDTO selectBoard(Integer num);
	public RequestDTO getRequest(Integer req_num);
	public void updateHit(Integer num);
	public void updateRequest(RequestDTO request);
	public void deleteRequest(Integer num);
	
	//댓글
	public List<RequestReplyDTO> selectListReply(Map<String,Object> map);
	public int selectRowCountReply(Map<String,Object> map);
	public void insertReply(RequestReplyDTO requestReply);
	public void updateReply(RequestReplyDTO requestReply);
	public void deleteReply(Integer re_num);
	public void deleteReplyByNum(Integer req_num);
	
	//주문 승인
	public void updateAccept(Integer req_num);
	public void updateAcceptReply(Integer re_num);
	
	//포인트 처리를 위해서 ID구하기
	public RequestDTO getIdFromRequest(Integer req_num);
	public RequestReplyDTO getIdFromReply(Integer re_num);
}
