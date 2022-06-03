package algorithms.search;
import java.util.Stack;
import java.util.LinkedList;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    /**
     *
     * @return String
     */
    public  String  getName()
    {
        String str="DepthFirstSearch";
        return str;
    }


    Stack<AState> stack = new Stack<AState>();
    LinkedList<AState> visited = new LinkedList<>();

    /**
     * This function solve the maze with DepthFirstSearch
     and sending tp the super solve.
     * @param search
     * @return Solution
     */
    public Solution solve(ISearchable search)
    {
        if (search == null)
            return null;

        AState startVert = search.getStartState();
        AState endVert = search.getGoalState();
        visited.add(startVert);
        adj=search.getAllPossibleStates(startVert);
        for(int i=0 ;i<adj.size();i++)
        {
            adj.get(i).setCamefrom(startVert);
            stack.push((adj.get(i)));
        }

        while (!stack.isEmpty())
        {

            AState out=stack.pop();
            visited.add(out);//pop the top element and insert to visited
            LinkedList<AState> templist = new LinkedList<>();
            templist=search.getAllPossibleStates(out);
            for(int i=0;i<templist.size();i++)
            {
                templist.get(i).setCamefrom(out);
                stack.push(templist.get(i));

            }
        }
        search.fixfunc();
        this.setvisitednodes(visited.size());//number of node the algo gave


        for(int i=0;i<visited.size();i++)
        {
            if(endVert.toString().equals(visited.get(i).toString())){
                AState last =  visited.get(i);
                Solution s1=new Solution();
                s1.setLast(last);
                s1.setStart(startVert);
                return s1;
            }

        }
        return null;
    }
}