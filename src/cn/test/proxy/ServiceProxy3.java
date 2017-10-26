package cn.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.test.connection.DatabaseConnection0421;

public class ServiceProxy3 implements InvocationHandler {
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
			if(methodName.startsWith("add")||methodName.startsWith("edit")||methodName.startsWith("update")||methodName.startsWith("delete")||methodName.startsWith("remove")){
				try {
					DatabaseConnection0421.getConnection().setAutoCommit(false);
					ret = method.invoke(target, args);
					DatabaseConnection0421.getConnection().commit();
				} catch (Exception e) {
					DatabaseConnection0421.getConnection().rollback();
					e.printStackTrace();
				} 
			} else {
				ret = method.invoke(target, args);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection0421.close();    //必须是用close()方法,如若不会清空threadLocal中的Connection对象,会导致数据库连接不能再次被打开
		}
		return null;
	}

}
