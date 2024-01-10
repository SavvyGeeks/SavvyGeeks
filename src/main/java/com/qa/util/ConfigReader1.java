
package com.qa.util;


	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//public class ConfigReader1 {
//	
//	private static Properties prop;
//	private static String proppath= "src/test/resources/config/config.properties";
//	
//	public static void configload()throws Throwable {
//	
//	try {
//		FileInputStream ip= new FileInputStream(proppath);
//		prop=new Properties();
//		try {
//			prop.load(ip);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		throw new RuntimeException("config.properties not found at " + proppath);
//	}
//	}

	public class ConfigReader1 {
	    private static Properties prop;
	    
	    

	    public Properties init_prop() {
	        prop = new Properties();
	        try {
	            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
	            prop.load(ip);
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return prop;
	    }

	
	
	
	public static String getBrowserType() {
		String browser = prop.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the config.properties file.");
	}
	
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
	}
	
	public static String getHomePage() {
		String homepage = prop.getProperty("homepage");
		if (homepage != null)
			return homepage;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
				
	}
	
	public static String getregisterUrl() {
		String register=prop.getProperty("registerurl");
		if(register!=null)
			return register;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
	}
	
	public static String getloginUrl() {
		String login=prop.getProperty("loginpage");
		if(login!=null)
			return login;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
	}

//	public Properties init_prop() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	}
	