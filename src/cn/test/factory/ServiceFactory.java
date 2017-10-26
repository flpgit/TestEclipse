package cn.test.factory;

import cn.test.proxy.ServiceProxy;

public class ServiceFactory {
	private ServiceFactory(){};
	
	public static<T> T getInstance(Class<T> cls){
		try {
			return (T)new ServiceProxy().bind(cls.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
