package com.foodybuddy.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodybuddy.EcomBackend.dao.SellerDao;
import com.foodybuddy.EcomBackend.model.Category;
import com.foodybuddy.EcomBackend.model.Seller;
@Controller
@RequestMapping("/admin")
public class SellerController {
	@Autowired
	SellerDao selldao;
	
	@RequestMapping("/seller")
	String SellerPage(Model model) {
		model.addAttribute("sellobject", new Seller());
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		model.addAttribute("sellerPage",true);
		model.addAttribute("error",false);
		model.addAttribute("message","");
		model.addAttribute("success",false);
		model.addAttribute("editmode", false);
		return "index";

	}

	@RequestMapping("/addseller")
	String addSeller(@Valid @ModelAttribute("sellobject")Seller c,BindingResult bindingResult, Model model) {
		try {
			if(bindingResult.hasErrors())
			{
				model.addAttribute("sellobject",c);
				model.addAttribute("error",true);
				model.addAttribute("message","Inapproprite data");
		
			}
			else
			{
				if(selldao.insertSeller(c))
				{
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("success",true);

				}
				else
				{
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("message","pls try after sometimes");
					model.addAttribute("sellobject",c);
				}
			}
		}
		catch(Exception e)
		{
			model.addAttribute("sellobject",c);
			model.addAttribute("error",true);
			model.addAttribute("message","duplicate data");
		}
		model.addAttribute("sellerPage",true);
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}
	@RequestMapping("/deleteseller")
	String deleteCategory(@RequestParam("sellname") String sellname, Model model) {
		if (selldao.deleteSeller(sellname)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "pls try after sometimes");
		}
		model.addAttribute("sellobject", new Seller());
		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}
	@RequestMapping("/editseller")
	String editCategory(@RequestParam("sellname") String sellname, Model model) {
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("sellobject", selldao.selectOneSeller(sellname));
		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		return "index";

	}
	@RequestMapping("/updateseller")
	String updateCategory(@Valid @ModelAttribute("sellobject") Seller c, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sellobject", c);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inapproprite data");

			} else {
				if (selldao.updateSeller(c)) {
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("success", true);

				} else {
					model.addAttribute("sellobject", new Seller());
					model.addAttribute("message", "pls try after sometimes");
					model.addAttribute("sellobject", c);
				}
			}
		} catch (Exception e) {
			model.addAttribute("sellobject", c);
			model.addAttribute("error", true);
			model.addAttribute("message", "duplicate data");
		}
		model.addAttribute("sellerPage", true);
		model.addAttribute("sellerlist", selldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}


}
