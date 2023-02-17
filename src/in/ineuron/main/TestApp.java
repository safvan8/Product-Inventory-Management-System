package in.ineuron.main;

import in.ineuron.controller.IProductController;
import in.ineuron.factory.ProductControllerFactory;
import in.ineuron.pojo.Product;

public class TestApp
{

	private static IProductController productController = null;

	public static void main(String[] args)
	{
		// for handling all user inputs
		UserInputHandler userInputHandler = UserInputHandler.getUserInputHandler();
		int autoGeneratedProductId = 0;

		while (true)
		{
			int userChoice = userInputHandler.getUserChoice();

			switch (userChoice)
			{
			case 1:

				// creating Pojo class object and setting data for insert
				Product productForAdd = userInputHandler.getAddProdutInput();

				// passing to controller
				productController = ProductControllerFactory.getProductController();

				autoGeneratedProductId = productController.addProduct(productForAdd);

				if (autoGeneratedProductId == 0)
				{
					System.out.println("\n\n==================================================\n\n");
					System.err.println("Oops....Something Went wrong............");
					System.err.println("Insert Operation failed");
					System.out.println("\n\n==================================================\n\n");
				} else
				{
					System.out.println("\n\n==================================================\n\n");
					System.out.println("product details inserted Successfully");
					System.out.println("please take a note of Product Id: " + autoGeneratedProductId);
					System.out.println("\n\n==================================================\n\n");
				}

				break;

			case 2:

				// existed Product object retrived from DB uisng id
				Product retrivedProduct = null;

				int productId = 0;

				// accepting productId from user:
				productId = userInputHandler.getProdIdInputToViewProduct();

				// passing to controller
				productController = ProductControllerFactory.getProductController();

				retrivedProduct = productController.viewProduct(productId);

				if (retrivedProduct != null)
				{
					System.out.println("\n\n\n");
					System.out.println("records found: ");
					System.out.println(retrivedProduct);
					System.out.println("\n\n");
				} else
				{
					System.out.println("\n\n");
					System.err.println("No record Found with given product id");
					System.out.println("\n\n");
				}
				break;
			case 3:

				break;
			case 4:

				break;

			default:
				break;
			}
		}

	}
}
