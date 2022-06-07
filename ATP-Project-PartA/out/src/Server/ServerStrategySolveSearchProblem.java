
package Server;

import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.search.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;

public class ServerStrategySolveSearchProblem   implements IServerStrategy
{

    String tempDirectoryPath = System.getProperty("java.io.tmpdir");
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
                Solution solution=checkFile(maze);//check if there is a file that has the sol or we need to create new one

                System.out.println(solution+" original");
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

    private Solution checkFile(Maze maze)
    {
        int count=0;
        int col = maze.getGoalPosition().getColumnIndex();
        int row=maze.getGoalPosition().getRowIndex();
        int StartRow = maze.getStartPosition().getRowIndex();
        int StartCol = maze.getStartPosition().getColumnIndex();
        int GoalRow = maze.getGoalPosition().getRowIndex();
        int GoalCol = maze.getGoalPosition().getColumnIndex();
        //create name for the file that represent  the meta Data of the Maze +M that mean this file has maze
        String namepath= String.valueOf(col+row+StartCol+StartCol+GoalRow+GoalCol);
        String namePathMaze="M"+namepath;
        File f = new File(tempDirectoryPath, namePathMaze);//create the file and inset into the folder.
        boolean check = new File(tempDirectoryPath, namePathMaze+count).exists();

        while (check)//run on all the files with the same meta Data in the folder
        {

            try
            {
                byte[] bytearray1=maze.toByteArray();//transfer the maze into byte array
                byte[] bytearray2 = new byte[bytearray1.length];

                MyDecompressorInputStream mazeToCheck = new MyDecompressorInputStream(new FileInputStream(namePathMaze));
                mazeToCheck.read(bytearray2);
                if(Arrays.equals(bytearray1, bytearray2))
                {
                    FileInputStream fis = new FileInputStream(namepath);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Solution solution = (Solution) ois.readObject();
                    return solution;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            count++;
            check = new File(tempDirectoryPath, namePathMaze+count).exists();

        }
        //if folder doesn't have any file withe the same meta data
        Solution solution =addfile(namePathMaze,maze,count);
        return solution;


    }

    synchronized Solution  addfile(String name, Maze maze,int count)
    {
        ISearchable domain = new SearchableMaze(maze);
        ISearchingAlgorithm searcher=new BreadthFirstSearch();
        Solution solution=searcher.solve(domain);


        int col = maze.getGoalPosition().getColumnIndex();
        int row=maze.getGoalPosition().getRowIndex();
        int StartRow = maze.getStartPosition().getRowIndex();
        int StartCol = maze.getStartPosition().getColumnIndex();
        int GoalRow = maze.getGoalPosition().getRowIndex();
        int GoalCol = maze.getGoalPosition().getColumnIndex();
        String namePath= String.valueOf(col+row+StartCol+StartCol+GoalRow+GoalCol);
        File fileSol = new File(tempDirectoryPath, namePath+count);
        File fileMaze = new File(tempDirectoryPath, "M"+namePath+count);


        //create file and insert solution
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(fileSol);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(solution);
            ois.flush();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //create new file and inser the byte of the maze
            FileOutputStream fis2=new FileOutputStream(fileMaze);
            ObjectOutputStream ois2=new ObjectOutputStream(fis2);
            ois2.writeObject(maze.toByteArray());
            ois2.flush();
            ois2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return solution;
    }
}
