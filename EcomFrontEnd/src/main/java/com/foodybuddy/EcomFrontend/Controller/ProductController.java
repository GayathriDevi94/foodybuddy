package com.foodybuddy.EcomFrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.foodybuddy.EcomBackend.dao.CategoryDao;
import com.foodybuddy.EcomBackend.dao.ProductDao;
import com.foodybuddy.EcomBackend.dao.SellerDao;
import com.foodybuddy.EcomBackend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao proddao;
	@Autowired
	CategoryDao catdao;
	@Autowired
	SellerDao seldao;

	void addimage(MultipartFile f, int id) {
		try {
			String path = "G:\\FoodyBoddy\\EcomFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}
	}

	void deleteimage(int id) {
		try {
			String path = "G:\\FoodyBoddy\\EcomFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
			path = path + String.valueOf(id) + ".jpg";
			File x = new File(path);
			if (x.exists()) {
				x.delete();
			}

			Thread.sleep(5000);
		} catch (Exception e) {

		}
	}

	@RequestMapping("/admin/product")
	String productPage(Model model) {
		model.addAttribute("prodobject", new Product());
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", seldao.selectAllSellers());
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("success", false);
		model.addAttribute("editmode", false);
		model.addAttribute("productPage", true);
		return "index";
	}
	@RequestMapping("/viewproduct")
	String viewproductPage(Model model) {
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("viewproductPage", true);
		return "index";
	}
	@RequestMapping("/viewoneproduct")
	String viewoneproductPage(@RequestParam("prodid")int prodid, Model model) {
		model.addAttribute("myproduct", proddao.selectOneProduct(prodid));
		model.addAttribute("viewoneproductPage", true);
		return "index";
	}
	@RequestMapping("/selectbycat")
	String viewcatproductPage(@RequestParam("catid")int id, Model model) {
		model.addAttribute("productlist", proddao.selectCatProducts(id));
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("viewproductPage", true);
		return "index";
	}

	@RequestMapping("/admin/addproduct")
	String addProduct(@Valid @ModelAttribute("prodobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("prodobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inapproprite data");

			} else {
				if (proddao.insertProduct(p)) {
					addimage(p.getPimage(), p.getProdid());
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
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}

	@RequestMapping("/admin/deleteproduct")
	String deleteProduct(@RequestParam("prodid") int prodid, Model model) {
		if (proddao.deleteProduct(prodid)) {
			deleteimage(prodid);
			model.addAttribute("success", true);
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "pls try after sometimes");
		}
		model.addAttribute("prodobject", new Product());
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}

	@RequestMapping("/admin/editproduct")
	String editCategory(@RequestParam("prodid") int prodid, Model model) {
		model.addAttribute("editmode", true);
		model.addAttribute("success", false);
		model.addAttribute("error", false);
		model.addAttribute("message", "");
		model.addAttribute("prodobject", proddao.selectOneProduct(prodid));
		model.addAttribute("productPage", true);
		model.addAttribute("productlist", proddao.selectAllProducts());
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", seldao.selectAllSellers());
		return "index";

	}

	@RequestMapping("/admin/updateproduct")
	String updateProduct(@Valid @ModelAttribute("prodobject") Product p, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				model.addAttribute("prodobject", p);
				model.addAttribute("error", true);
				model.addAttribute("message", "Inapproprite data");

			} else {
				if (proddao.updateProduct(p)) {
					addimage(p.getPimage(), p.getProdid());
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
		model.addAttribute("categorylist", catdao.selectAllCategories());
		model.addAttribute("sellerlist", seldao.selectAllSellers());
		model.addAttribute("editmode", false);
		return "index";

	}

}
