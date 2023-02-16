package in.ineuron.factory;

import in.ineuron.service.IProductService;
import in.ineuron.service.ProductServiceImpl;

public class ProductServiceFactory
{
	private static IProductService productService = null;

	// not allowed to create object from outside
	private ProductServiceFactory()
	{
	}

	// to get ProductService object
	public static IProductService getProductService()
	{
		System.out.println("ProductServiceFactory.getProductService()");

		if (productService == null)
			productService = new ProductServiceImpl();

		return productService;
	}
}
