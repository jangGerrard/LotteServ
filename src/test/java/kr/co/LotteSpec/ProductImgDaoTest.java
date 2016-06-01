package kr.co.LotteSpec;

import kr.co.LotteSpec.dao.ProductImgDao;
import kr.co.LotteSpec.domain.ProductImg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductImgDaoTest {

	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		ProductImgDao dao = ctx.getBean(ProductImgDao.class);
		
		ProductImg p = dao.selectProductUri(1);
		System.out.println(p.getProdId() + p.getImageUri());
	}
}
