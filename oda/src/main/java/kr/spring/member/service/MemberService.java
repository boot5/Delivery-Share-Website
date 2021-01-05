package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberDTO;
import kr.spring.point.domain.PointDTO;


public interface MemberService {
	public void insert(MemberDTO member,PointDTO point);
	public MemberDTO selectMember(String id);
	public void update(MemberDTO member);
	public void delete(String id);
}

