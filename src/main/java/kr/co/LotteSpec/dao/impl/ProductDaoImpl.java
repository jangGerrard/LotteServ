package kr.co.LotteSpec.dao.impl;

import java.util.List;

import kr.co.LotteSpec.dao.ProductDao;
import kr.co.LotteSpec.dao.impl.mapper.ProductMapper;
import kr.co.LotteSpec.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductMapper prodMapper;
	
	
	@Override
	public Product selectProduct(int id) {
		return prodMapper.selectProduct(id);
	}

	@Override
	public List<Product> selectProducts() {
		return prodMapper.selectProducts();
	}
	
	public List<Product> selectProductsByProdName(String query){
		return prodMapper.selectProductsByProdName(query);
	}
	public List<Product> selectProductsByBarcode(String barcode){
		return prodMapper.selectProductsByBarcode(barcode);
	}


}
