package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.io.Serializable;
import java.util.LinkedList;

public class SearchableMaze implements ISearchable , Serializable
{
    Maze maze1;

    public SearchableMaze(Maze maze1) {
        this.maze1 = maze1;
    }

    /**
     *
     * @return Astate
     */
    @Override
    public AState getStartState()
    {
        Position start=maze1.getStartPosition();
        AState a1=new MazeState(start);
        return a1;
    }

    /**
     *
     * @return Astate
     */
    @Override
    public AState getGoalState() {
        Position end=maze1.getGoalPosition();
        AState a1=new MazeState(end);
        return a1;
    }

    /**
     * This function returns the legal's neighbors of Astate s
     * @param s
     * @return LinkedList<AState>
     */
    @Override
    public LinkedList<AState> getAllPossibleStates(AState s)
    {
        LinkedList<AState> neighbors =new LinkedList<>();
        int row=((MazeState) s).getX();
        int count=0;
        int column=((MazeState) s).getY();
        int rowmaze=maze1.getGoalPosition().getRowIndex();
        int colmaze=maze1.getGoalPosition().getColumnIndex();
        Position startVert = maze1.getStartPosition();
        Position end=maze1.getGoalPosition();

        maze1.GetCellCalue(startVert.getRowIndex(),startVert.getColumnIndex()).setCheck();


        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++)
            {
                try {
                    if (row+x<0||row+x>rowmaze||column+y<0||column+y>colmaze||(row+x==row&&column+y==column)) continue;
                } catch (Exception e) {
                    continue;
                }

                if(maze1.GetCellCalue(row+x,column+y).getValue()==0)
                {
                    if(maze1.GetCellCalue(row+x,column+y).getcheck()==false)
                    {
                        AState a1 = new MazeState(maze1.GetCellCalue(row+x,column+y));
                        maze1.GetCellCalue(row+x,column+y).setCheck();
                        if(((row+x==row-1)&&(column+y==column-1))||((row+x==row-1)&&(column+y==column-+1))||
                                ((row+x==row+1)&&(column+y==column-1))||((row+x==row+1)&&(column+y==column+1)))
                        {
                            a1.setCostdiagonal(s);
                        }
                        else
                            a1.setCostregular(s);
                        neighbors.add(a1);
                    }
                }
            }
        return neighbors;
    }

    /**
     * This function fixes the boolean field 'check', to the original before we run the algorithms
     */
    @Override
    public void fixfunc()
    {
        Position end=maze1.getGoalPosition();
        int count=0;
        int rowend= end.getRowIndex()+1;
        int columnend=end.getColumnIndex()+1;
        for(int i=0 ;i<rowend;i++)
            for(int j=0;j<columnend;j++)
            {
                if (maze1.GetCellCalue(i,j).getcheck()==true)
                    count++;
            }
        if(count==rowend*columnend)
        {
            for(int i=0 ;i<rowend;i++)
                for(int j=0;j<columnend;j++)
                    if(maze1.GetCellCalue(i,j).getValue()==0)
                        maze1.GetCellCalue(i,j).setChecktofalse();
        }

    }
}