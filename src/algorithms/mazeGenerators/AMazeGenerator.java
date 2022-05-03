package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{

    public long measureAlgorithmTimeMillis(int row, int column)
    {
        long l1=System.currentTimeMillis();
        generate(row,column);
        Long l2=System.currentTimeMillis();
        return l2-l1;
    }

}
