import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Main extends Calculation {
    public static void main(String[] args) {

        List<Integer> groceryReport = fillUpList(new ArrayList<>());
        List<Integer> meatReport = fillUpList(new ArrayList<>());
        List<Integer> bakingReport = fillUpList(new ArrayList<>());

        LongAdder lAdder = new LongAdder();

        Thread groceryShop = new Thread(new ShopReport(groceryReport, lAdder));
        Thread meatShop = new Thread(new ShopReport(meatReport, lAdder));
        Thread bakingShop = new Thread(new ShopReport(bakingReport, lAdder));

        groceryShop.start();
        meatShop.start();
        bakingShop.start();

        try {
            groceryShop.join();
            meatShop.join();
            bakingShop.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalRevenue(groceryReport, " продуктовый магазин ");
        totalRevenue(meatReport, " мясная лавка ");
        totalRevenue(bakingReport, " магазин выпечки ");

        System.out.printf("Выручка по 3 магазинам за день : %s рублей \n", lAdder.sum());

    }

    private static List<Integer> fillUpList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 1000 + 1));
        }
        return list;
    }
}
