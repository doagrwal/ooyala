
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static final String pathAppender = "/src/test/java/config/Common";
	private static final String extension = ".properties";


	public String fetchConfig(String property) {
		String result = null;
		InputStream inputStream = null;

		try {
			Properties prop = new Properties();
			inputStream = new FileInputStream(System.getProperty("user.dir") + pathAppender + extension);
			prop.load(inputStream);
			result = prop.getProperty(property);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;

	}


}
