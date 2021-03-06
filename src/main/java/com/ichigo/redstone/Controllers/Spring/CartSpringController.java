package com.ichigo.redstone.Controllers.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ichigo.redstone.Model.Item;
import com.ichigo.redstone.Model.Cart;

import com.ichigo.redstone.Services.CartService;




@RequestMapping("/cart")
@Controller
//@Component
public class CartSpringController {


	@Autowired
	private CartService cs; // dependency

	public CartSpringController() {
		System.out.println("CartSpringController created...");
	}

	
  @RequestMapping(value="/getAllItemsInCart",method=RequestMethod.GET)	
  public String getAllItemsInCart(ModelMap map){
	  map.addAttribute("market", cs.getAllItems());	  
	  return "market";
  }
  
  
  @RequestMapping(value="/removeItem/{id}",method=RequestMethod.DELETE)	
  public String removeItem(@PathVariable("id") int itemID, ModelMap map){
	  cs.removeItem(itemID);
	   map.addAttribute("cartItemsList", cs.getAllItems());
	   return "cartItemsList";
  }
  

  @RequestMapping(value="/addItem/{id}",method=RequestMethod.POST)	
  public String addItem(@PathVariable("id") int itemID, ModelMap map){
	  cs.addItem(itemID);
	   map.addAttribute("cartItemsList", cs.getAllItems());
	   return "cartItemsList";
  }
  
 
  
}




