package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;

public class DynamicProxyDemo {

    public static void main(String[] args) {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicProxyDemo.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler());
        proxyInstance.put("Hello", "World");
    }

    static class DynamicInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object o, Method method, Object[] objects) {
            System.out.println("Invoked method: " + method.getName());
            System.out.println("Passed args: " + Arrays.asList(objects));
            return null;
        }
    }
}