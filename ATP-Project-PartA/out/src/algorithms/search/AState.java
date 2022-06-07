package algorithms.search;

import java.io.Serializable;

public abstract  class AState implements Serializable
{

    private String state;
    private double cost;
    private AState camefrom;



    public abstract String toString();

    /**
     *
     * @param camefrom
     */

    public void setCamefrom(AState camefrom) {
        this.camefrom = camefrom;
    }

    /**
     *
     * @return Astate
     */
    public AState getCamefrom(){return this.camefrom;}

    public double getCost(){return this.cost;}

    /**
     * This function set the value of neighbors that are in the left|up|right|down from s1
     * @param s1
     */
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

    /**
     * This function set the value of neighbors that are diagonal from s1
     * @param s1
     */
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