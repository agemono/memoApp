package com.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memoController {

	@RequestMapping
	public String index() {
		return "login";
	}
}
