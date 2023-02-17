package in.ineuron.controller;

import in.ineuron.factory.ProductServiceFactory;
import in.ineuron.pojo.Product;
import in.ineuron.service.IProductService;

public class ProductControllerImpl implements IProductController
{
	private IProductService productService = null;

	@Override
	public Integer addProduct(Product product)
	{
		System.out.println("ProductControllerImpl.addProduct()........\n");

		// creating object of service layer
		productService = ProductServiceFactory.getProductService();
		
		//forwarding to service layer
		return productService.addProduct(product);
	}

	@Override
	public Product viewProduct(Product product)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Product product)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
