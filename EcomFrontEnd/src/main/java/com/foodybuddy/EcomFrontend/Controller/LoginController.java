package com.foodybuddy.EcomFrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {
	@RequestMapping("/login")
	String loginPage(Model model) {
		model.addAttribute("loginPage", true);
		return "index";

	}
	@RequestMapping("/flogin")
	String floginPage(Model model) {
		model.addAttribute("error", true);
		model.addAttribute("loginPage", true);
		return "index";

	}
	@RequestMapping("/loginsuccess")
	String loginsuccess(Model model) {
		model.addAttribute("sliderPage", true);
		return "index";

	}

}
