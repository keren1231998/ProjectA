package algorithms.mazeGenerators;
import java.util.*;

public class MyMazeGenerator extends AMazeGenerator
{

    public MyMazeGenerator() {}

    /**
     * We use this function to build a maze with ones
     * @param row
     * @param column
     * @return Position[][]
     */
    public Position[][] BuildMaze(int row,int column)
    {
        Position [][] maze=new  Position[row][column];

        int i,j;
        for(i=0;i<row;i++)//maze full of "1"
            for(j=0;j<column;j++)
            {
                maze[i][j]=new Position(i,j);
                maze[i][j].setValue(1);
                maze[i][j].setCheck();
            }

        return maze;
    }

    /**
     * This function add all neighbors to a list of the start Position
     * @param maze
     * @param start
     * @param neighbors
     */
    public void checkneighbors(Position [][] maze,Position start,ArrayList<Position> neighbors )
    {
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (maze[start.row + x][start.column + y].getValue() == 0) continue;
                } catch (Exception e) {
                    continue;
                }

                Position p1=new Position(start.row + x, start.column + y);
                p1.counter++;
                neighbors.add(p1);
            }
    }

    /**
     * This function return the origin values of the walls to 1
     * @param maze
     * @param row
     * @param column
     */
    public void changevalue(Position[][]maze,int row,int column)
    {
        int i,j;
        for(i=0;i<row;i++)
            for(j=0;j<column;j++)
                if(maze[i][j].getValue()==5)
                {
                    maze[i][j].setValue(1);
                    maze[i][j].setCheck();
                }

    }

    /**
     * This function generate the maze with Prim's algorithm
     * @param row
     * @param column
     * @return Maze
     */
    @Override
    public Maze generate(int row, int column)
    {
        ArrayList<Position> neighbors =new ArrayList<Position>();
        ArrayList<Position> visited =new ArrayList<Position>();
        Random random = new Random();

        Position[][] maze=BuildMaze(row,column);

        Position start = new Position((int) (0), (int) (Math.random() * column));
        visited.add(new Position(start.row , start.column ));
        maze[start.row][start.column].setValue(0);
        maze[start.row][start.column].setChecktofalse();
        Position end=new Position(row-1,column-1);

        checkneighbors(maze,start,neighbors);


        int counter=0;
        while (!neighbors.isEmpty()) {
            int k;
            counter=0;
            Position cu=neighbors.get(random.nextInt(neighbors.size()));
            if (cu.counter<=1&& maze[cu.row][cu.column].getValue()==1)
            {
                neighbors.remove((cu));
                maze[cu.row][cu.column].setValue(0);
                maze[cu.row][cu.column].setChecktofalse();
                visited.add(new Position(cu.row , cu.column ));
            }
            try {
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0 || x != 0 && y != 0)
                            continue;
                        try {
                            if(maze[cu.row+x][cu.column+y].getValue()==0) continue;

                        } catch (Exception e) {
                            continue;
                        }

                        Position p1=new Position(cu.row + x, cu.column + y);
                        for(k=0;k<neighbors.size();k++)
                            if(neighbors.get(k).row== p1.row && neighbors.get(k).column== p1.column)
                            {
                                maze[p1.row][p1.column].setValue(5);
                                neighbors.remove(neighbors.get(k));
                            }

                        if( maze[p1.row][p1.column].getValue()!=5)
                        {
                            neighbors.add(p1);
                            p1.counter++;
                        }
                    }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        changevalue(maze,row,column);
        maze[end.row][end.column].setValue(0);
        maze[end.row][end.column].setChecktofalse();

        Maze maze1=new Maze(start,end,maze);
        return maze1;
    }

}