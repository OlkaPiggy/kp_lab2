import java.util.ArrayList;
import java.util.Comparator;

public class SortManager {

    class InnerSort implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            BabyProduct a1 = (BabyProduct) o1;
            BabyProduct a2 = (BabyProduct) o2;

            return a1.getName().compareTo(a2.getName());
        }
    }

    static class StaticSort implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            BabyProduct a1 = (BabyProduct) o1;
            BabyProduct a2 = (BabyProduct) o2;

            return a2.getName().compareTo(a1.getName());
        }
    }

    //Через внутрішній клас (Сортує тип тварини)
    public ArrayList<BabyProduct> sortAlphabetEncreasing(ArrayList<BabyProduct> list) {
        var resList = new ArrayList<BabyProduct>(list);

        resList.sort(new InnerSort());
        return resList;
    }

    //Через статичний клас (Сортує тип тварини в зворотньому напрямку)
    public ArrayList<BabyProduct> sortAlphabetDecreasing(ArrayList<BabyProduct> list) {
        var resList = new ArrayList<BabyProduct>(list);

        resList.sort(new StaticSort());
        return resList;
    }

    //Анонімний клас (Сортує об'єм акваріума)
    public static ArrayList<BabyProduct> sortPriceIncreasing(ArrayList<BabyProduct> list) {
        var resList = new ArrayList<BabyProduct>(list);

        resList.sort(new Comparator<BabyProduct>() {
            @Override
            public int compare(BabyProduct o1, BabyProduct o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        return resList;
    }

    //Використовуючи лямбда-вираз (Сортує об'єм акваріума в зворотньому напрямку)
    public static ArrayList<BabyProduct> sortPriceDecreasing(ArrayList<BabyProduct> list) {
        var resList = new ArrayList<>(list);

        resList.sort((BabyProduct a1, BabyProduct a2) -> a2.getPrice() - a1.getPrice());
        return resList;
    }
}
