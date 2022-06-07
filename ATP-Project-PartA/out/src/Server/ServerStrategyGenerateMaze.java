package Server;
import java.io.ByteArrayOutputStream;
import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.nio.channels.Channel;
import java.nio.channels.Channels;

public class ServerStrategyGenerateMaze implements IServerStrategy
{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient)
    {
        try {


            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            try {
                int[] mazeDimensions= (int[]) fromClient.readObject();//get array input from user
                IMazeGenerator mazeGenerator=new MyMazeGenerator();//create Maze with the parameters
                Maze maze = mazeGenerator.generate(mazeDimensions[0],mazeDimensions[1]);
                byte[] beforecompress=maze.toByteArray();//represent the maze with byte array
                 ByteArrayOutputStream out = new ByteArrayOutputStream();
                OutputStream is = new MyCompressorOutputStream(out);
                is.write(beforecompress);//convert the regular byte array of the maze to compress byte array
                toClient.writeObject(out.toByteArray());//send to the client the compressed byte array
                toClient.flush();
                is.flush();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
