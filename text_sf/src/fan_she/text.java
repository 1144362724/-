package fan_she;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class Person {
    private String name;//
    private int age;//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    private String school;//
}


public class text {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        String attr = "name";//明确要设置的属性名称
        String value = "MOGANG";//明确要设置的类容
        Class<?> cls = Class.forName("fan_she.Person");//获取反射
        Class<?> cls1 = Class.forName("fan_she.Student");

        //对比取得的属性成员
        {
            //普通代码块----取父类属性成员
            Field field[] = cls1.getFields();
            for (int i = 0; i < field.length; i++) {
                System.out.println(field[i]);
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        {   //普通代码块-----取子类的属性成员
            Field field[] = cls1.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                System.out.println(field[i]);
            }
        }
        System.out.println("------------------------------------");
        //实例化无参构造,不想写要加上无参构造
        Constructor<?> con = cls.getConstructor(String.class, int.class);
        System.out.println(con.newInstance("张三", 20));
        Object obj = cls.newInstance();//这里时要写要加上无参构造

        {
            //获取setName方法的实例化对象，设置方法名称和参数类型
            //setName()是方法名称，但是这个是根据给定的信息拼凑而来
            Method setMetod = cls.getMethod("set" + initcap(attr), String.class);
            //相当于Person对象.setName
            setMetod.invoke(obj, value);
            Method getMethod = cls.getMethod("get" + initcap(attr));
            //Person对象.getame
            Object ret = getMethod.invoke(obj);
            System.out.println(ret);
        }
        System.out.println("------------------------------------");
        {

            Field field = cls.getDeclaredField("name");//操作name属性
            field.setAccessible(true);//取消封装-------都可以取消封装
            field.set(obj, "李四");
            System.out.println(field.get(obj));
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        {
            Field field = cls.getDeclaredField("name");//操作name属性
            System.out.println(field.getType());
            System.out.println(field.getType().getName());
            System.out.println(field.getType().getSimpleName());
        }
    }

    public static String initcap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
