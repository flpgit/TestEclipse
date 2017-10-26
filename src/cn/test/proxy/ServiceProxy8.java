package cn.test.proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.test.connection.DatabaseConnection8;

public class ServiceProxy8 implements InvocationHandler {
	private Object target;
	
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = null;
		String methodName = method.getName();
		try {
			if(methodName.startsWith("insert")||methodName.startsWith("add")||methodName.startsWith("edit")||methodName.startsWith("update")||methodName.startsWith("delete")){
				try {
					DatabaseConnection8.getConnection().setAutoCommit(false);
					ret = method.invoke(target, args);
					DatabaseConnection8.getConnection().commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				ret = method.invoke(target, args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
