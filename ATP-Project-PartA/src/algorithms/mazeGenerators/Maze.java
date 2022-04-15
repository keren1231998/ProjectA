package algorithms.mazeGenerators;

public class Maze
{
   private final Position x;
   private final Position y;
   private final int[][] maze;

    public Maze(Position x, Position y, int[][] maze) {
        this.x = x;
        this.y = y;
        this.maze = maze;
    }

    public Position getStartPosition()
     {
        return new Position(0,0);
     }
     public Position getGoalPosition()
     {
        return  new Position(this.y.row,this.y.column);
     }

     //print the Maze
    public void print()
     {
         int i,j;
         System.out.print("{ "+ "S"+" ");
         for(i=1;i<this.y.column;i++)
             System.out.print(maze[0][i]+" ");
         System.out.print("}");
         System.out.print("\n");

         for(i=1;i<this.y.row-1;i++)
         {
             System.out.print("{ ");
             for(j=0;j<this.y.column;j++)
             {
                 System.out.print(maze[i][j] + " ");
             }
             System.out.print("}");
             System.out.println();
         }

         System.out.print("{ ");
         for(i=0;i<this.y.column-1;i++)
             System.out.print(maze[this.y.column-1][i]+" ");
         System.out.print("E"+" }");
     }
}

