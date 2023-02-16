package in.ineuron.main;

import java.io.BufferedReader;

import in.ineuron.app_util.AppUtil;
import in.ineuron.pojo.Product;

public class UserInputHandler
{
	private static UserInputHandler userInputHandler = null;

	// for raeading user input from console
	private static BufferedReader bufferedReader;

	private UserInputHandler()
	{
	}

	public static UserInputHandler getUserInputHandler()
	{
		if (userInputHandler == null)
			userInputHandler = new UserInputHandler();
		return userInputHandler;
	}

	// for getting choice from user
	public int getUserChoice()
	{
		System.out.println("----------------- Services offerd -----------------");
		System.out.println("1 : Add a new product");
		System.out.println("2 : View product details");
		System.out.println("3 : Update product details");
		System.out.println("4 : Delete a product");
		System.out.println("5 : EXIT");

		System.out.println("Enter your choice [ 1 to 5 ]...");

		Integer userInput = 0;
		boolean isValidInput = false;
		bufferedReader = AppUtil.getUserTextInputReader();

		// user input validation
		while (isValidInput == false)
		{
			try
			{
				userInput = Integer.parseInt(bufferedReader.readLine());
			} catch (NumberFormatException e)
			{
				isValidInput = false;
				System.err.println(" only Numbers allowed");
			} catch (Exception e)
			{
				isValidInput = false;
				System.err.println("Something went wrong " + e);
			}

			if (userInput >= 1 && userInput <= 5)
				isValidInput = true;

		}
//		// closing reader
//		AppUtil.closeReader(bufferedReader);

		return userInput;
	}

	// to get Product object for adding a new product
	public  Product getAddProdutInput()
	{
		System.out.println("\nYou have selected Add Product Option\n");

		Product product = null;
		// getting buffered reader to read input
		bufferedReader = AppUtil.getUserTextInputReader();

		try
		{

			System.out.println("Enter Product name ::");
			String productName = bufferedReader.readLine();

			System.out.println("Enter Product Description ::");
			String productDescription = bufferedReader.readLine();

			System.out.println("Enter Product price ::");
			Integer productPrice = Integer.parseInt(bufferedReader.readLine());

			System.out.println("Enter Product Quantity ::");
			Integer productQuantity = Integer.parseInt(bufferedReader.readLine());

			System.out.println("Enter Product Supplier ::");
			String productSupplier = bufferedReader.readLine();

			// creating Pojo class object and setting data for insert
			product = new Product();
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setProductPrice(productPrice);
			product.setProductQuantity(productQuantity);
			product.setProductSupplier(productSupplier);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}
}
