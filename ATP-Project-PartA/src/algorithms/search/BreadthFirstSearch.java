package algorithms.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

    public class BreadthFirstSearch extends  ASearchingAlgorithm {


        public AState solve(ISearchable search)
        {
            AState startVert = search.getStartState();//first node
            AState endVert = search.getGoalState();
            AState current=startVert;

            LinkedList<String> queue1n=new LinkedList<>() ;//the regular queue like in BFS
            LinkedList<String> queue2n=new LinkedList<>() ;//the regular queue like in BFS
            queue2.add(current);
            queue2n.add(current.PrintCurrentPos());

           while (!current.PrintCurrentPos().equals(endVert.PrintCurrentPos()))
           {

               for(int i=0 ;i<search.getAllSuccessors(current).size();i++)
               {
                   AState v = search.getAllSuccessors(current).get(i);
                   if(!queue1n.contains(v.PrintCurrentPos()) && !queue2n.contains(v.PrintCurrentPos()))
                   {
                       queue1n.add(v.PrintCurrentPos());
                       queue1.add(v);
                       v.setCamefrom(current);
                   }

               }
               current=PopOpenList();
               String out=queue1n.remove(0);
               queue2n.add(current.PrintCurrentPos());
           }
            System.out.println("keren");




            // create the path
//            LinkedList<AState> path = new LinkedList<>();
//            path.addFirst(current);
//            while (current != startVert) {
//                current = visited.get(current);
//                path.addFirst(current); // addFirst is used to get the correct order
//                current.PrintCurrentPos();
//            }
//            System.out.println("is stupid");

            return search.getGoalState();
        }
    }


