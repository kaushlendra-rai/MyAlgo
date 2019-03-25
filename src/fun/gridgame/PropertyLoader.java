package fun.gridgame;

import java.io.FileInputStream;
import java.util.Properties;

import com.rai.kaushal.util.MyConstants;


public class PropertyLoader {

	private static Properties prop = new Properties();
	
	private static Properties directionProp = new Properties();
	
	private static Properties configProp = new Properties();
	
	public static void load() throws Exception
	{
		FileInputStream source = new FileInputStream(MyConstants.BASE_PROPERTY_PATH + "grid_data.properties");
		prop.load(source);
		
		FileInputStream directionSource = new FileInputStream(MyConstants.BASE_PROPERTY_PATH + "grid_direction_value.properties");
		directionProp.load(directionSource);
		
		FileInputStream configSource = new FileInputStream(MyConstants.BASE_PROPERTY_PATH + "grid_game_config.properties");
		configProp.load(configSource);
	}
	
	public static String getValue(String direction)
	{
		if(direction != null)
			return prop.getProperty(direction);
		else
			return null;
	}
	
	public static String getDirectionValue(String direction)
	{
		if(direction != null)
			return directionProp.getProperty(direction);
		else
			return null;
	}
	
	public static String getConfigValue(String direction)
	{
		if(direction != null)
			return configProp.getProperty(direction);
		else
			return null;
	}
}
