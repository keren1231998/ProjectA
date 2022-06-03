package algorithms.search;

public interface ISearchingAlgorithm
{
    public int getNumberOfNodesEvaluated();
    public Solution solve(ISearchable search);
    public String  getName();

}