package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ISearchable
{
    AState getStartState();
    AState getGoalState();
    LinkedList<AState> getAllPossibleStates(AState s);
    void fixfunc();
}