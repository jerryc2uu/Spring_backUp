package com.githrd.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/singer")
public class Singer {

	@RequestMapping("/singer.blp")
	public ModelAndView singer(ModelAndView mv) {
		mv.setViewName("singer/singer");
		return mv;
	}
}
