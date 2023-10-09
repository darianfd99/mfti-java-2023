import Collections.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i = 0; i < 1000; ++i){
            ll.add(i);
        }
        System.out.println(ll);
        ll.add(0, 77);
        ll.add(5, 77);
        System.out.println(ll);
        System.out.println(ll.get(5));
        System.out.println(ll.get(34));
        System.out.println(ll.get(2));

        System.out.println(ll.remove(0));
        System.out.println(ll.remove(4));
        System.out.println(ll.remove(5));
        System.out.println(ll.remove(100));
        System.out.println(ll);

        for(Integer element: ll){
            System.out.println(element);
        }

        List<String> list = new ArrayList<>();
        list.add("asdg");
        list.add("hello");
        list.add("world");
        list.add("formal");
        list.add("language");

        LinkedList<String> newLl = new LinkedList<>();
        newLl.add("old");
        newLl.add("weird");
        System.out.println(newLl);
        newLl.copy(list);
        System.out.println(newLl);
        newLl.addAll(list);
        System.out.println(newLl);
    }

}