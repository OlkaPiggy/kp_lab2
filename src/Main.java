
/*Дитячий магазин. Реалізувати ієрархію засобів догляду за немовлятами, які є в
        дитячому магазині. Врахувати, що товари мають різний термін придатності і
        розраховані на різні вікові категорії. Здійснити пошук товарів, які можна
        використати для дитини певного віку.
        Реалізувати можливість сортування знайдених товарів за двома типами
        параметрів (на вибір, реалізовано як два окремі методи)
        Реалізація сортування має передбачати можливість сортувати як за спаданням,
        так і за зростанням*/

public class Main {
    public static void main(String[] args) {
        System.out.println("lab2!");
        BabyProduct[] arr=new BabyProduct[5];

        //hardcode
        arr[0]=new BabyProduct("cloth",5,6,7);
        arr[1]=new BabyProduct("shoes",7,1,10);
        arr[2]=new BabyProduct("toy1",2,1,12);
        arr[3]=new BabyProduct("kkk",8,3,14);
        arr[4]=new BabyProduct("wetz",4,3,18);

        //  read from file


        BabyProductList list=new BabyProductList();
        list.quickSort(arr,0, arr.length-1);
        BabyProduct[] arr2= list.serchAge(arr,5);
        list.print(arr);
    }
}