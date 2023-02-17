package in.ineuron.service;

import in.ineuron.dao.IProductDao;
import in.ineuron.factory.ProductDaoFactory;
import in.ineuron.pojo.Product;

public class ProductServiceImpl implements IProductService
{
	private IProductDao productDao = null;

	@Override
	public Integer addProduct(Product product)
	{
		System.out.println("ProductServiceImpl.addProduct()............\n");
		//creating Dao object
		productDao = ProductDaoFactory.getProductDao();
		// forwarding to Dao 
		return productDao.addProduct(product);
	}

	@Override
	public Product viewProduct(Integer productId)
	{
		System.out.println("ProductServiceImpl.viewProduct().................\n");
		
		// passing to Dao
		productDao = ProductDaoFactory.getProductDao();
		return productDao.viewProduct(productId);
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
