package kr.co.LotteSpec.dao;

import java.util.List;

import kr.co.LotteSpec.domain.Product;

public interface ProductDao {

	public Product selectProduct(int id);
	
	public List<Product> selectProducts();
	
	public List<Product> selectProductsByProdName(String query);
	
	public List<Product> selectProductsByBarcode(String barcode);
	
}
