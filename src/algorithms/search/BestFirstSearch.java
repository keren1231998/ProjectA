package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch{

        private HashSet<String> setofpositions = new HashSet<>();
        private ArrayList<AState> adj = new ArrayList<>();
        public BestFirstSearch()
        {
            PriorityQueue<AState> pq=new PriorityQueue<AState>();
            this.queue=pq;
        }

        public AState solve(ISearchable search) {
            AState startVert = search.getStartState();//first node
            AState endVert = search.getGoalState();
            AState current = startVert;

            setofpositions.add(current.PrintCurrentPos());
            while (!current.PrintCurrentPos().equals(endVert.PrintCurrentPos())) {
                adj = search.getAllSuccessors(current);
                for (int i = 0; i < adj.size(); i++) {
                    ;
                    if (!setofpositions.contains(adj.get(i).PrintCurrentPos())) {

                        setofpositions.add(adj.get(i).PrintCurrentPos());
                        queue.add(adj.get(i));
                        adj.get(i).setCamefrom(current);
                        if (adj.get(i).PrintCurrentPos().equals(endVert.PrintCurrentPos())) {
                            endVert.setCamefrom(current);
                        }
                    }
                }
                PopOpenList();
                current = queue.remove();

            }

            ArrayList<String> path = new ArrayList<>();
            AState temp = endVert;
            while (!temp.PrintCurrentPos().equals(startVert.PrintCurrentPos())) {
                path.add(temp.PrintCurrentPos());
                temp = temp.getCamefrom();
            }
            System.out.println(path);


            return endVert;


        }
    }



