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
    public AState getCamefrom(){return this.camefrom;}

    public double getCost(){return this.cost;}

    public void setCostregular(AState s1)
    {
        if(s1==null)
        {
            double sizeoffather=0;
            this.cost=sizeoffather+1;
        }
        else
        {
            double sizeoffather=s1.getCost();
            this.cost=sizeoffather+1;
        }

    }
    public void setCostdiagonal(AState s1)
    {
        if(s1==null)
        {
            double sizeoffather=0;
            this.cost=sizeoffather+1.5;
        }
        else
        {
            double sizeoffather=s1.getCost();
            this.cost=sizeoffather+1.5;
        }

    }
}