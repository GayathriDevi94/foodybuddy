package com.foodybuddy.EcomFrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController

{
	@RequestMapping(value={"/","/index"})
	String sliderPage(Model model) {
		model.addAttribute("sliderPage", true);
		return "index";
	}

	@RequestMapping("/aboutus")
	String aboutPage(Model model) {
		model.addAttribute("aboutPage", true);
		return "index";

	}

	@RequestMapping("/contactus")
	String contactPage(Model model) {
		model.addAttribute("contactPage", true);
		return "index";

	}

	

}
