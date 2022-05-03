package algorithms.search;
import java.util.*;


public class AStateComparator implements Comparator<AState>{
    @Override
    public int compare(AState o1, AState o2) {
        if(o1.getCost() < o2.getCost()) {return 1;}
        else if(o1.getCost() > o2.getCost()) {return -1;}
        return 0;
    }

}
