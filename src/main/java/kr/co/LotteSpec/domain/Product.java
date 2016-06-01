package kr.co.LotteSpec.domain;

public class Product {

	private int id ;
	private String prodName;
	private int price;
	private String content;
	private String barcode;
	
	public Product(){
		
	}
	
	public Product(int id, String prodName, int price, String content, String barcode) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
		this.content = content;
		this.barcode = barcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getBarcode(){
		return this.barcode;
	}
	
	public void setBarcode(String barcode){
		this.barcode = barcode;
	}

}
