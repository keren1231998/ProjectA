package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    Position position;


    public MazeState(Position position) {
        this.position = position;
    }

    /**
     *
     * @return int
     */
    public int getX() {
        return position.getRowIndex();
    }

    /**
     *
     * @return int
     */
    public int getY() {
        return position.getColumnIndex();
    }

    /**
     * This function return a String of coordinates of the position
     * @return String
     */

    @Override
    public String toString() {
        String str="("+getX()+","+getY()+")";
        return str;
    }




}