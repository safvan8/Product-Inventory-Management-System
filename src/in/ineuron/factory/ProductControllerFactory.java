package in.ineuron.factory;

import in.ineuron.controller.IProductController;
import in.ineuron.controller.ProductControllerImpl;

public class ProductControllerFactory
{
	private static IProductController productController = null;

	// not allowed to create object from outside class
	private ProductControllerFactory()
	{
	}

	// for creating Object of implementation class without
	// knowing the implementation class name
	public static IProductController getProductController()
	{
		System.out.println("ProductControllerFactory.getProductController().........");
		
		// singleton design parttern
		if (productController == null)
			productController = new ProductControllerImpl();
		
		return productController;
	}
}
