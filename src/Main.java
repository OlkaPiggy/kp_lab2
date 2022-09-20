import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<BabyProduct> arr=new ArrayList<BabyProduct>();
        int written = 0;
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("What data to use?");
            System.out.println("1) automatic data\n2) read from file\n");
            int choose = in.nextInt();

            if (choose == 1) {
                arr.add( new BabyProduct("cloth", 5, 6, 7,500));
                arr.add( new BabyProduct("shoes", 7, 1, 10,250));
                arr.add( new BabyProduct("toy1", 2, 1, 12,1300));
                arr.add( new BabyProduct("kkk", 8, 3, 14,500));
                arr.add( new BabyProduct("wetz", 4, 3, 18,700));
                written = 5;
                break;
            }
            else if (choose == 2) {
                //  read from file
                try {
                    File myObj = new File("read.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String[] words = data.split(" ");
                        String nameRead = words[0];
                        int dateRead = Integer.parseInt(words[1]);
                        int minaAgeRead = Integer.parseInt(words[2]);
                        int maxAgeRead = Integer.parseInt(words[3]);
                        int price=Integer.parseInt(words[4]);
                        arr.add( new BabyProduct(nameRead, dateRead, minaAgeRead, maxAgeRead,price));
                        written++;
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            }
            else
                System.out.println("Wrong input");
        }

        //to do with
        BabyProductListManager list = new BabyProductListManager(arr,written);
        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("1) print list\n2) find products for a certain age\n3) sort by names in ascending order");
            System.out.println("4) sort by names in descending order\n5) sort by expiration date in ascending order\n6) sort by expiration date in descending order\n");
            int choose = in.nextInt();

            if (choose == 1)
                list.print();
            else if(choose==2)
            {
                FindManager find =new FindManager();
                System.out.println("Which age? ");
                int age=in.nextInt();
                FindManager.serchAge(list, age);
                list.print();
            }
            else if(choose==3) {
                SortManager sort= new SortManager();
                list.setArr(sort.sortAlphabetEncreasing(list.getArr()));
                list.print();
            }
            else if(choose==4) {
                SortManager sort= new SortManager();
                list.setArr(sort.sortAlphabetDecreasing(list.getArr()));
                list.print();
            }
            else if(choose==5) {
                list.setArr(SortManager.sortPriceIncreasing(list.getArr()));
                list.print();
            }
            else if(choose==6) {
                list.setArr(SortManager.sortPriceDecreasing(list.getArr()));
                list.print();
            }
            else
                break;

        }


        in.close();
    }
}