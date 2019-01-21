package utitlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	//Method to return value of the key from property file
	public String getProperty(String fileName,String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\main\\resources\\"+fileName+".properties"));
		return prop.getProperty(key);		
	}
	
}
