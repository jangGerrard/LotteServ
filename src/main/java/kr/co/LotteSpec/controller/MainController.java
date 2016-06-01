package kr.co.LotteSpec.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView main(
			HttpSession session
			){
		System.out.println("main controller main.get");
		
		ModelAndView mav = new ModelAndView();
		String email = session.getAttribute("loginEmail").toString();
		System.out.println(email + " logged on");
		
		
		mav.setViewName("/main");
		return mav;
	}
	
	
}
