package designpattern.com.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProblem {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        SingleTonClass instance = SingleTonClass.getInstance();
        SingleTonClass instance2 = null;
        Constructor constructors = SingleTonClass.class.getDeclaredConstructor();
        // All constructor becomes accessible
        constructors.setAccessible(true);
        try {
            instance2 = (SingleTonClass) constructors.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}
