package in.ineuron.controller;

import java.util.List;

import in.ineuron.pojo.Product;

public interface IProductController
{
	Integer addProduct(Product product);

	Product viewProduct(Integer productId);

	String updateProduct(Product product);

	String deleteProduct(Product product);

	List<Product> viewAllProdutsInfo();
}
