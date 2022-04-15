package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator
{
    @Override
    public Maze generate(int row, int column)
    {
        Random rand=new Random();
        int [][] maze=new  int[row][column];
        int i,j;
        for(i=0;i<row;i++)
            for (j = 0; j < column; j++)
            {
                maze[i][j]=rand.nextInt(2);
            }



        Position start=new Position(0,0);
        Position end=new Position(row,column);
        Maze maze1 =new Maze(start,end,maze);

        return maze1;
    }

}
