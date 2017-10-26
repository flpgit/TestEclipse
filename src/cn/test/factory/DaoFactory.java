package cn.test.factory;

public class DaoFactory {
	private DaoFactory(){};
	
	public static<T> T getInstance(Class<T> cls){
		try {
			return cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
