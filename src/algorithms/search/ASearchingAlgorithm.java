package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{


    protected ArrayList<AState> adj = new ArrayList<>();

    private int visitedNodes;//number of nodes from Start to End

    public ASearchingAlgorithm(){
        visitedNodes=0;

    }

    public  void PopOpenList(){
        visitedNodes++;
    }

    public int getNumberOfNodesEvaluated(){
        return visitedNodes;
    }

    @Override
    public AState solve(ISearchable search) {
        return null;
    }


}