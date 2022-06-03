package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{

    /**
     * @param row
     * @param column
     * @return Measure time in millis of the algorithm after creating the maze
     */
    public long measureAlgorithmTimeMillis(int row, int column)
    {
        long l1=System.currentTimeMillis();
        generate(row,column);
        Long l2=System.currentTimeMillis();
        return l2-l1;
    }

}