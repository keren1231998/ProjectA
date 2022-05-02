package algorithms.mazeGenerators;
import java.util.*;

public class MyMazeGenerator extends AMazeGenerator
{

    public MyMazeGenerator() {
    }
    public int[][] BuildMaze(int row,int column)
    {
        int [][] maze=new  int[row][column];
        int i,j;
        for(i=0;i<row;i++)//maze full of "1"
            for(j=0;j<column;j++)
                maze[i][j]=1;
        return maze;
    }

    public void checkneighbors(int [][] maze,Position start,ArrayList<Position> neighbors )
    {
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (maze[start.row + x][start.column + y] == 0) continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                Position p1=new Position(start.row + x, start.column + y);
                p1.counter++;
                neighbors.add(p1);//add all neighbors to the list
            }
    }

    public void changevalue(int[][]maze,int row,int column)
    {
        int i,j;
        for(i=0;i<row;i++)
            for(j=0;j<column;j++)
                if(maze[i][j]==5)
                    maze[i][j]=1;
    }


    @Override
    public Maze generate(int row, int column)
    {
        ArrayList<Position> neighbors =new ArrayList<Position>();//neighbors
        ArrayList<Position> visited =new ArrayList<Position>();
        Random random = new Random();

        int[][] maze=BuildMaze(row,column);//call function to build the maze

        Position start = new Position((int) (0), (int) (Math.random() * column));//random start point
        visited.add(new Position(start.row , start.column ));
        maze[start.row][start.column]=0;
        Position end=new Position(row-1,column-1);

        checkneighbors(maze,start,neighbors);//check all neighbors for start point


        int counter=0;
        while (!neighbors.isEmpty()) {
            int k,z;
            counter=0;

            Position cu=neighbors.get(random.nextInt(neighbors.size()));//get random number from the list of neighbors
            if (cu.counter<=1&& maze[cu.row][cu.column]==1)
            {
                neighbors.remove((cu));
                maze[cu.row][cu.column]=0;
                visited.add(new Position(cu.row , cu.column ));
            }
            try {
                        for (int x = -1; x <= 1; x++)
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0)
                                    continue;
                                try {
                                          if(maze[cu.row+x][cu.column+y]==0) continue;

                                } catch (Exception e) {
                                    continue;
                                }

                                Position p1=new Position(cu.row + x, cu.column + y);

                                for(k=0;k<neighbors.size();k++)
                                    if(neighbors.get(k).row== p1.row && neighbors.get(k).column== p1.column)
                                    {
                                        maze[p1.row][p1.column]=5;
                                        neighbors.remove(neighbors.get(k));
                                    }

                                if( maze[p1.row][p1.column]!=5)
                                {
                                    neighbors.add(p1);//add all neighbors to the list}
                                    p1.counter++;
                                }

                                }

            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }
        }
        changevalue(maze,row,column);



        Maze maze1=new Maze(start,end,maze);
        return maze1;
    }

}
