package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class User {

    public static void main(String[] args) {
        try {


            Class aClass = Class.forName("domain.User");
//            Constructor<?>[] constructors = aClass.getConstructors();
////            for (Constructor<?> constructor : constructors) {
////                System.out.println(constructor);
////
////            }
//
//
            Method methodOrigin = null;
            Method[] methods = aClass.getDeclaredMethods();
//
//
//            Stream.of(methods);


            for (Method value : methods) {
                boolean setName = value.getName().equals("setName");
                if (setName) {
                    methodOrigin = value;
                }
            }
            User user = new User("ali", "ali");
            Object setNameMethodResult = methodOrigin.invoke(user, "mohammad");
            Method getNameMethod = Arrays.stream(methods)
                    .filter(method -> method.getName().equals("getName"))
                    .findFirst().get();
            Object getNameMethodResult = getNameMethod.invoke(user);
            System.out.println(getNameMethodResult);
            //aClass.getMethod();
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }


    private Long id;
    private String name;
    private String family;

    public User(Long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public User(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
