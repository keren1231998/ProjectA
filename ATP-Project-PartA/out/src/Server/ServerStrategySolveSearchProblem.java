
package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy
{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient)
    {
        try
        {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            try
            {
                Maze maze= (Maze) fromClient.readObject();//get Maze input from user
                ISearchingAlgorithm searcher= new BreadthFirstSearch();
                SearchableMaze searchableMaze = new SearchableMaze(maze);
                Solution solution = searcher.solve(searchableMaze);
                toClient.writeObject(solution);
                toClient.flush();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
