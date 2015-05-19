package net.sumppen.whatsapi4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFile {
	
	public static final String RELEASE_TOKEN = "releae_token";
	public static final String RELEASE_TIME =  "releae_time";
	
	
	private String propFileName = "config.properties";
	private Properties prop;
	 
	
	
	public LoadConfigFile()  {
		
		prop = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		
		try {
			if (inputStream != null) {
			
					prop.load(inputStream);
				
			} else {
				//throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				System.out.println("property file '" + propFileName + "' not found in the classpath");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		 
	}
	
	public String getValue(String key) {
			return prop.getProperty(key);
	}
	
	public String getValue(String key, String defaultValue) {
		 String ret =  prop.getProperty(key);
		 return ret==null?defaultValue:key;
	}

	

}
