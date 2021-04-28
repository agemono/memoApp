package com.login;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.User;

@Controller
public class LoginController<MyDataRepository> {

	/*	@Autowired
		loginDataRepository repository;*/

	/*@Autowired
	UserService userService;*/


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView mav,
			@ModelAttribute("formdata") User formdata) {
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginprocessing", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView postLogin(
			@ModelAttribute("formdata") User formdata,
			BindingResult bindingresult,
	
			ModelAndView mav) {
	
		if (bindingresult.hasErrors()) {
			return mav;
		}
		
		mav.setViewName("memo");

		return mav;
	}

}