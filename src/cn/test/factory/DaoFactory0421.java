package cn.test.factory;

public class DaoFactory0421 {
	private DaoFactory0421(){};
	
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
