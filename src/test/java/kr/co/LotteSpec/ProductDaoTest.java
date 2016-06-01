package kr.co.LotteSpec;

import java.util.List;

import kr.co.LotteSpec.dao.ProductDao;
import kr.co.LotteSpec.domain.Product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDaoTest {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		ProductDao dao = ctx.getBean(ProductDao.class);
		
		List<Product> lists = dao.selectProductsByProdName("백");
		
		
		for(Product p  : lists){
			System.out.println(p.getId() + p.getProdName());
			
		}
	}
}
