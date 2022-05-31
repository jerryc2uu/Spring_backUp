package com.githrd.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main.blp")
	public String getMain() {
		return "main";
	}
}
