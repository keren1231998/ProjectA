package algorithms.mazeGenerators;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Maze implements Serializable {
    private Position x=new Position(0,0);
    private Position y=new Position(0,0);
    private Position[][] maze;

    public Maze(byte[] decompressedMaze)
    {


        this.y.row = ((decompressedMaze[1] & 0xff) << 8) | (decompressedMaze[0] & 0xff)-1;
        this.y.column = ((decompressedMaze[3] & 0xff) << 8) | (decompressedMaze[2] & 0xff)-1;
        int count = 4;

        maze = new Position[y.row +1][y.column+1 ];

        for (int i = 0; i < this.y.row+1; i++) {
            for (int j = 0; j < this.y.column+1 ; j++)
            {
                maze[i][j] = new Position(i,j);
                maze[i][j].setValue(decompressedMaze[count]);
                count++;
            }
        }
        this.x.row = ((decompressedMaze[count] & 0xff) << 8) | (decompressedMaze[++count] & 0xff);
        int tenp = decompressedMaze[count+2];
        int temp1 = decompressedMaze[++count];
        this.x.column = ((tenp & 0xff) << 8) | ( temp1 & 0xff);
    }
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

    public byte[] toByteArray()
    {

        ByteArrayOutputStream barr = new ByteArrayOutputStream();

        byte[] bytearray = new byte[((y.row+1)*(y.column+1)+4+4+4)];

        bytearray[0] = (byte) (getGoalPosition().row +1 & 0xFF);
        bytearray[1] = (byte) ((getGoalPosition().row +1 >> 8) & 0xFF);

        bytearray[2] = (byte) (getGoalPosition().column +1 & 0xFF);
        bytearray[3] = (byte) ((getGoalPosition().column +1 >> 8) & 0xFF);


        int count=4;
        for (int i = 0; i < this.y.row+1; i++) {
            for (int j = 0; j < this.y.column + 1; j++) {
                bytearray[count] = (byte) maze[i][j].getValue();
                count++;
            }
        }

        //BigInteger bg3 = BigInteger.valueOf(getStartPosition().row);
        //if(getStartPosition().row>127)
            //from_BigInt(getStartPosition().row,barr);
        //else{barr.write(bg3.byteValue());}
        bytearray[count] = (byte) (getStartPosition().row & 0xFF);
        bytearray[++count] = (byte) ((getStartPosition().row >> 8) & 0xFF);

        bytearray[++count] = (byte) (getStartPosition().column & 0xFF);
        bytearray[++count] = (byte) ((getStartPosition().column >> 8) & 0xFF);

        bytearray[++count] = (byte) (getGoalPosition().row & 0xFF);
        bytearray[++count] = (byte) ((getGoalPosition().row >> 8) & 0xFF);

        bytearray[++count] = (byte) (getGoalPosition().column & 0xFF);
        bytearray[++count] = (byte) ((getGoalPosition().column >> 8) & 0xFF);

        int temp = bytearray.length;
        /*BigInteger bg4 = BigInteger.valueOf(getStartPosition().column);
        if(getStartPosition().column>127)
            from_BigInt(getStartPosition().column,barr);
        else{barr.write(bg4.byteValue());}*/


        /*BigInteger bg5 = BigInteger.valueOf(getGoalPosition().row);
        if(getGoalPosition().row>127)
            from_BigInt(getGoalPosition().row,barr);
        else{barr.write(bg5.byteValue());}

        BigInteger bg6 = BigInteger.valueOf(getGoalPosition().column);
        if(getGoalPosition().column>127)
            from_BigInt(getGoalPosition().column,barr);
        else{barr.write(bg6.byteValue());}

        byte[] targetArray = barr.toByteArray();;*/
        return bytearray;
    }

    /**
     * In this function we print the maze
     * @return void
     */

    public void from_BigInt(int y,ByteArrayOutputStream barr)
    {

        int temp = y/127;
        for(int i=0; i<temp;i++) {
            BigInteger bg = BigInteger.valueOf(127);
            barr.write(bg.byteValue());
        }
        if((y+1 - temp*127) != 0 )
            barr.write(y+1 - temp*127);
    }
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
}