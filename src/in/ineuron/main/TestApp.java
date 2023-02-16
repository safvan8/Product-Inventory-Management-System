package in.ineuron.main;

import in.ineuron.pojo.Product;

public class TestApp
{

	public static void main(String[] args)
	{
		// for handling all user inputs
		UserInputHandler userInputHandler = UserInputHandler.getUserInputHandler();

		while (true)
		{
			int userChoice = userInputHandler.getUserChoice();

			if (userChoice == 1)
			{
				// creating Pojo class object and setting data for insert
				Product productForAdd = userInputHandler.getAddProdutInput();

				System.out.println(productForAdd);
			}

		}
	}

}
