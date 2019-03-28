package com.foodybuddy.EcomFrontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodybuddy.EcomBackend.dao.CategoryDao;
import com.foodybuddy.EcomBackend.dao.ProductDao;
import com.foodybuddy.EcomBackend.dao.SellerDao;
import com.foodybuddy.EcomBackend.model.Product;
import com.foodybuddy.EcomBackend.model.Seller;

@Controller
public class ProductController {
	@Autowired
	ProductDao proddao;
	@Autowired
	CategoryDao catdao;
	@Autowired
	SellerDao seldao;
	
	@RequestMapping("/product")
	String productPage(Model model) {
		model.addAttribute("prodobject", new Product());
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist",catdao.selectAllCategories());
		model.addAttribute("sellerlist",seldao.selectAllSellers());
		model.addAttribute("error",false);
		model.addAttribute("message","");
		model.addAttribute("success",false);
		model.addAttribute("editmode", false);
		model.addAttribute("productPage",true);
		return "index";
	}
	@RequestMapping("/addproduct")
	String addProduct(@Valid @ModelAttribute("prodobject")Product p,BindingResult bindingResult, Model model) {
		try {
			if(bindingResult.hasErrors())
			{
				model.addAttribute("prodobject",p);
				model.addAttribute("error",true);
				model.addAttribute("message","Inapproprite data");
		
			}
			else
			{
				if(proddao.insertProduct(p))
				{
					model.addAttribute("prodobject", new Product());
					model.addAttribute("success",true);

				}
				else
				{
					model.addAttribute("prodobject", new Product());
					model.addAttribute("message","pls try after sometimes");
					model.addAttribute("prodobject",p);
				}
			}
		}
		catch(Exception e)
		{
			model.addAttribute("prodobject",p);
			model.addAttribute("error",true);
			model.addAttribute("message","duplicate data");
		}
		model.addAttribute("productPage",true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist",catdao.selectAllCategories());
		model.addAttribute("sellerlist",seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}
	
	@RequestMapping("/deleteproduct")
	String deleteProduct(@RequestParam("prodid") int prodid, Model model) {
		if (proddao.deleteProduct(prodid)) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "pls try after sometimes");
		}
		model.addAttribute("prodobject", new Product());
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist",catdao.selectAllCategories());
		model.addAttribute("sellerlist",seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}
	@RequestMapping("/editproduct")
	String editCategory(@RequestParam("prodid") int prodid, Model model) {
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("prodobject", proddao.selectOneProduct(prodid));
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist",catdao.selectAllCategories());
		model.addAttribute("sellerlist",seldao.selectAllSellers());
		return "index";

	}
	@RequestMapping("/updateproduct")
	String updateProduct(@Valid @ModelAttribute("prodobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("prodobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inapproprite data");

			} else {
				if (proddao.updateProduct(p)) {
					model.addAttribute("prodobject", new Product());
					model.addAttribute("success", true);

				} else {
					model.addAttribute("prodobject", new Product());
					model.addAttribute("message", "pls try after sometimes");
					model.addAttribute("prodobject", p);
				}
			}
		} catch (Exception e) {
			model.addAttribute("prodobject", p);
			model.addAttribute("error", true);
			model.addAttribute("message", "duplicate data");
		}
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist",catdao.selectAllCategories());
		model.addAttribute("sellerlist",seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}


}

	
