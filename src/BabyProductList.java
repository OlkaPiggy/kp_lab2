/*Дитячий магазин. Реалізувати ієрархію засобів догляду за немовлятами, які є в
        дитячому магазині. Врахувати, що товари мають різний термін придатності і
        розраховані на різні вікові категорії. Здійснити пошук товарів, які можна
        використати для дитини певного віку.
        Реалізувати можливість сортування знайдених товарів за двома типами
        параметрів (на вибір, реалізовано як два окремі методи)
        Реалізація сортування має передбачати можливість сортувати як за спаданням,
        так і за зростанням*/


public class BabyProductList {

    public BabyProduct[] arr;
    public int realSize;

    BabyProductList(BabyProduct[] arr,int realSize)
    {
        this.arr=arr;
        this.realSize=realSize;
    }
    void print()
    {
        for(int i=0;i<realSize;i++)
            if(arr[i]!=null)
                arr[i].print();
        System.out.print("\n");
    }
    void serchAge( int age) {
        BabyProduct[] serched=new BabyProduct[realSize];
        int k=0;
        for (int i = 0; i<realSize;i++)
        {
            if(arr[i].minage<=age && arr[i].maxage>=age)
            {
                serched[k] = arr[i];
                k++;
            }
        }
        realSize=k;
        this.arr=serched;
    }

    void swap( int i, int j)
    {
        BabyProduct temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int partitioninIncreasingDate(int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].expirationDate < pivot.expirationDate)
            {
                i++;
                swap( i, j);
            }
        }
        swap( i + 1, high);
        return (i + 1);
    }

    int partitioninDecreasingDate( int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].expirationDate > pivot.expirationDate)
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
            if  (arr[j].name.compareTo(pivot.name) > 0)
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
            if  (arr[j].name.compareTo(pivot.name) < 0)
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
                pi = partitioninIncreasingDate(low, high);
            if(sortType==6)
                pi = partitioninDecreasingDate(low, high);
            quickSort(low, pi - 1,sortType);
            quickSort(pi + 1, high,sortType);
        }
    }

}
