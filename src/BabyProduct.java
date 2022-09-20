import java.util.Comparator;

public class BabyProduct {

    private String name;
    private int expirationDate;
    private int minage;
    private int maxage;
    private int price;

    BabyProduct()
    {}
    BabyProduct(String name, int expirationDate,int minage,int maxage,int price)
    {
        this.name=name;
        this.expirationDate=expirationDate;
        this.minage=minage;
        this.maxage=maxage;
        this.price=price;
    }
    void print()
    {
        System.out.print(name + " ");
        System.out.print(expirationDate+ " ");
        System.out.print(minage+ " ");
        System.out.print(maxage+ " ");
        System.out.println(price);
    }
    String getName()
    {
        return this.name;
    }

    int getDate()
    {
        return this.expirationDate;
    }

    int getMinAge()
    {
        return this.minage;
    }
    int getMaxAge()
    {
        return this.maxage;
    }
    int getPrice()
    {
        return this.price;
    }

}

class BabyCloth extends BabyProduct
{
    String gender;
    String season;
    int size;
}

class BabyShoes extends BabyProduct
{
    String gender;
    String season;
    int size;
}

class BabyToys extends BabyProduct
{
    boolean isSafety;
    String brand;
}

