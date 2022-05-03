package algorithms.search;
import java.io.*;
import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm {

    private Stack<AState> stack = new Stack<>();
//    private Stack<AState> closed = new Stack<>();

    @Override
    public AState solve(ISearchable search) {

        AState startVert = search.getStartState();//first node
        AState endVert = search.getGoalState();
        AState current = startVert;

        stack.add(startVert);

        //setofpositions.add(current.PrintCurrentPos());
        while (!current.PrintCurrentPos().equals(endVert.PrintCurrentPos())) {
            if (stack.isEmpty())
                break;

            current = stack.pop();
            adj = search.getAllSuccessors(current); //Get next possible states
            if(!this.setofpositions.contains(current.PrintCurrentPos()))
            {
//                closed.push(current);
                setofpositions.add(current.PrintCurrentPos());

            }

            Iterator<AState> x = adj.descendingIterator();

            while(x.hasNext())
            {
                AState temp = x.next();
                temp.setCamefrom(current);
                stack.push(temp);
                PopOpenList();
            }

//            AState temp = stack.pop();
//            PopOpenList();
//            setofpositions.add(temp.PrintCurrentPos());
//            adj = search.getAllSuccessors(temp);
//            for (int i = 0; i < adj.size(); i++) {
//                if (!setofpositions.contains(adj.get(i).PrintCurrentPos())) {
//                    stack.push(adj.get(i));
//                    adj.get(i).setCamefrom(temp);
//                }
//            }
        }

        ArrayList<String> path = new ArrayList<>();
        AState temp = endVert;
        while (!temp.PrintCurrentPos().equals(startVert.PrintCurrentPos())){
            path.add(temp.PrintCurrentPos());
            temp = temp.getCamefrom();
        }

        System.out.println(path);

        return endVert;
    }
}
//            for(int i=0;i<adj.size();i++){
//
//                //if(!setofpositions.contains(adj.get(i).PrintCurrentPos())){
//
//                    setofpositions.add(adj.get(i).PrintCurrentPos());
//                    queue.add(adj.get(i));
//                    adj.get(i).setCamefrom(current);
//                    if(adj.get(i).PrintCurrentPos().equals(endVert.PrintCurrentPos())){
//                        endVert.setCamefrom(current);



//            PopOpenList();
//            current = queue.remove();

//        }
//





