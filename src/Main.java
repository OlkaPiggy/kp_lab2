import java.io.*;
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
        BabyProduct[] arr=new BabyProduct[10];
        int written = 0;
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("What data to use?");
            System.out.println("1) automatic data\n2) read from file\n3) enter yourself\n");
            int choose = in.nextInt();

            if (choose == 1) {
                arr[0] = new BabyProduct("cloth", 5, 6, 7);
                arr[1] = new BabyProduct("shoes", 7, 1, 10);
                arr[2] = new BabyProduct("toy1", 2, 1, 12);
                arr[3] = new BabyProduct("kkk", 8, 3, 14);
                arr[4] = new BabyProduct("wetz", 4, 3, 18);
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
                        arr[written] = new BabyProduct(nameRead, dateRead, minaAgeRead, maxAgeRead);
                        written++;
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            }
            else if (choose == 3) {
                break;
            }
            else
                System.out.println("Wrong input");
        }

        //to do with
        BabyProductList list = new BabyProductList(arr,written);
        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("1) print list\n2) find products for a certain age\n3) sort by names in ascending order");
            System.out.println("4) sort by names in descending order\n5) sort by expiration date in ascending order\n6) sort by expiration date in descending order\n");
            int choose = in.nextInt();

            if (choose == 1)
                list.print();
            else if(choose==2)
            {
                System.out.println("Which age? ");
                int age=in.nextInt();
                list.serchAge( age);
                list.print();
            }
            else if(choose==3) {
                list.quickSort(0,list.realSize -1,choose);
                list.print();
            }
            else if(choose==4) {
                list.quickSort(0, list.realSize-1,choose);
                list.print();
            }
            else if(choose==5) {
                list.quickSort(0, list.realSize-1, choose);
                list.print();
            }
            else if(choose==6) {
                list.quickSort(0, list.realSize-1,choose);
                list.print();
            }
            else
                break;

        }


        in.close();
    }
}