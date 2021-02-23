package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repositories.loginDataRepository;


@Controller
public class LoginController<MyDataRepository> {

	@Autowired
	loginDataRepository repository;

	@RequestMapping(value = "login/login",method = RequestMethod.GET)
	public ModelAndView getSignUp(@ModelAttribute loginData logindata, ModelAndView mav) {
		mav.setViewName("login");
		mav.addObject("title", "Logindata");

		return mav;
	}

	@RequestMapping(value = "login/login",method = RequestMethod.POST)
	public ModelAndView postSignUp(ModelAndView mav) {

		return mav;
	}
}
