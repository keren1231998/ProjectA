package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import java.util.ArrayList;

public class SearchableMaze implements ISearchable
{
    Maze maze1;

    public SearchableMaze(Maze maze1) {
        this.maze1 = maze1;
    }

    @Override
    public AState getStartState()
    {
        Position start=maze1.getStartPosition();
        AState a1=new MazeState(start);
        return a1;
    }

    @Override
    public AState getGoalState() {
        Position end=maze1.getGoalPosition();
        AState a1=new MazeState(end);
        return a1;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s)
    {
        ArrayList<AState> neighbors =new ArrayList<AState>();//neighbors
        int row=((MazeState) s).getX();
        int column=((MazeState) s).getY();
        int rowmaze=maze1.getGoalPosition().getRowIndex();
        int colmaze=maze1.getGoalPosition().getColumnIndex();

        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++)
            {
                try {
                    if (row+x<0||row+x>rowmaze||column+y<0||column+y>colmaze||(row+x==row&&column+y==column)) continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                Position p1=new Position(row + x, column + y);
                AState a1=new MazeState(p1);

                neighbors.add(a1);//add all neighbors to the list
            }
        return neighbors;
    }
}