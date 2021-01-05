package kr.spring.request.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.request.domain.RequestReplyDTO;
import kr.spring.request.service.RequestService;
import kr.spring.util.PagingUtil;

@Controller
public class RequestReplyAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private RequestService requestService;
	
	@RequestMapping("/request/writeReply.do")
	@ResponseBody
	public Map<String,String> writeReply(
			RequestReplyDTO requestReplyDTO,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<requestReplyDTO>> : " + 
					requestReplyDTO);
		}
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		String user_id = 
			(String)session.getAttribute("user_id");
		if(user_id==null) {
			map.put("result", "logout");
		}else {
			requestReplyDTO.setRe_ip(
					request.getRemoteAddr());
			requestService.insertReply(requestReplyDTO);
			map.put("result", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/request/listReply.do")
	@ResponseBody
	public Map<String,Object> getList(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam("req_num") int req_num){
		
		if(log.isDebugEnabled()) {
			log.debug("<<currentPage>> : " + currentPage);
			log.debug("<<req_num>> : " + req_num);
		}
		
		Map<String,Object> map = 
				new HashMap<String,Object>();
		map.put("req_num", req_num);
		
		int count = requestService.selectRowCountReply(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,
				    rowCount,pageCount,null);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<RequestReplyDTO> list = null;
		if(count > 0) {
			list = requestService.selectListReply(map);
		}else {
			list = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = 
				new HashMap<String,Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("list", list);
		
		return mapJson;
	}

	@RequestMapping("/request/deleteReply.do")
	@ResponseBody
	public Map<String,String> deleteReply(
			@RequestParam("re_num") int re_num,
			@RequestParam("id") String id,
			HttpSession session){
		
		if(log.isDebugEnabled()) {
			log.debug("<<re_num>> : " + re_num);
			log.debug("<<id>> : " + id);
		}
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		String user_id = 
			(String)session.getAttribute("user_id");
		if(user_id==null) {
			map.put("result", "logout");
		}else if(user_id!=null && user_id.equals(id)) {
			requestService.deleteReply(re_num);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}		
		return map;
	}
	
	@RequestMapping("/request/updateReply.do")
	@ResponseBody
	public Map<String,String> modifyReply(
			RequestReplyDTO requestReplyDTO,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<requestReplyDTO>> : " + 
					requestReplyDTO);
		}
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		String user_id = 
			(String)session.getAttribute("user_id");
		if(user_id==null) {
			map.put("result", "logout");
		}else if(user_id!=null && user_id.equals(
				requestReplyDTO.getId())){
			
			requestReplyDTO.setRe_ip(
					request.getRemoteAddr());
			
			requestService.updateReply(requestReplyDTO);
			map.put("result", "success");
		}else {
			map.put("result", "wrongAccess");
		}
		
		return map;
	}
	
	//주문 승인
	@RequestMapping("/request/accept_request.do")
	@ResponseBody
	public Map<String,String> accept_request(
			@RequestParam int req_num,
			@RequestParam int re_num,
			HttpSession session,
			HttpServletRequest request){
		
		if(log.isDebugEnabled()) {
			log.debug("<<req_num>> : " + req_num);
			log.debug("<<re_num>> : " + re_num);
		}
		
		Map<String,String> map = 
				new HashMap<String,String>();
		
		String user_id = 
			(String)session.getAttribute("user_id");
		if(user_id==null) {
			map.put("result", "logout");
		}else {
			requestService.updateAccept(req_num,re_num);
			map.put("result", "success");
		}
		
		return map;
	}
}












