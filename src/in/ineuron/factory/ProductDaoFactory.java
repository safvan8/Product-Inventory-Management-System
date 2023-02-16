package in.ineuron.factory;

import in.ineuron.dao.IProductDao;
import in.ineuron.dao.ProductDaoImpl;

public class ProductDaoFactory
{

	private static IProductDao productDao = null;

	// not allowed to create object from outside class
	private ProductDaoFactory()
	{
	}

	public static IProductDao getProductDao()
	{
		// singleton design pattern
		if (productDao == null)
			productDao = new ProductDaoImpl();
		return productDao;
	}

}
