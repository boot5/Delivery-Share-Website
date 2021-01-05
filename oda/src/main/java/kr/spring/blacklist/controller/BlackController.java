package kr.spring.blacklist.controller;

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

import kr.spring.blacklist.domain.BlackDTO;
import kr.spring.blacklist.service.BlackService;
import kr.spring.blacklist.validator.BlackValidator;
import kr.spring.util.PagingUtil;

@Controller
public class BlackController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private BlackService blackService;
	
	//자바빈 초기화
	@ModelAttribute
	public BlackDTO initCommand() {
		return new BlackDTO();
	}

	//블랙리스트 글 목록
	@RequestMapping("/black/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword ) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<keyfield>> : " + keyfield);
			log.debug("<<keyword>> : " + keyword);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//글의 총갯수 또는 검색한 글의 갯수
		int count = blackService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, 
										rowCount, pageCount, "list.do" );
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BlackDTO> list = null;
		if(count > 0) {
			list = blackService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("black/blackList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//글쓰기 폼 호출
	@RequestMapping(value="/black/write.do",method=RequestMethod.GET)
	public String formWrite() {
		return "black/blackWrite";
	}
	
	//글쓰기 처리
	@RequestMapping(value="/black/write.do",method=RequestMethod.POST)
	public String submitWrite(@Valid BlackDTO blackDTO,
								BindingResult result,
								HttpServletRequest request,
								HttpSession session) {
		
		//전송된 데이터에 대한 유효성 체크
		new BlackValidator().validate(blackDTO, result);
		
		//유효성체크
		if (result.hasErrors()) {
			//에러가 있을 경우
			return "black/blackWrite";
		}
		
		//id셋팅
		blackDTO.setId((String)session.getAttribute("user_id"));
		
		//글쓰기
		blackService.insert(blackDTO);
		
		return "redirect:/black/list.do";
		
	}
	
	//신고글 상세
	@RequestMapping("/black/detail.do")
	public ModelAndView process(@RequestParam int num) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : ", null);
		}
		
		//해당 글의 조회수 증가
		blackService.updateHit(num);
		
		//신고글 상세 읽기
		BlackDTO black = blackService.selectBlack(num);
									// view		,	속성명	,속성값
		return new ModelAndView("black/blackView","blackDTO",black);
	}
	
	//신고글 수정 폼
		@RequestMapping(value="/black/update.do",method=RequestMethod.GET)
		public String formUpdate(@RequestParam Integer num, Model model) {
			
			model.addAttribute("blackDTO", blackService.selectBlack(num));
			
			return "black/blackUpdate";
		}
	
	//신고글 수정 처리
	@RequestMapping(value="/black/update.do",method=RequestMethod.POST)
	public String submitUpdate(BlackDTO blackDTO, BindingResult result) {
		
		//전송된 데이터에 대한 유효성 체크
		new BlackValidator().validate(blackDTO, result);
				
		if(result.hasErrors()) {
		return"black/blackUpdate";
		}
				
		//회원 정보 수정
		blackService.updateBlack(blackDTO);
		return "redirect:/black/list.do";
	}
	
	//신고글 삭제 폼
		@RequestMapping("/black/delete.do")
		public String formDelete(@RequestParam Integer num, Model model) {
			
			model.addAttribute("bla_num",num);
			
			return "black/blackDelete";
		}
		
	//신고글 삭제 처리
		@RequestMapping("/black/deletePro.do")
		public String processDelete(@RequestParam Integer num) {
			
			//블랙리스트 삭제
			blackService.deleteBlack(num);
			
			return "redirect:/black/list.do";
		}
	
}
