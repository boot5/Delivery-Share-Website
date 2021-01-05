package kr.spring.notice.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.notice.domain.NoticeDTO;

public class NoticeValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return NoticeDTO.class.isAssignableFrom(arg0);
	}

	//유효성 체크
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		NoticeDTO notice = (NoticeDTO)target;
		if(notice.getNoti_title() == null || notice.getNoti_title().trim().isEmpty()) {
			//전송된 제목이 없을경우
							  //필드                   에러코드
			errors.rejectValue("noti_title", "required");
		}
		if(notice.getNoti_content() == null || notice.getNoti_content().trim().isEmpty()) {
			//전송된 제목이 없을경우
							  //필드                   에러코드
			errors.rejectValue("noti_content", "required");
		}
	}

}
