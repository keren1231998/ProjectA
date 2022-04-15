package algorithms.mazeGenerators;

public class Position
{
    int row;
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRowIndex() {
        return this.row;
    }

    int getColumnIndex()
    {
        return this.column;
    }

//    void print()
//    {
//        System.out.println(getRowIndex() +","+getColumnIndex());
//    }
}
