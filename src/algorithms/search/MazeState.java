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
    String PrintCurrentPos() {
        String str="("+getX()+","+getY()+")";
        return str;
    }




}