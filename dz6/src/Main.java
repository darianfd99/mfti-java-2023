import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Example ex1 = new Example("ex1", 1);
        Example ex2 = new Example("ex2", 2);
        BeanUtils.assign(ex1, ex2);

        System.out.println(ex1.name);
        System.out.println(ex2.name);
        System.out.println(ex1.number);
        System.out.println(ex2.number);

        OtherExample ex3 = new OtherExample("ex3", 3);
        BeanUtils.assign(ex1, ex3);

        System.out.println(ex1.name);
        System.out.println(ex1.number);

        OtherExample1 ex4 = new OtherExample1("ex4", 4);
        BeanUtils.assign(ex1, ex4);

        System.out.println(ex1.name);
        System.out.println(ex1.number);
    }
}