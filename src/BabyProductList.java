/*Дитячий магазин. Реалізувати ієрархію засобів догляду за немовлятами, які є в
        дитячому магазині. Врахувати, що товари мають різний термін придатності і
        розраховані на різні вікові категорії. Здійснити пошук товарів, які можна
        використати для дитини певного віку.
        Реалізувати можливість сортування знайдених товарів за двома типами
        параметрів (на вибір, реалізовано як два окремі методи)
        Реалізація сортування має передбачати можливість сортувати як за спаданням,
        так і за зростанням*/


public class BabyProductList {

    void print(BabyProduct[] arr)
    {
        for(int i=0;i<arr.length;i++)
            if(arr[i]!=null)
                arr[i].print();
    }
    BabyProduct[] serchAge(BabyProduct[] arr, int age) {
        BabyProduct[] serched=new BabyProduct[arr.length];
        int k=0;
        for (int i = 0; i<arr.length;i++)
        {
            if(arr[i].minage<=age && arr[i].maxage>=age)
            {
                serched[k] = arr[i];
                k++;
            }
        }
        return serched;
    }

    void swap(BabyProduct[] arr, int i, int j)
    {
        BabyProduct temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int partitioninIncreasingDate(BabyProduct[] arr, int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].expirationDate < pivot.expirationDate)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    int partitioninDecreasingDate(BabyProduct[] arr, int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j].expirationDate > pivot.expirationDate)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    int partitioninDecreasingAlphabet(BabyProduct[] arr, int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if  (arr[j].name.compareTo(pivot.name) > 0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    int partitioninIncreasingAlphabet(BabyProduct[] arr, int low, int high)
    {
        BabyProduct pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if  (arr[j].name.compareTo(pivot.name) < 0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public void quickSort(BabyProduct[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partitioninDecreasingAlphabet(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
