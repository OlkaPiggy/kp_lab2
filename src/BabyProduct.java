

public class BabyProduct {

    String name;
    int expirationDate;
    int minage;
    int maxage;

    BabyProduct()
    {}
    BabyProduct(String name, int expirationDate,int minage,int maxage)
    {
        this.name=name;
        this.expirationDate=expirationDate;
        this.minage=minage;
        this.maxage=maxage;
    }
    void print()
    {
        System.out.print(name + " ");
        System.out.print(expirationDate+ " ");
        System.out.print(minage+ " ");
        System.out.println(maxage);
    }
}

