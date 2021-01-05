package kr.spring.blacklist.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.blacklist.domain.BlackDTO;

public class BlackValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BlackDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object taget, Errors errors) {
		BlackDTO black = (BlackDTO)taget;
		if(black.getBla_title() == null || black.getBla_title().trim().isEmpty()) {
			//전송된 제목이 없을떄
								//필드	, 에러코드
			errors.rejectValue("bla_title", "NotEmpty");
		}
		if(black.getBla_content() == null || black.getBla_content().trim().isEmpty()) {
			//전송된 내용이 없을떄
								//필드 , 에러코드
			errors.rejectValue("bla_content", "NotEmpty");
		}
		
	}

}


















