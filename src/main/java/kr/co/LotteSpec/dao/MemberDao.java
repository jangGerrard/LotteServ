package kr.co.LotteSpec.dao;

import kr.co.LotteSpec.domain.Member;

public interface MemberDao {
	public Member selectMemberById(long id);
	
	public Member selectMemberByEmail(String email);
	
	public boolean selectIsPwEquals(String email, String password);
}
