package in.ineuron.main;

import java.io.BufferedReader;

import in.ineuron.app_util.AppUtil;

public class TestApp
{
	// to read inputs from user
	private static BufferedReader bufferedReader;

	public static void main(String[] args)
	{
		int result = acceptUserInput();

		
	}

	public static int acceptUserInput()
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
		// closing reader
		AppUtil.closeReader(bufferedReader);

		return userInput;
	}
}
