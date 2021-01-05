package kr.spring.compliment.controller;

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

import kr.spring.compliment.domain.ComplimentDTO;
import kr.spring.compliment.service.ComplimentService;
import kr.spring.util.PagingUtil;

@Controller
public class ComplimentController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private  ComplimentService  complimentService;
	
	//자바빈 초기화
	@ModelAttribute
	public  ComplimentDTO initCommand() {
		return new  ComplimentDTO();
	}
	
	//게시판 글 목록
	@RequestMapping("/compliment/list.do")
	public ModelAndView process(
			@RequestParam(value="pagecom_Num",defaultValue="1") int currentPage,
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//글의 총 갯수 또는 검색된 글의 갯수
		int count =  complimentService.selectRowCount(map);
		
		if(log.isDebugEnabled()) {
			//log.debug("<<count>> : " + count);
		}
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,
				              rowCount,pageCount,"list.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ComplimentDTO> list = null;
		if(count > 0) {
			list =  complimentService.selectList(map);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compliment/complimentList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	//글쓰기 폼 호출
	@RequestMapping(value="/compliment/write.do",method=RequestMethod.GET)
	public String formWrite() {
		return "compliment/complimentWrite";
	}
	
	//글쓰기 처리
	@RequestMapping(value="/compliment/write.do",method=RequestMethod.POST)
	public String submitWrite(@Valid  ComplimentDTO  complimentDTO,
			                  BindingResult result,
			                  HttpServletRequest request,
			                  HttpSession session) {
		
		//유효성 체크
		if(result.hasErrors()) {
			return "compliment/complimentWrite";
		}
		
		//id셋팅
		 complimentDTO.setId((String)session.getAttribute("user_id"));
		
	
		
		//글쓰기
		 complimentService.insert(complimentDTO);
		
		return "redirect:/compliment/list.do";
	}
	
	//글 상세
	@RequestMapping("/compliment/detail.do")
	public ModelAndView process(@RequestParam int com_num) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<com_num>> : " + com_num);
		}
		
		//해당 글의 조회수 증가
		 complimentService.updatecom_hit(com_num);
		
		//글 상세 읽기
		 ComplimentDTO compliment =  complimentService.selectCompliment(com_num);
		                        //view              속성명          속성값
		return new ModelAndView("compliment/complimentView","complimentDTO",compliment);
	}
	
	//회원 정보 수정 폼
		@RequestMapping(value="/compliment/update.do",method=RequestMethod.GET)
		public String formUpdate(@RequestParam Integer com_num, Model model) {
			
			//파라미터로 전달받은 id를 통해서 한 건의 레코드를 구함.
			//view에서 호출할 수 있도록 request에 저장
			model.addAttribute("complimentDTO", complimentService.getCom(com_num));
			return "compliment/updateForm";
		}
	
		
		//회원 정보 수정 처리
		@RequestMapping(value="compliment/update.do",method=RequestMethod.POST)
		public String submitUpdate(ComplimentDTO complimentDTO, BindingResult result) {
			
		
			//회원 정보 수정
			complimentService.updatecom(complimentDTO);
			
			return "redirect:/compliment/list.do";
		}
		//회원정보 삭제 폼
		@RequestMapping("/compliment/delete.do")
		public String formDelete(@RequestParam Integer com_num,Model model) {
			
			model.addAttribute("com_num", com_num);
			
			return "compliment/deleteForm";
		}
		//회원 정보 삭제 처리
		@RequestMapping("/compliment/deletePro.do")
		public String processDelete(@RequestParam Integer com_num) {
			
			//회원 정보 삭제
			complimentService.deletecom(com_num);
			return "redirect:/compliment/list.do";
		}
		
	}
	
	
	



















