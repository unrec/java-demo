package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionDemo {
    public static void main(String[] args) {
        Mock object = new Mock();
        Class<Mock> myClass = Mock.class;
        System.out.println("Class - " + object.getClass().getName());

        // methods
        Method[] methods = Mock.class.getMethods();
        for (Method method : methods) {
            System.out.println("Method - " + method.getName());
        }

        try {
            Method method = myClass.getMethod("doStuff");
            System.out.println("doStuff? - " + method);
            Class returnType = method.getReturnType();
            System.out.println("doStuff return - " + returnType);

            System.out.print("doStuff is invoked - ");
            Object returnValue = method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // getters, setters
        System.out.println("Getters, setters: ");
        printGettersSetters(myClass);

        // private fields and methods
        try {
            Mock privateMock = new Mock("SECRET", 999, true);
            Field privateField = Mock.class.getDeclaredField("name");
            privateField.setAccessible(true);
            String fieldValue = (String) privateField.get(privateMock);
            System.out.println("Value of the private field - " + fieldValue);

            Method privateMethod = Mock.class.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            Object returnValue = (String) privateMethod.invoke(privateMock);
            System.out.println("Return value of the private method - " + returnValue);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // annotations
        Annotation[] annotations = Mock.class.getAnnotations();
        System.out.println("Getting annotation data: ");
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }

        // modifiers
        int modifiers = myClass.getModifiers();
        System.out.println("Modifiers - " + modifiers);
        System.out.println("Is abstract? - " + Modifier.isAbstract(modifiers));
        System.out.println("Is public? - " + Modifier.isPublic(modifiers));
        System.out.println("Package path - " + myClass.getPackage());

        // constructors
        Constructor[] constructors = myClass.getConstructors();
        Constructor constructor = constructors[0];
        Class[] parameterTypes = constructor.getParameterTypes();
        System.out.println("Parameters for public constructor - " + Arrays.asList(parameterTypes));
        try {
            Mock newMock = (Mock) constructor.newInstance("DEMO", 8, true);
            System.out.println("New instance via constructors - " + newMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // fields
        Field[] fields = myClass.getFields();
        System.out.println("There are " + fields.length + " public fields");

        try {
            Field field = myClass.getField("author");
            System.out.println("Field to set new value - " + field);
            Mock filedMock = new Mock("FIELD", 3, true);
            field.set(filedMock, "AUTHOR");
            System.out.println("Field were set for " + filedMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printGettersSetters(Class aClass) {
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {
            if (isGetter(method)) System.out.println("getter: " + method);
            if (isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}