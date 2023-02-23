package in.ineuron.dao;

import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.Session;

import in.ineuron.app_util.AppUtil;
import in.ineuron.app_util.HibernateUtil;
import in.ineuron.pojo.Customer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class UserValidator
{
	private String username = "";
	private String password = "";
	private BufferedReader bufferedReader = null;

	boolean authenticateUser()
	{
		System.out.println("UserValidator.authenticateUser()");
		// accepting user credentials string to instance variables
		getUserCredentials();

		if (isValidUser(username, password))
			return true;
		else
			return false;
	}

	// to accepts credentials from user through console
	void getUserCredentials()
	{
		System.out.println("UserValidator.getUserCredentials()");
		bufferedReader = AppUtil.getUserTextInputReader();

		try
		{
			System.out.println("Enter username:: ");
			username = bufferedReader.readLine();

			System.out.println("Enter password:: ");
			while (true)
			{
				int c = 0;
				try
				{
					c = bufferedReader.read();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// to stop reading
				if (c == -1 || c == '\n' || c == '\r')
				{
					break;
				}
				password += (char) c;
				System.out.print("*");
			}
			// hashing entered password and svaing to instance variable
			// at the time of getting user input itself
			password = hashPassword(password);

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Hashes the given plain-text password using the SHA-256 algorithm
	 * 
	 * @param password the plain-text password
	 * @return the hashed password as a string
	 */
	public static String hashPassword(String password)
	{
		System.out.println("UserValidator.hashPassword()");
		try
		{
			// Create a MessageDigest instance using the SHA-256 algorithm
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// Update the digest with the byte representation of the password
			md.update(password.getBytes());
			// Perform the digest operation, which results in a byte array
			byte[] bytes = md.digest();
			// Create a new StringBuilder to hold the hexadecimal representation of the
			// digest
			StringBuilder sb = new StringBuilder();
			// For each byte of the digest
			for (int i = 0; i < bytes.length; i++)
			{
				// Append the hexadecimal representation of the byte to the string builder
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Return the hexadecimal representation of the digest as a string
			return sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		// if hashing not success
		return null;
	}

	// validate userisvalid or not
	boolean isValidUser(String username, String passwd)
	{
		System.out.println("UserValidator.isValidUser()");
		Customer existingCustomerDetailsStored = null;

		Session session = HibernateUtil.getSession();

		// getting credentils from DB and checking valid or not
		existingCustomerDetailsStored = session.get(Customer.class, username);
		if (existingCustomerDetailsStored != null)
		{
			System.out.println("user found with entered username");
			
			if (existingCustomerDetailsStored.getUsername().equals(username)
					&& existingCustomerDetailsStored.getPasswd().equals(passwd))
				return true;
			else
			{
				System.out.println("Invalid password.....!");
				return false;
			}
		} else
		{
			System.out.println("invalid username.......");
			return false;
		}
	}
}
