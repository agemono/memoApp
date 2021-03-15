package com.memo;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repositories.memoDataRepository;

@Controller
public class memoController {

	memoDataRepository repository;

	@RequestMapping(value = "/memo",method = RequestMethod.GET)
	public ModelAndView getMemo(@ModelAttribute("memodata")memoData memo,
								ModelAndView mav) {
		mav.addObject("memo");

		return mav;



	}
	@RequestMapping(value = "/memo",method = RequestMethod.POST)
	@Transactional(readOnly = true)
	public ModelAndView postMemo(@ModelAttribute("memodata")memoData memo,
								ModelAndView mav) {
		mav.addObject("memo");
		repository.saveAndFlush(memo);
		return mav;

	}
}
