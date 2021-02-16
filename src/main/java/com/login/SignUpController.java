package com.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SignUpController {

	@RequestMapping(value = "/getSignUp/{id]",method = RequestMethod.GET)
	public ModelAndView getSignUp(@ModelAttribute loginData logindata, ModelAndView mav,
									@PathVariable int id) {
		mav.setViewName("SignUp");
		return mav;
	}

	@RequestMapping(value = "/getSignUp/{id]",method = RequestMethod.POST)
	public ModelAndView postSignUp(ModelAndView mav) {

		return mav;
	}
}
