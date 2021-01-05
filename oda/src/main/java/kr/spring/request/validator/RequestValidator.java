package kr.spring.request.validator;

import org.junit.runner.Request;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import kr.spring.request.domain.RequestDTO;

public class RequestValidator implements Validator{

	//validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return RequestDTO.class.isAssignableFrom(clazz);
	}
	
	//유효성 체크
	@Override
	public void validate(Object target, Errors errors) {
		RequestDTO request = (RequestDTO)target;
		
		if(request.getReq_shop() == null || request.getReq_shop().trim().isEmpty()) {
			//전송된 가게이름이 없을 경우
							  //필드       에러코드
			errors.rejectValue("req_shop", "required");
		}
		if(request.getReq_pname() == null || request.getReq_pname().trim().isEmpty()) {
			//전송된 이름이 없을 경우
							  //필드       에러코드
			errors.rejectValue("req_pname", "required");
		}
		if(request.getReq_region() == null || request.getReq_region().trim().isEmpty()) {
			//전송된 지역명이 없을 경우
							  //필드       에러코드
			errors.rejectValue("req_region", "required");
		}
		if(request.getReq_content() == null || request.getReq_content().trim().isEmpty()) {
			//전송된 내용이 없을 경우
							  //필드       에러코드
			errors.rejectValue("req_content", "required");
		}
		
	}

}
