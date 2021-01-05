package kr.spring.request.controller;

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

import kr.spring.member.domain.MemberDTO;
import kr.spring.request.domain.RequestDTO;
import kr.spring.request.service.RequestService;
import kr.spring.request.validator.RequestValidator;
import kr.spring.util.PagingUtil;

@Controller
public class RequestController {

	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;


	@Resource
	private RequestService requestService;


	//자바빈 초기화
	@ModelAttribute
	public RequestDTO initCommand() {
		return new RequestDTO();
	}

	//게시판 글 목록
	@RequestMapping("/request/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword) {

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//글의 총 갯수 또는 검색된 글의 갯수
		int count = requestService.selectRowCount(map);

		if(log.isDebugEnabled()) {
			log.debug("<<count>> : " + count);
		}

		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,
				rowCount,pageCount,"list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<RequestDTO> list = null;
		if(count >0) {
			list = requestService.selectList(map);
		}


		ModelAndView mav = new ModelAndView();
		mav.setViewName("request/boardList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

	//글쓰기 폼 호출
	@RequestMapping(value="/request/write.do",method=RequestMethod.GET)
	public String formWrite() {
		return "request/boardWrite";
	}
	//글쓰기 처리
	@RequestMapping(value="/request/write.do" ,method=RequestMethod.POST)
	public String submitWrite(@Valid RequestDTO requestDTO,
			BindingResult result,
			HttpServletRequest request,
			HttpSession session) {
		//유효성 체크
		if(result.hasErrors()) {
			return "request/boardWrite";
		}

		//id셋팅
		requestDTO.setId((String)session.getAttribute("user_id"));


		//글쓰기
		requestService.insert(requestDTO);

		return "redirect:/request/list.do";
	}

	//글 상세
	@RequestMapping("/request/detail.do")
	public ModelAndView process(@RequestParam int req_num) {

		if(log.isDebugEnabled()) {
			log.debug("<<req_num>> : " +req_num);
		}

		//해당 글의 조회수 증가
		requestService.updateHit(req_num);

		//글 상세 읽기
		RequestDTO request = requestService.selectBoard(req_num);
		//view             속성명         속성값
		return new ModelAndView("request/boardView","requestDTO",request);
	}

	//파일 다운로드
	@RequestMapping("/request/file.do")
	public ModelAndView download(@RequestParam int req_num) {
		if(log.isDebugEnabled()) {
			log.debug("<<req_num>> : " + req_num);
		}

		RequestDTO request = requestService.selectBoard(req_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile", request.getReq_uploadfile());
		mav.addObject("filename", request.getReq_filename());

		return mav;

	}

	//이미지 표시
	@RequestMapping("/request/imageView.do")
	public ModelAndView viewImage(@RequestParam int req_num) {

		if(log.isDebugEnabled()) {
			log.debug("<<req_num>> : " + req_num);
		}

		RequestDTO request = requestService.selectBoard(req_num);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("imageView");
		mav.addObject("imageFile", request.getReq_uploadfile());
		mav.addObject("filename", request.getReq_filename());

		return mav;

	}
	//게시판 정보 수정 폼
	@RequestMapping(value="/request/update.do",method=RequestMethod.GET)
	public String formUdate(@RequestParam Integer req_num, Model model) {

		//파라미터로 전달받은 id를 통해서 한 건의 레코드를 구함.
		//view에서 호출할 수 있도록 request에 저장
		model.addAttribute("requestDTO", requestService.getRequest(req_num));		

		return "request/updateForm"; //jsp 경로
	}
	//게시판 정보 수정 처리
	@RequestMapping(value="/request/update.do",method=RequestMethod.POST)
	public String submitUpdate(RequestDTO requestDTO,BindingResult result) {

		//전송된 데이터에 대한 유효성 체크
		new RequestValidator().validate(requestDTO, result);
		if(result.hasErrors()) {
			return "request/updateForm";
		}

		//게시판 정보 수정
		requestService.updateRequest(requestDTO);
		return "redirect:/request/list.do";
	}

	//게시판 정보 삭제 폼
	@RequestMapping("/request/delete.do")
	public String formDelete(@RequestParam String req_num, Model model) {

		model.addAttribute("req_num", req_num);

		return "request/deleteForm";			
	}

	//게시판 정보 삭제 처리
	@RequestMapping("/request/deletePro.do")
	public String processDelete(@RequestParam Integer req_num) {

		//게시판 정보 삭제
		requestService.deleteRequest(req_num);
		return "redirect:/request/list.do";
	}	

}














