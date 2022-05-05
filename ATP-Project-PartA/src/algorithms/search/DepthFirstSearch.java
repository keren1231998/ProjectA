package algorithms.search;
import java.util.Stack;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Random;

public class DepthFirstSearch extends ASearchingAlgorithm
{


    Stack<AState> stack = new Stack<AState>();
    LinkedList<AState> visited = new LinkedList<>();
    public AState solve(ISearchable search)
    {
        AState startVert = search.getStartState();//first node
        AState endVert = search.getGoalState();
        visited.add(startVert);//add first node to visited
        adj=search.getAllSuccessors(startVert);//get successor of start point
        for(int i=0 ;i<adj.size();i++)
        {
            adj.get(i).setCamefrom(startVert);
            stack.push((adj.get(i)));
        }

        while (!stack.isEmpty())
        {

            AState out=stack.pop();
            visited.add(out);//pop the top element and insert to visited

            for(int i=0;i<search.getAllSuccessors(out).size();i++)
            {
                if(!visited.contains(search.getAllSuccessors(out).get(i).PrintCurrentPos()) && !stack.contains(search.getAllSuccessors(out).get(i).PrintCurrentPos()) )
                {
                    search.getAllSuccessors(out).get(i).setCamefrom(out);
                    stack.push(search.getAllSuccessors(out).get(i));
                }
            }
        }

        for(int i=0;i<visited.size();i++)
        {
            if(endVert.PrintCurrentPos().equals(visited.get(i).PrintCurrentPos())){
                return visited.get(i);
            }

        }
        return null;
    }
}
