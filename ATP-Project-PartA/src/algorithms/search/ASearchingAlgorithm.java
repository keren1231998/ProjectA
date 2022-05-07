package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{


    protected LinkedList<AState> adj = new LinkedList<>();
    protected HashSet<String> setofpositions = new HashSet<>();

    private int visitedNodes;//number of nodes from Start to End

    public ASearchingAlgorithm(){
        visitedNodes=0;

    }
    public void setLinkedlist(LinkedList<AState> a1)
    {
        this.adj=a1;
    }

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




}