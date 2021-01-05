package kr.spring.point.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointDTO;
import kr.spring.point.service.PointService;
import kr.spring.util.PagingUtil;

@Controller
public class PointController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PointService pointService;
	
	private int rowCount = 10;
	private int pageCount = 10;

	@ModelAttribute
	public PointDTO initCommand() {
		return new PointDTO();
	}

	@RequestMapping("/point/list.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1") int currentPage,
			HttpSession session) {

		String user_id = (String)session.getAttribute("user_id");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", user_id);
		
		int count = pointService.selectRowCount(map);

		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"list.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<PointDTO> list = null;
		if(count > 0) {
			list = pointService.selectList(map);
		}

		//보유포인트 호출
		PointDTO pointDTO = pointService.getTotalPoint(user_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("point/pointList");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pointDTO", pointDTO);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

@RequestMapping(value="/point/write.do",method=RequestMethod.GET)
public String formWrite() {
	return "point/pointWrite";
}
@RequestMapping(value="/point/write.do",method=RequestMethod.POST)
public String submitWrite(@Valid PointDTO pointDTO, BindingResult result, HttpServletRequest request, HttpSession session) {

	if(log.isDebugEnabled()) {
		log.debug("<<PointDTO>> : " + pointDTO);
	}

	if(result.hasErrors()) {
		return "point/pointWrite";
	}
	pointDTO.setId((String)session.getAttribute("user_id"));

	pointService.insert(pointDTO);

	return "redirect:/point/list.do";
}
@RequestMapping("/point/detail.do")
public ModelAndView process(@RequestParam int num) {

	if(log.isDebugEnabled()) {
		log.debug("<<num>> : " + num);
	}

	PointDTO point = pointService.selectPoint(num);

	return new ModelAndView("point/pointView","pointDTO",point);
}
}


