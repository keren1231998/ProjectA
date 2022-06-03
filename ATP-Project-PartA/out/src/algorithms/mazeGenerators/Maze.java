package algorithms.mazeGenerators;

import java.nio.ByteBuffer;

public class Maze {
    private Position x=null;
    private Position y=null;
    private Position[][] maze=null;

    /**
     * This is a Maze constructor.
     * @param x
     * @param y
     * @param maze
     */
    public Maze(Position x, Position y, Position[][] maze) {

        this.x = x;
        this.y = y;
        this.maze = maze;
        if (y.column < 2 & y.row < 2) {
            System.out.println("The size of the maze is less than 2X2");
        }

    }

    public Maze(byte[] decompressedMaze) {
    }

    /**
     * In this function we return the start Position
     * @return Position
     */
    public Position getStartPosition() {
        return x;
    }

    /**
     * In this function we return the Goal Position
     * @return Position
     */
    public Position getGoalPosition() {
        return y;
    }

    /**
     * In this function we return the cell Position
     * @return Position
     */
    public Position GetCellCalue(int row, int column)
    {
        return maze[row][column];
    }

    /**
     * In this function we return the maze
     * @return Position
     */
    public Position[][] getMaze() {
        return maze;
    }

    /**
     * In this function we print the maze
     * @return void
     */
    public void print() {

        int i, j;
        for (i = 0; i < this.y.row+1; i++) {
            System.out.print("{ ");
            for (j = 0; j < this.y.column+1; j++) {

                if (i == x.row && j == x.column) {
                    System.out.print("S ");
                } else {
                    if (i == y.row && j == y.column)
                        System.out.print("E ");
                    else
                        System.out.print(maze[i][j].getValue() + " ");
                }
            }
            System.out.println("}");
        }
    }
    //convert the details of the Maze to Byte array
    public byte[] toByteArray()
    {
        int counter=0;
        int[] IntArray=new int[this.y.getRowIndex()*this.y.getColumnIndex()];
        for(int i=0;i<this.y.getRowIndex();i++)//creat
            for(int j=0;j<this.y.getColumnIndex();j++)
            {
                IntArray[counter]=this.maze[i][j].getValue();
                counter++;
            }
        int xStart,yStart,xEnd,yEnd; // coordination of start and end points at the Maze
        xStart=this.x.getRowIndex();
        yStart=this.x.getRowIndex();
        xEnd=this.y.getRowIndex();
        yEnd=this.y.getColumnIndex();
        int size=this.y.getRowIndex()*this.y.getColumnIndex()+12;
        int row=this.y.getRowIndex();
        byte[] b1= ByteBuffer.allocate(2).putInt(row).array();

        int column=this.y.getColumnIndex();
        Byte[] ByteArray=new Byte[size];
//        for(int i=12;i<this.y.getRowIndex()*this.y.getColumnIndex();i++)
//        {
//
//
//        }




        return null;
    }

}