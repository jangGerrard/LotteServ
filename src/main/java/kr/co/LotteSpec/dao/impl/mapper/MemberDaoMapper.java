package kr.co.LotteSpec.dao.impl.mapper;

import kr.co.LotteSpec.domain.Member;

public interface MemberDaoMapper {

	public Member selectMemberById(long id );
	
	public Member selectMemberByEmail(String email);
}
