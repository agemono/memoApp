package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.repositories.loginDataRepository;


@Controller
public class LoginController<MyDataRepository> {

	@Autowired
	loginDataRepository repository;


	@RequestMapping("/")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		mav.addObject("id");
		Iterable<loginData> list = repository.findAll();
		mav.addObject("logindata", list);
		return mav;
	}

}
