package Server;
import java.io.*;
import java.util.Properties;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.*;


public class Configurations
{
    private static Configurations instance=null;
    public   Properties props = new Properties();



    public Configurations() throws  IOException
    {
        InputStream file = new FileInputStream(new File("resources/config.properties")) ;

        props.load(file);

    }

    public static Configurations getInstance() throws IOException
    {
        if (instance == null)
            instance = new Configurations();
        return instance;
    }

    public int getNumberofthreads()
    {
        return Integer.parseInt(props.getProperty("threadPoolSize"));
    }

    public AMazeGenerator getGenerate()
    {
        String generate=(String) props.get("mazeGeneratingAlgorithm");
        if(generate.equals("MyMazeGenerator"))
        {
            AMazeGenerator domain = new MyMazeGenerator();
            return domain;
        }
        if(generate.equals("SimpleMazeGenerator"))
        {
            AMazeGenerator domain = new SimpleMazeGenerator();
            return domain;
        }
        if(generate.equals("EmptyMazeGenerator"))
        {
            AMazeGenerator domain = new EmptyMazeGenerator();
            return domain;
        }
        return null;

    }



    public ASearchingAlgorithm getAlgorithm()
    {
        String algo;
        algo=(String) props.get("mazeSearchingAlgorithm");
        if(algo.equals("BreadthFirstSearch"))
        {
            ASearchingAlgorithm searcher=new BreadthFirstSearch();
            return searcher;
        }
        if(algo.equals("DepthFirstSearch"))
        {
            ASearchingAlgorithm searcher=new DepthFirstSearch();
            return searcher;
        }
        if(algo.equals("BestFirstSearch"))
        {
            ASearchingAlgorithm searcher=new BestFirstSearch();
            return searcher;
        }
        return null;
    }


}
