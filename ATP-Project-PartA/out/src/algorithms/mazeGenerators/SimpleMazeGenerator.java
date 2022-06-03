package algorithms.mazeGenerators;
import java.util.Random;
public class SimpleMazeGenerator extends AMazeGenerator
{
    /**
     * This function generate randomized maze
     * @param row
     * @param column
     * @return Maze
     */
    @Override
    public Maze generate(int row, int column)
    {
        Random rand=new Random();
        Position [][] maze=new  Position[row][column];
        Position start = new Position((int) (0), (int) (Math.random() * column));
        Position end=new Position(row-1,column-1);
        int i,j;

        for(i=0;i<row;i++)
            for (j = 0; j < column; j++)
            {
                maze[i][j] = new Position(i,j);
                maze[i][j].value=rand.nextInt(2);
            }
        for(i=0;i<row;i++)
            maze[i][start.column].value=0;
        for(i=start.column;i<column;i++)
            maze[row-1][i].value=0;

        Maze maze1 =new Maze(start,end,maze);
        return maze1;
    }

}