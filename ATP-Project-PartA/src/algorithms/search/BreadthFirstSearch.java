package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends  ASearchingAlgorithm {


    protected Queue<AState> queue;

    public  BreadthFirstSearch(){
        this.queue = new LinkedList<>();
    }
    @Override
    public String getName() {
        String str="BreadthFirstSearch ";
        return str;
    }

    public Solution solve(ISearchable search)
    {
        AState startVert = search.getStartState();//first node
        AState endVert = search.getGoalState();
        AState current=startVert;

        setofpositions.add(current.toString());
        while (!current.toString().equals(endVert.toString()))
        {
            adj = search.getAllSuccessors(current);
            for(int i=0;i<adj.size();i++){
                ;
                if(!setofpositions.contains(adj.get(i).toString())){

                    setofpositions.add(adj.get(i).toString());
                    queue.add(adj.get(i));
                    adj.get(i).setCamefrom(current);
                    if(adj.get(i).toString().equals(endVert.toString())){
                        endVert.setCamefrom(current);
                    }
                }
            }

            current = queue.remove();
            PopOpenList();


        }
        search.fixfunc();
        Solution s1=new Solution();
        s1.setLast(endVert);
        s1.setStart(startVert);




        return s1;


    }



}
