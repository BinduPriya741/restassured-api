package com.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static final Properties properties = new Properties();
	
	public static void loadProperties(String fileName) throws IOException {
		InputStream inputStream = null;
        try {
        	inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }
            properties.load(inputStream);
        }
        finally {
        	if(inputStream != null) {
        		inputStream.close();
        	}
        }
    }
	
	public static String getProString(String key) {
		return properties.getProperty(key);
		
	}
}
