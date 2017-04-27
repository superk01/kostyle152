package Category.model;
import java.util.ArrayList;
import java.util.List;

public class Product {
    
    private String product_link = ""; //물건 링크�?
    //물건 ?��명값
    private String product_name = "";//물건 ?��름값
    private String product_price = "";//물건 금액 �?
    private String product_ImageLink = "";//물건 ?��미�? 링크�?
	public String getProduct_link() {
		return product_link;
	}
	public void setProduct_link(String product_link) {
		this.product_link = product_link;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_ImageLink() {
		return product_ImageLink;
	}
	public void setProduct_ImageLink(String product_ImageLink) {
		this.product_ImageLink = product_ImageLink;
	}
	
	public Product(String product_link, String product_name, String product_price, String product_ImageLink) {
		super();
		this.product_link = product_link;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_ImageLink = product_ImageLink;
	}
	
	public Product(){}
	@Override
	public String toString() {
		return "\n Product [product_link=" + product_link + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_ImageLink=" + product_ImageLink + "]\n";
	}

}
