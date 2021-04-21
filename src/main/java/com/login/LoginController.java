package com.login;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void init() {
		//テストデータ
		/*		User testuser = new User();
				testuser.setUserid("shota");
				testuser.setPassword("shota");
				repository.saveAndFlush(testuser);*/

	}

	
	/*@RequestMapping(value = "/login")
	public ModelAndView getLogin(ModelAndView mav,
			@ModelAttribute("formdata") User formdata) {
		mav.setViewName("login");
		return mav;
	}*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView mav,
			@ModelAttribute("formdata") User formdata) {
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView postLogin(
			@ModelAttribute("formdata") User formdata,
			BindingResult bindingresult,
	
			ModelAndView mav) {
	
		if (bindingresult.hasErrors()) {
			return mav;
		}
	
		User user = new User();
		
		
		user.getUserid();
		user.getPassword();
		
		System.out.println(formdata);
		System.out.println(user);
		
		/*mav.setViewName("memo");
				User data = repository.findByUserid((String) ld.getUserid());
		
				String pass1 = data.getPassword();
				String pass2 = ld.getPassword();
				if(pass1.equals(pass2)) {
		
					return new ModelAndView("redirect:/memo");
				}*/
		return mav;
	}
	
}