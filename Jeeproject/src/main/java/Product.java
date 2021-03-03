import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "product_id")
	private String Product_Id;
	
	@Column(name = "product_name")
	private String Product_Name;
	
	@Column(name = "product_image")
	private String Product_Image;
	
	@Column(name = "product_description")
	private String Product_Description;
	
	@Column(name = "price")
	private int Product_Price;
	public Product(String product_Id, String product_Name, String product_Image, String product_Description,
			int product_Price) {
		super();
		Product_Id = product_Id;
		Product_Name = product_Name;
		Product_Image = product_Image;
		Product_Description = product_Description;
		Product_Price = product_Price;
	}
	public Product() {
		super();		// TODO Auto-generated constructor stub
	}
	public String getProduct_Id() {
		return Product_Id;
	}
	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getProduct_Image() {
		return Product_Image;
	}
	public void setProduct_Image(String product_Image) {
		Product_Image = product_Image;
	}
	public String getProduct_Description() {
		return Product_Description;
	}
	public void setProduct_Description(String product_Description) {
		Product_Description = product_Description;
	}
	public int getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
