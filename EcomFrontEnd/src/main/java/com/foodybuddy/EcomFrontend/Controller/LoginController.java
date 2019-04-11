package com.foodybuddy.EcomFrontend.Controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodybuddy.EcomBackend.dao.CustomerDao;
import com.foodybuddy.EcomBackend.model.Customer;

@Controller
public class LoginController {
	@Autowired
	CustomerDao custdao;

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
	String loginsuccess(Model model, HttpSession httpSession) {
		String emailid = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
				Customer customer = custdao.selectOneCustomer(emailid);
				httpSession.setAttribute("username", customer.getCustname());
				httpSession.setAttribute("customerid", customer.getCustid());
				httpSession.setAttribute("emailid", customer.getCustemailid());
				httpSession.setAttribute("customerloggedin", true);
				model.addAttribute("sliderPage", true);
			} else {
				httpSession.setAttribute("username", "ADMINISTRATOR");
				httpSession.setAttribute("adminloggedin", true);
				model.addAttribute("sliderPage", true);
			}
		}
		return "index";
	}

}
