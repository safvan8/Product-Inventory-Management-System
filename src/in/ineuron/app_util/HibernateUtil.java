package in.ineuron.app_util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	static
	{
		try
		{
			cfg = new Configuration();
			cfg.configure("/in/ineuron/resources/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Session getSession()
	{
		session = sessionFactory.openSession();
		System.out.println("session Object created successfully.......");
		return session;
	}

	public static void closeSession(Session session)
	{
		if (session != null)
		{
			session.close();
		}
	}

	public static void closeSessionFactory()
	{
		if (sessionFactory != null)
		{
			sessionFactory.close();
		}
	}

}
