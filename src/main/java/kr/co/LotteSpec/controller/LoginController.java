package kr.co.LotteSpec.controller;

import javax.servlet.http.HttpSession;

import kr.co.LotteSpec.dao.MemberDao;
import kr.co.LotteSpec.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired 
	private MemberDao memberDao ;
		
	@RequestMapping(value="login"  ,method=RequestMethod.GET)
	public ModelAndView loginInit(){
		System.out.println("login init");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value ="login", method=RequestMethod.POST)
	public String loginCheck(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			){
		System.out.println("loginCheck");
		
		Member member = memberDao.selectMemberByEmail(email);
		if(memberDao.selectIsPwEquals(email, password)){
			session.setAttribute("loginEmail", member.getEmail());
			session.setAttribute("loginId", member.getId());
			session.setAttribute("loginAdmin", member.getAdmin());
			return "redirect:/main.lotte";
		} else {
			return "redirect:/login.lotte";
		}
	}
	
	@RequestMapping(value="login/forgotpw" , method=RequestMethod.POST)
	public String forgotPassword(
			@RequestParam(value = "forgotEmail" , required= false)  String email
			){
		System.out.println("forgot Password");
		if(email != null){
			Member m = memberDao.selectMemberByEmail(email);
			if(m != null){
				//비밀번호 생성 바꾸고 메일 보냄
				System.out.println("아이디 있어");
			}
		}
		
		return "redirect:/login.lotte";
	}
	
	@RequestMapping(value="login/join" , method=RequestMethod.POST)
	public String joinMember(
			@RequestParam("joinEmail") String email,
			@RequestParam("joinPassword") String password
			){
		System.out.println("join");
		
		
		System.out.println("email : " + email + "\n" + "pass : "+ password);
		return "redirect:/login.lotte";
	}
	
	
	@RequestMapping(value="login/logout", method=RequestMethod.GET)
	public String logoutMember(HttpSession session){
		System.out.println("logout");
		
		session.invalidate();
		return "redirect:/login.lotte";
	}

}
