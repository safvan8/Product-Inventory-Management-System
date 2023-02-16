package in.ineuron.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;

	// automtic Primary key generation
	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@Column(name = "p_name", length = 40)
	private String productName;

	@Column(name = "p_description", length = 200)
	private String productDescription;

	@Column(name = "p_price", length = 30)
	private Integer productPrice;

	@Column(name = "p_quantity", length = 30)
	private Integer productQuantity;

	@Column(name = "p_supplier", length = 30)
	private String productSupplier;

	@Column(name = "d_open")
	@CreationTimestamp
	private LocalDateTime productOpenDate;

	@Column(name = "d_last_mod")
	@UpdateTimestamp
	private LocalDateTime productLastModDate;

	public Integer getProductId()
	{
		return productId;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getProductDescription()
	{
		return productDescription;
	}

	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}

	public Integer getProductPrice()
	{
		return productPrice;
	}

	public void setProductPrice(Integer productPrice)
	{
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity()
	{
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity)
	{
		this.productQuantity = productQuantity;
	}

	public String getProductSupplier()
	{
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier)
	{
		this.productSupplier = productSupplier;
	}

	public LocalDateTime getProductOpenDate()
	{
		return productOpenDate;
	}

	public void setProductOpenDate(LocalDateTime productOpenDate)
	{
		this.productOpenDate = productOpenDate;
	}

	public LocalDateTime getProductLastModDate()
	{
		return productLastModDate;
	}

	public void setProductLastModDate(LocalDateTime productLastModDate)
	{
		this.productLastModDate = productLastModDate;
	}

	@Override
	public String toString()
	{
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productSupplier=" + productSupplier + ", productOpenDate=" + productOpenDate
				+ ", productLastModDate=" + productLastModDate + "]";
	}

}
