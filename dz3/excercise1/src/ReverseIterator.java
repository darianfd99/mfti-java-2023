import java.util.*;

public class ReverseIterator<T> implements Iterable{
    private final List<T> list;

    public ReverseIterator(List<T> ls) {
        list = ls.reversed();
    }

    @Override
    public Iterator iterator() {
        return list.listIterator();
    }
}
