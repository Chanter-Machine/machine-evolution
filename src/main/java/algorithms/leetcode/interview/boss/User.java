package algorithms.leetcode.interview.boss;

import algorithms.leetcode.interview.MetaApp.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    private Integer age;
    public Integer getAge() {
        return age;
    }

    public Integer setAge() {
        return age;
    }

    public User(int age){
        this.age = age;
    }

    public static void remove(List<User> userList) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().age>20) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        User user1 = new User(10);
        User user2 = new User(20);
        User user3 = new User(21);
        User user4 = new User(15);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        remove(list);
        System.out.println(list);
    }
}
