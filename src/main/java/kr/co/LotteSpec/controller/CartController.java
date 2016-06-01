package kr.co.LotteSpec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.LotteSpec.dao.CartDao;
import kr.co.LotteSpec.dao.ProductDao;
import kr.co.LotteSpec.domain.Cart;
import kr.co.LotteSpec.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao prodDao;
	
	@RequestMapping("cart")
	public ModelAndView toCartJsp(){
		System.out.println("toCartJsp");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart");
		return mav;
	}
	
	@RequestMapping("cart/list")
	@ResponseBody
	public List<Product> showCart(
			HttpSession session
			){
		System.out.println("show cart");
		Integer loginId = (Integer)session.getAttribute("loginId");
		List<Cart> carts = cartDao.selectProductsByMemId(loginId);
		List <Product> products = new ArrayList<Product>();
		
		for(Cart c : carts){
			products.add(prodDao.selectProduct(c.getProdId()));
		}
		
		return products;
	}
	
	@RequestMapping("cart/dosome")
	public ModelAndView dosomeCartList (
			@RequestParam("products" ) List<Integer> cartList,
			@RequestParam("whichBtn") int which,
			HttpSession session
			){
		System.out.println("dosomeCartList");
		Integer loginId = (Integer)session.getAttribute("loginId");
		
		Cart cart = new Cart();
		cart.setMemId(loginId);
		ModelAndView mav = new ModelAndView();
		if(which == 1){//billing
			System.out.println("bill");
		
			for(int i : cartList){
				cart.setProdId(i);
				cartDao.deleteCartItem(cart);
			}
			
			
			mav.setViewName("bill");
		}
		else if(which == 2){ // delete
			System.out.println("delete");
			mav.setViewName("cart");
			for(int i : cartList){
				cart.setProdId(i);
				cartDao.deleteCartItem(cart);
			}
		}
		
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("cart/test")
	public String addList( ){
		return "test";
	}
}
