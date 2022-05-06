package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch{

    public BestFirstSearch()
    {this.queue = new PriorityQueue<>(new AStateComparator());}


    @Override
    public Solution solve(ISearchable search) {
        return super.solve(search);
    }
}


