package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;

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

		System.out.println("\n\n----------------- Services offered -----------------");
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
			else
				System.err.println("Kindly a Enter a number between 1 to 5");

		}
//		// closing reader
//		AppUtil.closeReader(bufferedReader);

		return userInput;
	}

	// to get Product object for adding a new product
	public Product getAddProdutInput()
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

	// to get ProductId from user to view a existing product
	public Integer getProdIdInputToViewProduct()
	{
		System.out.println("\nYou have selected View product details Option\n");

		Integer productId = 0;

		// getting buffered reader to read input
		bufferedReader = AppUtil.getUserTextInputReader();

		System.out.println("Enter Product id to View productDetails ::");
		try
		{
			productId = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException | IOException e)
		{
			System.err.println("Number is not Valid");
			e.getCause();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return productId;
	}

	// to get ProductId from user to update a existing product
	public Integer getProductIdforUpdate()
	{
		System.out.println("\nYou have selected View product details Option\n");

		Integer productId = 0;

		// getting buffered reader to read input
		bufferedReader = AppUtil.getUserTextInputReader();

		System.out.println("Enter Product id to Update Existing produc tDetails ::");

		try
		{
			productId = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException | IOException e)
		{
			System.err.println("Number is not Valid");
			e.getCause();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return productId;
	}

	// to get updated product details from user to existing product object
	public Product getLatestProductDetailsForUpdate(Product product)
	{
		// getting buffered reader to read input
		bufferedReader = AppUtil.getUserTextInputReader();

		try
		{
			System.out.println("Enter new  productName [ old name: " + product.getProductName() + " ]-->");
			String newProductName = bufferedReader.readLine();

			System.out
					.println("Enter new  productDescription [ old name: " + product.getProductDescription() + " ]-->");
			String newProductDescription = bufferedReader.readLine();

			System.out.println("Enter new  productSupplier [ old name: " + product.getProductSupplier() + " ]-->");
			String newProductSupplier = bufferedReader.readLine();

			// updatingproperties only if user enterd new valid data
			if (newProductName.trim() != "")
				product.setProductName(newProductName);

			if (newProductDescription.trim() != "")
				product.setProductDescription(newProductDescription);

			if (newProductSupplier.trim() != "")
				product.setProductSupplier(newProductSupplier);

			System.out.println("Enter new  productPrice [ old name: " + product.getProductPrice() + " ]-->");
			Integer newProductPrice = Integer.parseInt(bufferedReader.readLine());
			product.setProductPrice(newProductPrice);

			System.out.println("Enter new  productQuantity [ old name: " + product.getProductQuantity() + " ]-->");
			Integer newProductQuantity = Integer.parseInt(bufferedReader.readLine());
			product.setProductQuantity(newProductQuantity);

		} catch (NumberFormatException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

}
