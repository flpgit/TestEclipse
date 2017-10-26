package cn.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.test.connection.DatabaseConneciton5;

public class ServiceProxy5 implements InvocationHandler {
	private Object target;

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = null;
		String methodName = method.getName();
		try {
			if (methodName.startsWith("add") || methodName.startsWith("edit") || methodName.startsWith("update")
					|| methodName.startsWith("delete") || methodName.startsWith("remove")) {
				try {
					DatabaseConneciton5.getConnection().setAutoCommit(false);
					ret = method.invoke(target, args);
					DatabaseConneciton5.getConnection().commit();
				} catch (Exception e) {
					DatabaseConneciton5.getConnection().rollback();
					e.printStackTrace();
				}
			} else {
				ret = method.invoke(target, args);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConneciton5.close();
		}
		return null;
	}

}
