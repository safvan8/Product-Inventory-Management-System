package in.ineuron.service;

import java.util.List;

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
		// creating Dao object
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
		System.out.println("ProductServiceImpl.updateProduct().................\n");

		// passing product to DAO
		productDao = ProductDaoFactory.getProductDao();

		return productDao.updateProduct(product);
	}

	@Override
	public String deleteProduct(Product product)
	{
		System.out.println("ProductServiceImpl.deleteProduct().....................\n");
		// passing to DAO
		productDao = ProductDaoFactory.getProductDao();
		return productDao.deleteProduct(product);
	}

	@Override
	public List<Product> viewAllProdutsInfo()
	{
		System.out.println("ProductServiceImpl.viewAllProdutsInfo()..............\n");
		// passing to DAO
		productDao = ProductDaoFactory.getProductDao();

		return productDao.viewAllProdutsInfo();
	}

	@Override
	public boolean authenticateUser(String username, String passwd)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
