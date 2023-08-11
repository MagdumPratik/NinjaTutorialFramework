package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigPropertyFile {

	Properties pro;
	public ReadConfigPropertyFile()
	{
		File src=new File(".\\\\Configuration\\\\config.properties");
		try
		{
			FileInputStream fi=new FileInputStream(src);
			pro=new Properties();
			pro.load(fi);
		}
		catch(Exception e)
		{
			System.out.println("File Not Found"+e.getMessage());
		}
	}
	public String getURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUser()
	{
		String user=pro.getProperty("username");
		return user;
	}
	public String getPassword()
	{
		String pass=pro.getProperty("Password");
		return pass;
	}
	
}
