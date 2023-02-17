package in.ineuron.service;

import in.ineuron.pojo.Product;

public interface IProductService
{
	Integer addProduct(Product product);

	Product viewProduct(Product product);

	String updateProduct(Product product);

	String deleteProduct(Product product);
}
