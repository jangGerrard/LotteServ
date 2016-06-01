package kr.co.LotteSpec.dao.impl;

import java.util.List;

import kr.co.LotteSpec.dao.CartDao;
import kr.co.LotteSpec.dao.impl.mapper.CartMapper;
import kr.co.LotteSpec.domain.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private CartMapper cartMapper;
	
	public List<Cart> selectProductsByMemId(int memId){
		return cartMapper.selectProductsByMemId(memId);
	}
	
	public void insertProductIntoCart(Cart cart){
		this.cartMapper.insertProductIntoCart(cart);
	}
	
	public void deleteCartItem(Cart cart){
		this.cartMapper.deleteCartItem(cart);
	}
}
