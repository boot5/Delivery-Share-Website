package kr.spring.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberDAO;
import kr.spring.member.domain.MemberDTO;
import kr.spring.point.dao.PointDAO;
import kr.spring.point.domain.PointDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource 
	private MemberDAO memberDAO;
	@Resource
	private PointDAO pointDAO;
	
	@Override
	public void insert(MemberDTO member,PointDTO point) {
		memberDAO.insert(member);
		memberDAO.insertDetail(member);
		//포인트 처리
		pointDAO.insert(point);
	}

	@Override
	public MemberDTO selectMember(String id) {
		return memberDAO.selectMember(id);
	}

	@Override
	public void update(MemberDTO member) {
		memberDAO.update(member);
	}

	@Override
	public void delete(String id) {
		
		memberDAO.delete(id);
		memberDAO.deleteDetail(id);
	}
}
