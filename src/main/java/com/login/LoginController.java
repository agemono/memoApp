package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.UserDaojdbc;
import com.user.User;

@Controller
public class LoginController<MyDataRepository> {

	@Qualifier("UserDaojdbcImpl")
	@Autowired
	UserDaojdbc dao;

	/*@Autowired
	UserService userService;*/


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView mav
	,@ModelAttribute("formdata") User formdata) {
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginprocessing", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView postLogin(
			@ModelAttribute("formdata") User formdata,
			BindingResult bindingresult,
	
			ModelAndView mav) {
	
		mav.setViewName("login");
		
		if (bindingresult.hasErrors()) {
			return mav;
		}
		
		User user = dao.selectOne(formdata.getUser_id());
		
		if(user == null ) {
			return mav;
		}
		
		if(user.getPassword().equals(formdata.getPassword())) {
			mav.setViewName("memo");
		}
		mav.setViewName("memo");

		return mav;
	}

}