package com.foodybuddy.EcomFrontend.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodybuddy.EcomBackend.dao.CustomerDao;
import com.foodybuddy.EcomBackend.model.Customer;


@Controller

public class CustomerRegisterController {
	@Autowired
	CustomerDao custdao;

	@RequestMapping("/register")
	String registerPage(Model model) {
		model.addAttribute("regobject", new Customer());
		model.addAttribute("registerPage", true);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("success", false);
		return "index";
	}

	@RequestMapping("/addcustomer")
	String addCustomer(@Valid @ModelAttribute("regobject") Customer u, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("regobject", u);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inappropriate Data");
			} else {
				BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
				u.setCustpass(passwordEncoder.encode(u.getCustpass()));
				if (custdao.insertCustomer(u)) {
					model.addAttribute("regobject", new Customer());
					model.addAttribute("success", true);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("message", "please try after some time");
					model.addAttribute("regobject", u);
				}
			}

		} catch (Exception e) {
			model.addAttribute("regobject", u);
			model.addAttribute("error", true);
			model.addAttribute("message", "Duplicate Data");
		}

		model.addAttribute("registerPage", true);
		model.addAttribute("customerlist", custdao.selectAllCustomers());
		model.addAttribute("editmode", false);
		return "index";
	}
}

