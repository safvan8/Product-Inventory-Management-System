package in.ineuron.service;

import in.ineuron.pojo.Product;

public interface IProductService
{
	Integer addProduct(Product product);

	Product viewProduct(Integer productId);

	String updateProduct(Product product);

	String deleteProduct(Product product);
}
