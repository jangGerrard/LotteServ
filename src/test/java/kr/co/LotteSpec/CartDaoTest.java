package kr.co.LotteSpec;

import java.util.List;

import kr.co.LotteSpec.dao.CartDao;
import kr.co.LotteSpec.domain.Cart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartDaoTest {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		CartDao dao = ctx.getBean(CartDao.class);
		
		List<Cart> cs= dao.selectProductsByMemId(1);
		//System.out.println(p.getProdId() + p.getImageUri());
		for(Cart c : cs ){
			System.out.println(c.getMemId() + " , "+c.getProdId());
		}
		
		Cart cart = new Cart();
		cart.setMemId(1);
		cart.setProdId(4);
		dao.insertProductIntoCart(cart);
		
		System.out.println();
		 cs= dao.selectProductsByMemId(1);
		//System.out.println(p.getProdId() + p.getImageUri());
		for(Cart c : cs ){
			System.out.println(c.getMemId() + " , "+c.getProdId());
		}
	}
}
