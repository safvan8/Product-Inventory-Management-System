package in.ineuron.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

			session.close();
		}

		// returning generated PrimaryKey
		return generatedProdId;
	}

	// Logic for Viewing and existing Product object from Database using prodId
	@Override
	public Product viewProduct(Integer productId)
	{
		Product product = null;
		System.out.println("ProductDaoImpl.viewProduct()..........................\n");
		Session session = HibernateUtil.getSession();
		try
		{
			product = session.get(Product.class, productId);
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} finally
		{
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

		return product;
	}

	@Override
	public String updateProduct(Product product)
	{
		System.out.println("ProductDaoImpl.updateProduct().....................\n");

		// creating session object by calling utility method
		Session session = HibernateUtil.getSession();

		Transaction transaction = null;

		boolean isOperationSuceess = false;

		String updateStatus = null;

		try
		{
			transaction = session.beginTransaction();

			// updating database record
			session.update(product);

			transaction.commit();

			isOperationSuceess = true;

		} catch (HibernateException e)
		{
			e.printStackTrace();
			isOperationSuceess = false;

		} finally
		{
			if (isOperationSuceess)
				updateStatus = "success";
			else
				updateStatus = "failed";

			// closing session
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

		// updating

		return updateStatus;
	}

	// Logic for deleting an existing Product to Database
	@Override
	public String deleteProduct(Product product)
	{
		System.out.println("ProductDaoImpl.deleteProduct()........................\n");

		// creating session object by calling utility method
		Session session = HibernateUtil.getSession();

		Transaction transaction = null;

		boolean isOperationSuceess = false;

		String deleteStatus = null;

		try
		{
			transaction = session.beginTransaction();

			// deleting database record
			session.delete(product);

			transaction.commit();

			isOperationSuceess = true;

		} catch (HibernateException e)
		{
			e.printStackTrace();
			isOperationSuceess = false;

		} finally
		{
			if (isOperationSuceess)
				deleteStatus = "success";
			else
				deleteStatus = "failed";

			// closing session
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

		// updating

		return deleteStatus;
	}

	// code for viewing all records info
	@Override
	public List<Product> viewAllProdutsInfo()
	{
		System.out.println("ProductDaoImpl.viewAllProdutsInfo().........\n");

		// creating session object by calling utility method
		Session session = HibernateUtil.getSession();

		List<Product> allProducts = null;

		try
		{
			// creating a Query collection , which can hold Employee Objects
			Query<Product> query = session.createQuery("FROM in.ineuron.pojo.Product");

			allProducts = query.getResultList();

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

		return allProducts;
	}
}
