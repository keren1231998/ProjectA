package algorithms.mazeGenerators;

public class Position
{
    int row;
    int column;
    int counter=0;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.counter=0;
    }

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
