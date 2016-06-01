package kr.co.LotteSpec.controller;

import java.util.ArrayList;
import java.util.List;

import kr.co.LotteSpec.dao.CartDao;
import kr.co.LotteSpec.dao.MemberDao;
import kr.co.LotteSpec.dao.ProductDao;
import kr.co.LotteSpec.domain.Cart;
import kr.co.LotteSpec.domain.Member;
import kr.co.LotteSpec.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AndroidController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ProductDao productDao ; 
	@Autowired
	private CartDao cartDao ;
	
	
	
	@ResponseBody
	@RequestMapping(value = "android/login", method=RequestMethod.POST)
	public String login(
			@RequestParam("user_name")  String email,
			@RequestParam("user_password") String password
			){
		
		System.out.println("android login  "+email + " "  );
		Member member = memberDao.selectMemberByEmail(email);
		if(memberDao.selectIsPwEquals(email, password)){
			return "success";
		} else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "android/search", method=RequestMethod.GET)
	public List<Product> findProd(
			@RequestParam("prod_name")  String prodName
			){
		
		System.out.println("android search  "+prodName+ " "  );
		
		List<Product> lists = productDao.selectProductsByProdName(prodName);
		return lists;
		
	}
	@ResponseBody
	@RequestMapping(value = "android/search", method=RequestMethod.POST)
	public List<Product> findProdpost(
			@RequestParam("prodName")  String prodName
			){
		
		System.out.println("android search  "+prodName+ " "  );
		
		List<Product> lists = productDao.selectProductsByProdName(prodName);
		return lists;
		
	}
	
	@ResponseBody
	@RequestMapping(value="android/cart")
	public List<Product> findProdcart(
		 @RequestParam("user_name") String email
		 
			){
		Member m = memberDao.selectMemberByEmail(email);
		List<Cart> carts = cartDao.selectProductsByMemId(m.getId());
		List <Product> products = new ArrayList<Product>();
		
		for(Cart c : carts){
			products.add(productDao.selectProduct(c.getProdId()));
		}
		return products;
	}
	
	@RequestMapping(value="android/addcart")
	public void addCart(
		 @RequestParam("user_name") String email,
		 @RequestParam("prod_id") int prodId
			){
		System.out.println("add Cart");
		
		Member m = memberDao.selectMemberByEmail(email);
		
		Cart cart = new Cart();
		if(m == null || prodId == 0)
			return;
		cart.setMemId(m.getId());
		cart.setProdId(prodId);
		cartDao.insertProductIntoCart(cart);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="android/barcode")
	public List<Product> barcodeSearch(
		 @RequestParam("barcode") String barcode
			){
		System.out.println("barcode Search");
		
		List<Product> lists= productDao.selectProductsByBarcode(barcode);
		return lists;
	}
	
	
	
	
	
	
}
