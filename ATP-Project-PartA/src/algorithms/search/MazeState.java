package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import java.util.ArrayList;

public class MazeState extends AState
{
    Position position;


    public MazeState(Position position) {
        this.position = position;
    }

    public int getX() {
        return position.getRowIndex();
    }

    public int getY() {
        return position.getColumnIndex();
    }

    @Override
    void PrintCurrentPos() {
        System.out.println("("+getX()+","+getY()+")");
    }


}
