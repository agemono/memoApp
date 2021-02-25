package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	public ModelAndView getSignUp(@ModelAttribute loginData logindata, ModelAndView mav) {
		mav.setViewName("SignUp");
		mav.addObject("title", "登録画面");

		return mav;
	}

	@RequestMapping(value = "/SignUp",method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(@ModelAttribute("formModel")
			loginData logindata,
			ModelAndView mav) {
		mav.setViewName("SignUp");

		return new ModelAndView("redirect:/login");
	}
}
