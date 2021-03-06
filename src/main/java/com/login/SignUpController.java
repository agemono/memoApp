package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repositories.loginDataRepository;
@Controller
public class SignUpController {

	@Autowired
	loginDataRepository repository ;

	@RequestMapping(value = "/SignUp",method = RequestMethod.GET)
	public ModelAndView getSignUp(@ModelAttribute ("formModel")
									loginData logindata,
									ModelAndView mav) {
		mav.setViewName("SignUp");
		mav.addObject("title", "登録画面");
		Iterable<loginData> data = repository.findAll();
		mav.addObject(data);
		return mav;
	}

	@RequestMapping(value = "/SignUp",method = RequestMethod.POST)
	public ModelAndView form(@ModelAttribute("logindata") loginData logindata,
								ModelAndView mav) {
		mav.setViewName("SignUp");
		repository.saveAndFlush(logindata);
		return new ModelAndView("redirect:/login");
	}
}
