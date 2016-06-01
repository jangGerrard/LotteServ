package kr.co.LotteSpec.dao.impl.mapper;

import java.util.List;

import kr.co.LotteSpec.domain.Product;

public interface ProductMapper {

	public Product selectProduct(int id);
	public List<Product> selectProducts();
	public List<Product> selectProductsByProdName(String query);
	public List<Product> selectProductsByBarcode(String barcode);
}
