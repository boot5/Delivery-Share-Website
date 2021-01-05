package kr.spring.main.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberDTO;
import kr.spring.member.service.MemberService;
import kr.spring.message_request.service.Message_requestService;

@Controller
public class MainAjaxController {
	private Logger log = Logger.getLogger(MainAjaxController.class);

	@Resource
	private Message_requestService message_requestService;

	@RequestMapping("/main/check_count.do")
	@ResponseBody
	public Map<String,String> process(HttpSession session){

		String user_id = (String)session.getAttribute("user_id");

		int count = message_requestService.checkMessageCount(user_id);

		if(log.isDebugEnabled()) {
			log.debug("<<check_count>> : " + count);
		}

		Map<String,String> map = 
				new HashMap<String,String>();

		map.put("check_count", String.valueOf(count));

		return map;
	}
}











