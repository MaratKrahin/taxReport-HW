import java.util.List;

abstract class Calculation {

    public static void totalRevenue(List<Integer> list, String name) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.printf("Выручка магазина - %s составляет: %d \n", name, sum);
    }

}
