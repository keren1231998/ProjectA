package algorithms.mazeGenerators;

public class Maze {
    private final Position x;
    private final Position y;
    private final int[][] maze;

    public Maze(Position x, Position y, int[][] maze) {

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

    //print the Maze
    public void print() {

        int i, j;
        for (i = 0; i < this.y.row; i++) {
            System.out.print("{ ");
            for (j = 0; j < this.y.column; j++) {

                if (i == x.row && j == x.column) {
                    System.out.print("S ");
                } else {
                    if (i == y.row-1 && j == y.column-1)
                        System.out.print("E ");
                    else
                        System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}