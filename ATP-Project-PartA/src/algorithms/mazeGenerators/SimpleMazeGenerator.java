package algorithms.mazeGenerators;
import java.util.Random;
public class SimpleMazeGenerator extends AMazeGenerator
{
    @Override
    public Maze generate(int row, int column)//S run on the first row randomly , and E is const on (row,column)
    {
        Random rand=new Random();
        Position [][] maze=new  Position[row][column];
        Position start = new Position((int) (0), (int) (Math.random() * column));
        Position end=new Position(row,column);
        int i,j;

        for(i=0;i<row;i++)
            for (j = 0; j < column-1; j++)
            {
                maze[i][j].value=rand.nextInt(2);
            }
        for(i=0;i<column;i++)
            maze[i][start.column].value=0;
        for(i=start.column;i<column;i++)
            maze[row-1][i].value=0;

        Maze maze1 =new Maze(start,end,maze);
        return maze1;
    }

}
