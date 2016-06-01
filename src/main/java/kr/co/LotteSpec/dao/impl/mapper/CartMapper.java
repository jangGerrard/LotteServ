package kr.co.LotteSpec.dao.impl.mapper;

import java.util.List;

import kr.co.LotteSpec.domain.Cart;

public interface CartMapper {
	public List<Cart> selectProductsByMemId(int memId);
	
	public void insertProductIntoCart(Cart cart);
	
	public void deleteCartItem(Cart cart);
}
