package kr.co.LotteSpec.dao.impl;

import kr.co.LotteSpec.dao.ProductImgDao;
import kr.co.LotteSpec.dao.impl.mapper.ProductImgMapper;
import kr.co.LotteSpec.domain.ProductImg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImgDaoImpl implements ProductImgDao{

	
	@Autowired
	private ProductImgMapper prodImgMapper;
	
	@Override
	public ProductImg selectProductUri(int prodId) {
		return this.prodImgMapper.selectProductUri(prodId);
	}

}
