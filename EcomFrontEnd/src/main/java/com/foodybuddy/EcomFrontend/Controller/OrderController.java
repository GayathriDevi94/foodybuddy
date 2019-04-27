package com.foodybuddy.EcomFrontend.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodybuddy.EcomBackend.dao.AddressDao;
import com.foodybuddy.EcomBackend.dao.CartDao;
import com.foodybuddy.EcomBackend.dao.CustomerDao;
import com.foodybuddy.EcomBackend.dao.MyOrderDao;
import com.foodybuddy.EcomBackend.dao.ProductDao;
import com.foodybuddy.EcomBackend.model.Cart;
import com.foodybuddy.EcomBackend.model.MyOrder;
import com.foodybuddy.EcomBackend.model.Product;

@Controller
@RequestMapping("/user")
public class OrderController {
	
	@Autowired
	AddressDao addressdao;
	
	@Autowired
	CartDao cartdao;

	@Autowired
	ProductDao prodao;

	@Autowired
	CustomerDao custdao;
	
	@Autowired
	MyOrderDao myorderdao;
	
	@RequestMapping("/placeorder")

	String placeOrder(@RequestParam("addressid") int addid, Model model, HttpSession httpSession) {

		MyOrder myorder1 = new MyOrder();

		ArrayList<Cart> carts = (ArrayList<Cart>) cartdao.selectAllCarts(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));

		Iterator<Cart> iterator = carts.iterator();

		while (iterator.hasNext()) {

			Date d = new Date();

			long id = UUID.randomUUID().getMostSignificantBits();

			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));

			Cart cart = (Cart) iterator.next();

			Product p=prodao.selectOneProduct(cart.getProduct().getProdid());

			if (p.getProdstock()>= cart.getQuantity()) 

			{

				myorder1.setAddress(addressdao.selectOneAddress(addid));
				
				myorder1.setOrderid(oid);

				myorder1.setOrderdate(d);

				myorder1.setQuantity(cart.getQuantity());
				
				myorder1.setProduct(cart.getProduct());

				myorder1.setSubtotal(cart.getSubtotal());

				myorder1.setCustomer(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));

				int qty=p.getProdstock() - cart.getQuantity();
				
				p.setProdstock(qty);
				

				if(myorderdao.insertMyOrder(myorder1))

				{
					prodao.updateProduct(p);

					cartdao.deleteCart(cart.getItemid());

				}

			}

		}

		ArrayList<Cart> cartitems = (ArrayList<Cart>) cartdao.selectAllCarts(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString()));

		httpSession.setAttribute("itemcount", cartitems.size());

		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString())));

		model.addAttribute("orderPage", true);

		return "index";

	}

	

	@RequestMapping("/vieworders")

	String viewallorders(Model model,HttpSession httpSession)

	{

		model.addAttribute("orderlist", myorderdao.selectAllMyOrders(custdao.selectOneCustomer(httpSession.getAttribute("emailid").toString())));

		model.addAttribute("orderPage", true);

		return "index";

	}

	



	@RequestMapping("/receipt")

	String receipt(@RequestParam("rid")String oid,Model model,HttpSession httpSession)

	

	{

		model.addAttribute("order", myorderdao.selectOneMyOrder(oid));

		model.addAttribute("receiptPage", true);

		return "index";

		

	}



}


	


