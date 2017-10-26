package cn.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.xml.bind.Binder;

import cn.test.connection.DataBaseConnection;

public class ServiceProxy implements InvocationHandler {
	private Object target;
	
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retObj = null;
		String methodName = method.getName();
		try {
			if(methodName.startsWith("add")||methodName.startsWith("remove")||methodName.startsWith("edit")||methodName.startsWith("delete")){
				try {
					DataBaseConnection.getConnection().setAutoCommit(false);
					retObj = method.invoke(this.target, args);
					DataBaseConnection.getConnection().commit();
				} catch (Exception e) {
					DataBaseConnection.getConnection().rollback();
					e.printStackTrace();
				}
			} else {
				retObj = method.invoke(this.target, args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataBaseConnection.close();
		}
		return retObj;
	}

}
