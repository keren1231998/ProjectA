package algorithms.mazeGenerators;

public class Maze {
    private  final  Position x;
    private final Position y;
    private final Position[][] maze;

    public Maze(Position x, Position y, Position[][] maze) {

        this.x = x;
        this.y = y;
        this.maze = maze;
        if (y.column < 2 & y.row < 2) {
            System.out.println("The size of the maze is less than 2X2");
        }

    }


    public Position getStartPosition() {
        return x;
    }

    public Position getGoalPosition() {
        return y;
    }
    public Position GetCellCalue(int row, int column)
    {

        return maze[row][column];
    }

    public Position[][] getMaze() {
        return maze;
    }

    //print the Maze
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