package com.Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties properties;

	String path="C:\\Users\\Ashwini\\eclipse-workspace\\Batch_130_Framework\\Configuration\\config.properties";

	public ReadConfig()
	{
		properties=new Properties();

		try 
		{
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String getBaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
		{
			return value;  
		}
		else
		{
			throw new RuntimeException("Browser is not present in config file");
		}
	}
		public String getBrowser()
		{
			String value=properties.getProperty("browser");
			if(value!=null)
			{
				return value;  
			}
			else
			{
				throw new RuntimeException("Browser is not present in config file");
			}
	}
}