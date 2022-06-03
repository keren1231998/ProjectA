package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch{

    public BestFirstSearch()
    {this.queue = new PriorityQueue<>(new AStateComparator());}

    /**
     *
     * @return String
     */
    public String getName() {
        String str="BestFirstSearch ";
        return str;
    }




    /**
     * This function solve the maze with BestFirstSearch algorithm by override the Original Queue to Priority Queue
     and sending tp the super solve.
     * @param search
     * @return Solution
     */
    @Override
    public Solution solve(ISearchable search) {
        return super.solve(search);
    }
}

