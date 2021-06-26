package reflection.spring;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Test {

    public  void Test(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        //创建对象
        UserSerivce userSerivce = new UserSerivce();
        //获取对象所有属性
        Field serviceField = clazz.getDeclaredField("userSerivce");
        serviceField.setAccessible(true);
        //只有通过风法才能设置具体的属性值
        String name = serviceField.getName();
//      //拼接具体方法名称
        name = name.substring(0,1).toUpperCase(Locale.ROOT)+name.substring(1,name.length());
        String setMethodName = "set" + name;
        // 通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, UserSerivce.class);
        //
        method.invoke(userController, userSerivce);
    }


}
