package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator
{

    @Override
    /**
     * This function generate an Empty Maze, a maze with zeroes.
     * @param row
     * @param column
     * @return maze
     */
    public Maze generate(int row, int column)
    {
        Position [][] maze=new Position[row][column];
        int i,j;
        for(i=0;i<row;i++)
            for (j = 0; j < column; j++){
                maze[i][j] = new Position(i,j);
                maze[i][j].value=0;
            }


        Position start=new Position(0,0);
        Position end=new Position(row-1,column-1);
        Maze maze1 =new Maze(start,end,maze);
        return maze1;
    }
}