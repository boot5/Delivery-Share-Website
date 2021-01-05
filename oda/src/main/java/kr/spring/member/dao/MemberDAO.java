package kr.spring.member.dao;

import kr.spring.member.domain.MemberDTO;

public interface MemberDAO {
	public void insert(MemberDTO member);
	public void insertDetail(MemberDTO member);
	public MemberDTO selectMember(String id);
	public void update(MemberDTO member);
	public void delete(String id);
	public void deleteDetail(String id);

}
