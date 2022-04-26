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

    public Position opposite(Position parent) {
        int x;
        if(this.row!=parent.row)
        {
            if(this.row> parent.row)
                return new Position(this.row+1,this.column);
            else
                return new Position(this.row-1,this.column);
        }
        if(this.column!=parent.column)
        {
            if(this.column> parent.column)
                return new Position(this.row,this.column+1);
            else
                return new Position(this.row,this.column-1);
        }

        return null;
    }
}
