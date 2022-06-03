package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{


    protected LinkedList<AState> adj = new LinkedList<>();
    protected HashSet<String> setofpositions = new HashSet<>();

    private int visitedNodes;

    public ASearchingAlgorithm(){
        visitedNodes=0;

    }
    public void setLinkedlist(LinkedList<AState> a1)
    {
        this.adj=a1;
    }

    /**
     * This function add to the visitNode that reflecting the anount of nodes we are visiting
     */
    public  void PopOpenList(){
        visitedNodes++;
    }
    public void setvisitednodes(int x){
        this.visitedNodes=x;
    }

    public int getNumberOfNodesEvaluated(){
        return visitedNodes;
    }

    @Override
    public abstract Solution solve(ISearchable search) ;
    public abstract String getName();


    public class AStateComparator implements Comparator<AState>{
        @Override
        /**
         * This function return an int of comparing between costs of AState
         * return int
         */
        public int compare(AState o1, AState o2) {
            if(o1.getCost() < o2.getCost()) {return -1;}
            else if(o1.getCost() > o2.getCost()) {return 1;}
            return 0;
        }

    }



}