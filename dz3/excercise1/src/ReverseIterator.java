import java.util.*;
import java.util.function.Consumer;

public class ReverseIterator<T> implements Iterable{
    private final List<T> list;

    public ReverseIterator(List<T> ls) {
        list = new ArrayList<>(ls);
        Collections.reverse(this.list);
    }

    @Override
    public Iterator iterator() {
        return list.listIterator();
    }
}
