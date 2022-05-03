package algorithms.search;

import java.util.LinkedList;

public interface ISearchingAlgorithm
{
    public int getNumberOfNodesEvaluated();
    public AState solve(ISearchable search);
}