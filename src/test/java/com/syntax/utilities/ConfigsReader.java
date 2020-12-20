package com.syntax.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	public static Properties prop ;
	
	/**
	 * This method will read properties
	 * @param filePath
	 */
	public static void readProperty (String filePath) {
	
		try {
			FileInputStream fis= new FileInputStream (filePath);
			prop = new Properties ();
			prop.load(fis);
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will return value of specified key
	 * @param String key
	 * @return String value
	 */
	
	public static String getProperty (String key) {
		return prop.getProperty(key);
	}

}
