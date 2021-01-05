package kr.spring.notice.controller;

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

import kr.spring.notice.domain.NoticeDTO;
import kr.spring.notice.service.NoticeService;
import kr.spring.notice.validator.NoticeValidator;
import kr.spring.util.PagingUtil;

@Controller
public class NoticeController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private NoticeService noticeService;
	
	//자바빈 초기화
	@ModelAttribute
	public NoticeDTO initCommand() {
		return new NoticeDTO();
	}
	
	//게시판 글 목록
		@RequestMapping("/notice/list.do")
		public ModelAndView process(
				@RequestParam(value="pageNum",defaultValue="1") int currentPage,
				@RequestParam(value="keyfield",defaultValue="") String keyfield,
				@RequestParam(value="keyword",defaultValue="") String keyword) {
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("keyfield", keyfield);
			map.put("keyword", keyword);
			
			//글의 총 개수 또는 검색된 길의 개수
			int count = noticeService.selectRowCount(map);
			
			if(log.isDebugEnabled()) {
				log.debug("<<count>> : " + count);
			}
			
			//페이지 처리
			PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,
											 rowCount,pageCount,"list.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<NoticeDTO> list = null;
			if(count > 0) {
				list = noticeService.selectList(map);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("notice/noticeList");
			mav.addObject("list", list);
			mav.addObject("count", count);
			mav.addObject("pagingHtml", page.getPagingHtml());
			
			return mav;
		}
	
	//글쓰기 폼 호출
	@RequestMapping(value="/notice/write.do",method=RequestMethod.GET)
	public String formWrite() {
		return "notice/noticeWrite";
	}
	
	//글쓰기 처리
	@RequestMapping(value="/notice/write.do",method=RequestMethod.POST)
	public String submitWrite(@Valid NoticeDTO noticeDTO, BindingResult result,
							   HttpServletRequest request, HttpSession session) {
		//전송된 데이터에 대한 유효성 체크
			new NoticeValidator().validate(noticeDTO, result);
			if(result.hasErrors()) {
				return "notice/noticeWrite";
			}
				
		noticeDTO.setId((String)session.getAttribute("user_id"));
		
		//글쓰기
		noticeService.insert(noticeDTO);
		
		return "redirect:/notice/list.do";
	}
	
	//글 상세
	@RequestMapping("/notice/detail.do")
	public ModelAndView process(@RequestParam int num) {
		
		//조회수
		noticeService.updateHit(num);
		
		//글 상세 읽기
		NoticeDTO notice = noticeService.selectNotice(num);
		
		return new ModelAndView("notice/noticeView","noticeDTO",notice);
	}
	
	
	//공지사항 수정 폼
	@RequestMapping(value="/notice/update.do",method=RequestMethod.GET)
	public String formUpdate(@RequestParam int noti_num, Model model) {
		
		model.addAttribute("noticeDTO",noticeService.selectNotice(noti_num));
		
		return "notice/noticeUpdate";
	}
	
	//공지사항 수정 처리
	@RequestMapping(value="/notice/update.do",method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, BindingResult result) {
		
		//전송된 데이터에 대한 유효성 체크
		new NoticeValidator().validate(noticeDTO, result);
		if(result.hasErrors()) {
			return "notice/noticeUpdate";
		}
		
		//공지사항 수정 
		noticeService.update(noticeDTO);
		
		return "redirect:/notice/list.do";
	
	}
	
	//공지사항 삭제 폼
	@RequestMapping(value="/notice/delete.do",method=RequestMethod.GET)
	public String noticeDelete(@RequestParam int noti_num, Model model) {
			
		model.addAttribute("noti_num", noti_num);
		
		return "notice/noticeDelete";
	}
		
	//공지사항 삭제 처리
	@RequestMapping(value="/notice/deletePro.do",method=RequestMethod.POST)
	public String noticeDelete(@RequestParam int noti_num) {
		
		noticeService.delete(noti_num);
		
		return "redirect:/notice/list.do";
	}
	
}
