package in.ineuron.dao;

import java.util.List;

import in.ineuron.pojo.Product;

public interface IProductDao
{
	Integer addProduct(Product product);

	Product viewProduct(Integer productId);

	String updateProduct(Product product);

	String deleteProduct(Product product);

	List<Product> viewAllProdutsInfo();

}
