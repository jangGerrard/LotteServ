package kr.co.LotteSpec.dao;

import java.util.List;

import kr.co.LotteSpec.domain.Cart;

public interface CartDao {
	public List<Cart> selectProductsByMemId(int memId);
	
	public void insertProductIntoCart(Cart cart);
	
	public void deleteCartItem(Cart cart);
}
