package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ASearchingAlgorithm implements ISearchingAlgorithm{

   // HashMap<AState, AState> visited=new HashMap<>() ;
   LinkedList<String> queue1n=new LinkedList<>() ;//the regular queue like in BFS
    LinkedList<String> queue2n=new LinkedList<>() ;//the regular queue like in BFS
   LinkedList<AState> queue2=new LinkedList<>() ;//the regular queue like in BFS
    LinkedList<AState> queue1=new LinkedList<>() ;//the regular queue like in BFS
    private int visitedNodes;//number of nodes from Start to End

    public ASearchingAlgorithm(){
        visitedNodes=0;
    }

    public  AState PopOpenList(){
        visitedNodes++;
        AState a1=queue1.remove(0);
        queue2.add(a1);
        return a1;
    }

    public int getNumberOfNodesEvaluated(){
        return visitedNodes;
    }

    @Override
    public AState solve(ISearchable search) {
        return null;
    }


}
