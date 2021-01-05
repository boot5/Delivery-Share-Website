package kr.spring.message_request.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.message_request.domain.Message_requestDTO;
import kr.spring.message_request.service.Message_requestService;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.domain.RequestReplyDTO;
import kr.spring.request.service.RequestService;
import kr.spring.util.PagingUtil;

@Controller
public class Message_requestController {

	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;


	@Resource
	private Message_requestService message_requestService;
	@Resource
	private RequestService requestService;

	//자바빈 초기화
	@ModelAttribute
	public Message_requestDTO initCommand() {
		return new Message_requestDTO();
	}

	//게시판 글 목록
	@RequestMapping("/message_request/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword,
			HttpSession session) {
		
		String mess_deli = (String)session.getAttribute("user_id");

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		map.put("mess_deli", mess_deli);

		//글의 총 갯수 또는 검색된 글의 갯수
		int count = message_requestService.selectRowCountM(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,
				rowCount,pageCount,"list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<Message_requestDTO> list = null;
		if(count >0) {
			list = message_requestService.selectListM(map);
		}


		ModelAndView mav = new ModelAndView();
		mav.setViewName("message_request/boardList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//글쓰기 폼 호출
	@RequestMapping(value="/message_request/write.do",method=RequestMethod.GET)
	public String formWrite() {
		return "message_request/boardWrite";
	}
	//글쓰기 처리
	@RequestMapping(value="/message_request/write.do" ,method=RequestMethod.POST)
	public String submitWrite(@Valid Message_requestDTO message_requestDTO,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {
		//유효성 체크
		if(result.hasErrors()) {
			return "message_request/boardWrite";
		}

		//id셋팅
		message_requestDTO.setId((String)session.getAttribute("user_id"));


		//글쓰기
		message_requestService.insertM(message_requestDTO);

		return "redirect:/message_request/list.do";
	}

	//글 상세
	@RequestMapping("/message_request/detail.do")
	public ModelAndView process(@RequestParam int mess_num) {

		if(log.isDebugEnabled()) {
			log.debug("<<mess_num>> : " +mess_num);
		}

		Message_requestDTO message_request = message_requestService.selectBoardM(mess_num);
		
		RequestDTO request = requestService.selectBoard(message_request.getReq_num());
		
		RequestReplyDTO replyDTO = requestService.getIdFromReply(message_request.getRe_num());
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("message_request/boardView");
		mav.addObject("message_requestDTO",message_request);
		mav.addObject("requestDTO", request);
		mav.addObject("replyDTO", replyDTO);
		
		return mav;
	}

	//게시판 정보 수정 처리
	@RequestMapping(value="/message_request/update.do")
	public String submitUpdate(Message_requestDTO message_requestDTO,BindingResult result) {

		message_requestDTO.setMess_check(1);
		
		//게시판 정보 수정
		message_requestService.updateRequestM(message_requestDTO);
		return "redirect:/message_request/list.do";
	}

	//게시판 정보 삭제 폼
	@RequestMapping("/message_request/delete.do")
	public String formDelete(@RequestParam String mess_num, Model model) {

		model.addAttribute("mess_num", mess_num);

		return "message_request/deleteForm";			
	}

	//게시판 정보 삭제 처리
	@RequestMapping("/message_request/deletePro.do")
	public String processDelete(@RequestParam Integer mess_num) {

		//게시판 정보 삭제
		message_requestService.deleteRequestM(mess_num);
		return "redirect:/message_request/list.do";
	}	

}














