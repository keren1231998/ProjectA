package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public abstract  class AState
{

    private String state;//return string of the current position
    private double cost;
    private AState camefrom;



    abstract String PrintCurrentPos();

    public void setCamefrom(AState camefrom) {
        this.camefrom = camefrom;
    }
}
