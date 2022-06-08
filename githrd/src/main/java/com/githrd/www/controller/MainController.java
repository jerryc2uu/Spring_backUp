package com.githrd.www.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping({"/", "/main.blp"})
	public String getMain() {
		return "main";
	}
	
	@RequestMapping("/mainMsgCheck.blp")
	@ResponseBody
	public Map<String, String> msgCheck(HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		session.setAttribute("MSG_CHECK", "NO");
		map.put("result", "OK");
		return map;
	}
}
