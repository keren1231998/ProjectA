package algorithms.mazeGenerators;

import java.io.Serializable;

public class Position implements Serializable
{
    int row;
    int column;
    int value;
    boolean check=false;

    int counter=0;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.counter=0;
    }
    public boolean getcheck(){return this.check;}
    public void setCheck(){this.check=true;}
    public void setChecktofalse(){this.check=false;}


    public void setValue(int value){this.value=value;}

    public int getValue(){return this.value;}

    public int getRowIndex() {
        return this.row;
    }

    public int getColumnIndex()
    {
        return this.column;
    }

    /**
     * This function return a String of the coordinates of the position
     * @return String
     */
    public String toString() {
        return "(" + getRowIndex() + "," + getColumnIndex()+")";
    }


}