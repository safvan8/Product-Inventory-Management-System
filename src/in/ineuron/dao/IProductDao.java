package in.ineuron.dao;

import in.ineuron.pojo.Product;

public interface IProductDao
{
	String addProduct(Product product);

	Product viewProduct(Product product);

	String updateProduct(Product product);

	String deleteProduct(Product product);
}
