package algorithms.search;

import java.util.ArrayList;

public abstract  class AState
{
    private String state;//return string of the current position
    private double cost;
    private AState camefrom;


    abstract void PrintCurrentPos();


}
