package kr.co.LotteSpec;

import kr.co.LotteSpec.dao.MemberDao;
import kr.co.LotteSpec.domain.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemeberDaoTest {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		MemberDao dao = ctx.getBean(MemberDao.class);
		
//		Member m = dao.selectMemberById(1);
//		
//		System.out.println(m.getId() + " " + m.getEmail());
//		System.out.println("finished");
		
		Member m = dao.selectMemberByEmail("jgjang0202@naver.com");
		System.out.println(m.getId() + " " + m.getEmail() + m.getPassword());
		System.out.println(dao.selectIsPwEquals("jgjang0202@naver.com", "123456"));
	}
}
