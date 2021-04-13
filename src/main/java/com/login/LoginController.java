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
		User testuser = new User();
		testuser.setUserid("shota");
		testuser.setPassword("shota");
		repository.saveAndFlush(testuser);

	}

		@RequestMapping(value = "/login",method = RequestMethod.GET)
		public ModelAndView getLogin( ModelAndView mav,
										@ModelAttribute("logindata")User logindata) {
			mav.setViewName("login");
			return mav;
		}

	@RequestMapping(value = "login",method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView Login(
			/*@RequestParam("logindata") loginData ld,*/
			@ModelAttribute("logindata") User ld,
			/*			@ModelAttribute("userid") String userid,
						@ModelAttribute("pasword") String password,*/
									ModelAndView mav) {
		mav.setViewName("login");

		User data = repository.findByUserid((String) ld.getUserid());

		String pass1 = data.getPassword();
		String pass2 = ld.getPassword();
		if(pass1.equals(pass2)) {

			return new ModelAndView("redirect:/memo");
		}
		return mav;
	}





}