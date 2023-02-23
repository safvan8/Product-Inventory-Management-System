package in.ineuron.controller;

import java.util.List;

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

		// forwarding to service layer
		return productService.addProduct(product);
	}

	@Override
	public Product viewProduct(Integer productId)
	{
		System.out.println("ProductControllerImpl.viewProduct()....................\n");
		// passing to Service layer
		productService = ProductServiceFactory.getProductService();

		return productService.viewProduct(productId);
	}

	@Override
	public String updateProduct(Product product)
	{
		System.out.println("ProductControllerImpl.updateProduct()....................\n");

		// passing to service layer
		productService = ProductServiceFactory.getProductService();
		
		return productService.updateProduct(product);
	}

	@Override
	public String deleteProduct(Product product)
	{
		System.out.println("ProductControllerImpl.deleteProduct()......................\n");
		
		//passing to service layer
		productService = ProductServiceFactory.getProductService();
		
		return productService.deleteProduct(product);
	}

	@Override
	public List<Product> viewAllProdutsInfo()
	{
		System.out.println("ProductControllerImpl.viewAllProdutsInfo(................\n)");
		
		//passing to service layer
		productService = ProductServiceFactory.getProductService();
		
		return productService.viewAllProdutsInfo();
	}

}
