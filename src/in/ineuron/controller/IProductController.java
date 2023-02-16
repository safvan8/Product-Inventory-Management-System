package in.ineuron.controller;

import in.ineuron.pojo.Product;

public interface IProductController
{
	String addProduct(Product product);

	Product viewProduct(Product product);

	String updateProduct(Product product);

	String deleteProduct(Product product);
}
