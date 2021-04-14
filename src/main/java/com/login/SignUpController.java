package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.User;
import com.user.UserService;
@Controller
public class SignUpController {

	@Autowired
	private UserService userService ;

	@RequestMapping(value = "/SignUp",method = RequestMethod.GET)
	public ModelAndView getSignUp(
									ModelAndView mav,
									@ModelAttribute("signupdata")User formdata) {
		mav.addObject("title", "登録画面");
		mav.setViewName("SignUp");
		/*mav.addObject("signupdata", new loginData());*/
		return mav;
	}

	@RequestMapping(value = "/SignUp",method = RequestMethod.POST)
	public ModelAndView postSignUp(
			@ModelAttribute("signupdata") User formdata,
			BindingResult bindingresult,
			ModelAndView mav) {
		
		mav.setViewName("SignUp");
		if(bindingresult.hasErrors()) {
			return mav;
		}
		
		User user = new User();
		
		user.setUserid(formdata.getUserid());
		user.setPassword(formdata.getPassword());
		
		System.out.println(formdata);
		
		boolean result = userService.insert(user);
		
		if(result==true) {
			System.out.println("登録完了");
		}
		else {
			System.out.println("登録できません");
			
		}

		
		return new ModelAndView("redirect:/login");
	}
}
