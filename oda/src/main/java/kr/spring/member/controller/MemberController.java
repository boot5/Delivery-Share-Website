package kr.spring.member.controller;

import javax.annotation.Resource;
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
import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointDTO;
import kr.spring.point.service.PointService;
import kr.spring.util.AuthCheckException;

@Controller
public class MemberController {

	//로그처리
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;
	@Resource
	private PointService pointService;

	//자바빈(DTO) 초기화
	@ModelAttribute
	public MemberDTO initCommand() {
		return new MemberDTO();
	}

	//회원 가입 폼 호출
	@RequestMapping(value="/member/write.do",method=RequestMethod.GET)
	public String formRegister() {
		return "member/memberWrite";
	}
	//회원 가입 처리
	@RequestMapping(value="/member/write.do",method=RequestMethod.POST)
	public String submitRegister(@Valid  MemberDTO memberDTO, BindingResult result) {

		//로그 처리
		if(log.isDebugEnabled()) {
			log.debug("<<MemberDTO>> : " + memberDTO);
		}
		//유효성 체크 결과 에러가 있으면 폼 호출
		if(result.hasErrors()) {
			return formRegister();
		}

		//포인트 처리
		PointDTO pointDTO = new PointDTO();
		//10,000point 축하금 지급
		pointDTO.setId(memberDTO.getId());
		pointDTO.setPoi_kind(3);
		pointDTO.setPoi_plpoint(10000);
		//회원가입
		memberService.insert(memberDTO,pointDTO);

		return "redirect:/main/main.do";
	}
	//회원 상세 정보
	@RequestMapping("/member/detail.do")
	public ModelAndView processDetail(HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		MemberDTO member = memberService.selectMember(user_id);
		PointDTO pointDTO = pointService.getTotalPoint(user_id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberDetail");
		mav.addObject("memberDTO",member);
		mav.addObject("pointDTO", pointDTO);

		return mav;
	} 


	//회원 정보 수정 폼
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String formUpdate(Model model,HttpSession session) {
		model.addAttribute("memberDTO", memberService.selectMember((String)session.getAttribute("user_id")));
		return "member/memberUpdate";
	} 
	//회원정보수정처리
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submitUpdate(MemberDTO memberDTO, BindingResult result) {


		//회원정보 수정
		memberService.update(memberDTO);

		return "redirect:/main/main.do";
	}

	//회원 정보 삭제 폼
	@RequestMapping(value="/member/delete.do",method=RequestMethod.GET)
	public String formDelete() {
		return "member/memberDelete";
	}

	//회원 정보 삭제 처리
	@RequestMapping(value="/member/delete.do",method=RequestMethod.POST)
	public String processDelete(@Valid MemberDTO memberDTO, 
			BindingResult result, HttpSession session) {

		//유효성 체크 결과 에러가 있으면 폼 호출(id, passwd만 체크)
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return "member/memberDelete";
		}

		//회원 탈퇴 체크(id,비밀번호 일치 여부 체크)
		try {

			if(!memberDTO.getId().equals((String)session.getAttribute("user_id"))) {
				throw new AuthCheckException();
			}

			MemberDTO member = memberService.selectMember(memberDTO.getId());

			boolean check = false;
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isChekedPasswd(memberDTO.getPasswd());
			}

			if(check) {
				if(log.isDebugEnabled()) {
					log.debug("<<인증 성공>> : " + member.getId());
				}

				//회원 정보 삭제
				memberService.delete((String)session.getAttribute("user_id"));

				//로그아웃
				session.invalidate();

				return "redirect:/main/main.do";

			}else {
				//인증 실패
				throw new AuthCheckException();
			}

		}catch(AuthCheckException e) {
			//인증 실패로 로그인 폼 호출
			result.reject("invalidIdOrPassword");
			if(log.isDebugEnabled()) {
				log.debug("<<인증 실패>>");

			}
			return "member/memberDelete";
		}
	}



	//Login Form 호출
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String formLogin() {
		return "member/memberLogin";
	}



	//로그인 처리
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String submitLogin(@Valid MemberDTO memberDTO, 
			BindingResult result, HttpSession session) {

		//유효성 체크 결과 에러가 있으면 폼 호출(id, passwd만 체크)
		if(result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}
		//로그인 체크(id,비밀번호 일치 여부 체크)
		try {
			MemberDTO member = memberService.selectMember(memberDTO.getId());

			boolean check = false;
			if(member!=null) {
				//비밀번호 일치 여부 체크
				check = member.isChekedPasswd(memberDTO.getPasswd());
			}

			if(check) {
				//인증 성공, 로그인 처리
				session.setAttribute("user_id", member.getId());
				session.setAttribute("user_auth", member.getAuth());

				if(log.isDebugEnabled()) {
					log.debug("<<인증 성공>> : " + member.getId());
				}

				return "redirect:/main/main.do";

			}else {
				//인증 실패
				throw new AuthCheckException();
			}

		}catch(AuthCheckException e) {
			//인증 실패로 로그인 폼 호출
			result.reject("invalidIdOrPassword");
			if(log.isDebugEnabled()) {
				log.debug("<<인증 실패>>");
			}
			return formLogin();
		}
	}

	//로그아웃
	@RequestMapping("/member/logout.do")
	public String logout(HttpSession session) {
		//로그아웃
		session.invalidate();

		return "redirect:/main/main.do";
	}

}












