package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.app_util.HibernateUtil;
import in.ineuron.pojo.Product;

public class ProductDaoImpl implements IProductDao
{

	// Logic for Inserting a new Product to Database
	@Override
	public Integer addProduct(Product product)
	{
		System.out.println("ProductDaoImpl.addProduct()...........\n");

		int generatedProdId = 0;

		// creating session object by calling utility method
		Session session = HibernateUtil.getSession();

		boolean isOperationSuceess = false;
		// getting transaction -> to setAutocommit(flase)
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();

			// inserting object to DB
			// if we use save() method then Hibernate Software will insert a record in DB
			// and return generated primary key value,
			generatedProdId = (Integer) session.save(product);

			isOperationSuceess = true;

		} catch (Exception e)
		{
			e.printStackTrace();
			isOperationSuceess = false;
		} finally
		{
			if (isOperationSuceess)
				transaction.commit();
			else
				transaction.rollback();
		}

		// returning generated PrimaryKey
		return generatedProdId;
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
