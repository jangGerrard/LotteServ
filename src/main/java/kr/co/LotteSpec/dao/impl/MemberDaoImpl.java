package kr.co.LotteSpec.dao.impl;

import kr.co.LotteSpec.dao.MemberDao;
import kr.co.LotteSpec.dao.impl.mapper.MemberDaoMapper;
import kr.co.LotteSpec.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private MemberDaoMapper memberDaoMapper;
	
	
	@Override
	public Member selectMemberById(long id) {
		return this.memberDaoMapper.selectMemberById(id);
	}
	
	public Member selectMemberByEmail(String email){
		return this.memberDaoMapper.selectMemberByEmail(email);
	}
	
	public boolean selectIsPwEquals(String email, String password){
		Member m =  this.memberDaoMapper.selectMemberByEmail(email);
		if(m != null){
			if(m.getPassword().equals(password)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	

}
