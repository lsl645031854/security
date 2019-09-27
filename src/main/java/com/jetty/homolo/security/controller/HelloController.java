package com.jetty.homolo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午5:40
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "Rose");
		return "hello";
	}
}
