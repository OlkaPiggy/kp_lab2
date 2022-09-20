/*Дитячий магазин. Реалізувати ієрархію засобів догляду за немовлятами, які є в
        дитячому магазині. Врахувати, що товари мають різний термін придатності і
        розраховані на різні вікові категорії. Здійснити пошук товарів, які можна
        використати для дитини певного віку.
        Реалізувати можливість сортування знайдених товарів за двома типами
        параметрів (на вибір, реалізовано як два окремі методи)
        Реалізація сортування має передбачати можливість сортувати як за спаданням,
        так і за зростанням*/
import java.util.ArrayList;
public class BabyProductListManager {

    private ArrayList<BabyProduct> arr;
    private int realSize;
    private int size;

    public int getRealSize(){
        return this.realSize;
    }
    public ArrayList<BabyProduct> getArr(){
        return this.arr;
    }
    void setRealSize(int n)
    {
        realSize=n;
    }
    void setArr(ArrayList<BabyProduct> arr1)
    {
        arr=arr1;
    }

    BabyProductListManager(ArrayList<BabyProduct> arr,int realSize)
    {
        this.arr=arr;
        this.realSize=realSize;
    }
    void print()
    {
        for(int i=0;i<realSize;i++)
            if(arr.get(i)!=null)
                arr.get(i).print();
        System.out.print("\n");
    }

    public boolean addProduct(BabyProduct product) {
        boolean res = false;

        if(product != null && realSize < size) {
            arr.add(product);

            realSize++;
            res = true;
        }

        return res;
    }
   /* void serchAge( int age) {
        BabyProduct[] serched=new BabyProduct[realSize];
        int k=0;
        for (int i = 0; i<realSize;i++)
        {
            if(arr[i].getMinAge()<=age && arr[i].getMaxAge()>=age)
            {
                serched[k] = arr[i];
                k++;
            }
        }
        realSize=k;
        this.arr=serched;
    }*/
    /*
    class InnerSort implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            BabyProduct a1 = (BabyProduct) o1;
            BabyProduct a2 = (BabyProduct) o2;

            return a1.getPrice().compareTo(a2.getPrice());
        }
    }

    static class StaticInnerSort implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Aquarium a1 = (Aquarium) o1;
            Aquarium a2 = (Aquarium) o2;

            return a2.getAnimal().getClass().getSimpleName().compareTo(a1.getAnimal().getClass().getSimpleName());
        }
    }
    void swap( int i, int j)
    {
        BabyProduct temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int partitioninIncreasingPrice(int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].getPrice() < pivot.getPrice())
            {
                i++;
                swap( i, j);
            }
        }
        swap( i + 1, high);
        return (i + 1);
    }

    int partitioninDecreasingPrice( int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].getPrice() > pivot.getPrice())
            {
                i++;
                swap( i, j);
            }
        }
        swap( i + 1, high);
        return (i + 1);
    }
    int partitioninDecreasingAlphabet(int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if  (arr[j].getName().compareTo(pivot.getName()) > 0)
            {
                i++;
                swap( i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }

    int partitioninIncreasingAlphabet(int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if  (arr[j].getName().compareTo(pivot.getName()) < 0)
            {
                i++;
                swap( i, j);
            }
        }
        swap( i + 1, high);
        return (i + 1);
    }

    public void quickSort( int low, int high, int sortType)
    {
        if (low < high)
        {
            int pi=0;
            if(sortType==3)
                pi = partitioninIncreasingAlphabet(low,high);
            if(sortType==4)
                pi = partitioninDecreasingAlphabet( low, high);
            if(sortType==5)
                pi = partitioninIncreasingPrice(low, high);
            if(sortType==6)
                pi = partitioninDecreasingPrice(low, high);
            quickSort(low, pi - 1,sortType);
            quickSort(pi + 1, high,sortType);
        }
    }

     */

}
