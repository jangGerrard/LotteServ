package kr.co.LotteSpec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.LotteSpec.dao.ProductDao;
import kr.co.LotteSpec.dao.ProductImgDao;
import kr.co.LotteSpec.domain.Product;
import kr.co.LotteSpec.domain.ProductImg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;
	
	@RequestMapping("product/detail")
	@ResponseBody
	public Product findProduct(
			@RequestParam("productId") int prodId
			){
		Product product =productDao.selectProduct(prodId);
		
		return product;
	}
	
	@RequestMapping("product/lists")
	@ResponseBody
	public List<Product> findProducts(
			@RequestParam(value = "limit", required = false) long limit
			){
		List<Product> products = productDao.selectProducts(); 
		
		return products;
	}
	
	@RequestMapping("product/download")
	public void productImgDownload(@RequestParam("no") int no,
			HttpServletResponse response) {
		ProductImg productImg = null;
		String filePath = null;

		if (productImgDao.selectProductUri(no) != null)
		{
			productImg = productImgDao.selectProductUri(no);
			filePath = productImg.getImageUri();
			System.out.println("filePath = " + filePath);
			
			File file = new File(filePath);//db의 저장된 filepath를 가지고 파일객체 생성해서
			response.setContentLength((int) file.length());//?.?
			
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(file);//인풋스트림열어서
				os = response.getOutputStream();//서버에서의 업로드된 파일을 가져오는거다.
				byte[] buffer = new byte[4096];
				while (is.read(buffer) >= 0) {
					os.write(buffer);
				}
				os.flush();
			} 
			catch (Exception e) {
				System.out.println("Article 경로에 지정된 사진이 없습니다. \"Article No\" : "+no);
			}finally {if (is != null)try {is.close();} catch (Exception e) {}
			if (os != null)try {os.close();} catch (Exception e) {}}
		}
	
	}
	
	
	
}
