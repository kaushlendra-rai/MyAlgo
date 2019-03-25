package fun.gridgame;

public class ClassLoaderFactory {

	public static Object loadClass(String logicalClassName) throws Exception
	{
		String className = PropertyLoader.getConfigValue(logicalClassName);
		return (Object)Class.forName(className).newInstance();
	}
}
