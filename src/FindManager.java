import java.util.ArrayList;

public class FindManager {

    public static  void serchAge( BabyProductListManager manager, int age) {
        ArrayList<BabyProduct> serched=new ArrayList<BabyProduct>();
        int k=0;
        for (int i = 0; i<manager.getRealSize();i++)
        {
            if(manager.getArr().get(i).getMinAge()<=age && manager.getArr().get(i).getMaxAge()>=age)
            {
                serched.add(manager.getArr().get(i));
                k++;
            }
        }
        manager.setRealSize(k);
        manager.setArr(serched);
    }
}
