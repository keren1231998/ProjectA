package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;

public  class Solution
{
    ArrayList<AState> path = new ArrayList<>();

    AState last;
    AState start;

    public void setLast(AState last) {
        this.last = last;
    }

    public AState getLast() {
        return last;
    }

    public AState getStart() {
        return start;
    }

    public void setStart(AState start) {
        this.start = start;
    }

    public ArrayList<AState> getSolutionPath()
    {
        while (!last.toString().equals(start.toString())) {
            path.add(last);
            last = last.getCamefrom();
        }
            path.add(start);
        return path;
    }
}
