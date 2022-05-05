package algorithms.mazeGenerators;

public class Position
{
    int row;
    int column;
    int value;

    int counter=0;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.counter=0;
    }
    public void setValue(int value){this.value=value;}

    public int getValue(){return this.value;}

    public int getRowIndex() {
        return this.row;
    }

    public int getColumnIndex()
    {
        return this.column;
    }

    public String toString() {
        return "(" + getRowIndex() + "," + getColumnIndex()+")";
    }


}
