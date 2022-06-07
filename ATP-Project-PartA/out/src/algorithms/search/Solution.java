package algorithms.search;
import java.io.Serializable;
import java.util.ArrayList;
public  class Solution implements Serializable
{
    ArrayList<AState> path = new ArrayList<>();
    ArrayList<AState> temp = new ArrayList<>();


    AState last;
    AState start;


    public void setLast(AState last) {
        this.last = last;
    }

    public AState getLast() {return last;}

    public AState getStart() {
        return start;
    }

    public void setStart(AState start) {
        this.start = start;
    }

    /**
     * This function returns the solution path we get from one of the algorithms
     * @return ArrayList<AState>
     */
    public ArrayList<AState> getSolutionPath()
    {
         while (!last.toString().equals(start.toString())) {
            temp.add(last);
            last = last.getCamefrom();
            if(last == null)
                return null;
        }
        temp.add(start);

        int j=0;
        for(int i=temp.size()-1; i>=0; i--) {
            path.add(temp.get(i));
            j++;
        }
        return path;
    }

}