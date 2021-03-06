package com.login;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repositories.loginDataRepository;


@Controller
public class LoginController<MyDataRepository> {

	@Autowired
	loginDataRepository repository;


	@PostConstruct
	public void init() {
		//テストデータ
		loginData testuser = new loginData();
		testuser.setUserid("shota");
		testuser.setUserpassword("shota");
		repository.saveAndFlush(testuser);

	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView getSignUp(@ModelAttribute loginData logindata, ModelAndView mav) {
		mav.setViewName("login");
		mav.addObject("title", "logindata");

		return mav;
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@Transactional(readOnly = true)
	public ModelAndView postSignUp(
									@ModelAttribute("logindata") loginData logindata,
			/*@PathVariable String id,
			@PathVariable String password,*/
									ModelAndView mav) {
		mav.setViewName("login");

		loginData data = repository.findByUserid((String)logindata.getUserid());

		if(data.getUserpassword() == logindata.getUserpassword()) {
			mav.setViewName("memo");
		}
		return mav;
	}





}