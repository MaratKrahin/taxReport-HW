
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class ShopReport implements Runnable {
    private final List<Integer> list;
    private final LongAdder longAdder;

    public ShopReport(List<Integer> list, LongAdder longAdder) {
        this.list = list;
        this.longAdder = longAdder;
    }

    @Override
    public void run() {
        list.forEach(longAdder::add);
    }

}