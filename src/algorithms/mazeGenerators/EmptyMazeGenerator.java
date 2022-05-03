package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    //creat empty maze
    public Maze generate(int row, int column) {
        int[][] maze = new int[row][column];
        int i, j;
        for (i = 0; i < row; i++)
            for (j = 0; j < column; j++)
                maze[i][j] = 0;

        Position start = new Position(0, 0);
        Position end = new Position(row, column);
        Maze maze1 = new Maze(start, end, maze);
        return maze1;
    }
}
