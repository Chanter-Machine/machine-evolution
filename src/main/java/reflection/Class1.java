package reflection;

public class Class1 {

    public static void main(String[] args) throws ClassNotFoundException {
        // By className
        Class clazz = Person.class;

        //forName
        Class class2 = Class.forName("reflection.Student");

        // By object
        Student stu = new Student();
        Class class3 = stu.getClass();
//        System.out.printf(class3);

        //
        Class class4 = Integer.TYPE;
        String str = new String("");
    }
}



class Person {
    int testNum;
}

class Student extends Person {

}


