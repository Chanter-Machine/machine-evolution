package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class c1 = Class.forName("User");
        User user = (User)c1.newInstance();

        Constructor constructor = c1.getConstructor(String.class);

        User user2 = (User)c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        try {
            setName.invoke(user2, "");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User user3 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("Name");
        name.setAccessible(true);   //关闭private 安全检测
        name.set(user3, "name");

    }
}

class User {
    String Name;
}