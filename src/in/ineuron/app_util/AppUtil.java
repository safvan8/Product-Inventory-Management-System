package in.ineuron.app_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class AppUtil
{

	private static BufferedReader userTextInputReader = null;

	// making singleton
	private AppUtil()
	{
	}

	// to get text reader
	public static BufferedReader getUserTextInputReader()
	{
		if (userTextInputReader == null)
			userTextInputReader = new BufferedReader(new InputStreamReader(System.in));

		return userTextInputReader;
	}

	// to close any reader
	public static void closeReader(Reader reader)
	{

		if (reader != null)
		{
			try
			{
				reader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
