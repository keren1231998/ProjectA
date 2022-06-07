package Server;

import Server.IServerStrategy;
import java.util.concurrent.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    private final int port;//Each Server has alot of Ports
    private final int listeningIntervalMS;//Time between each print of "Socket Timeout"
    private final IServerStrategy strategy;//solution of the Server
    //because java put the data member in the cache for better time running, and we use with this boolean member with different
    //Threads, so we put "volatile" and then it will not put the boolean member int the cache
    private volatile boolean  stop;
    private final ExecutorService threadPool;

    //To create the Server we need the Port , time and Strategy for Solution
    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        //Only 2 Threads can be in the Pool for the 2 Clients
        this.threadPool=Executors.newFixedThreadPool(2);
    }

    public void start()
    {
        //because we don't want to "stuck" on the line of starting the server deu to the while loop we will
        // use with thread
        Thread t=new Thread (this::runServer);
        t.start();
    }


    //Start the Server
    public void runServer()
    {
        try {
            // ServerSoket is a build-In class at java that we create socket for the server
            ServerSocket serverSocket = new ServerSocket(port);//create new Server , we can see that we don't need to put IP
            serverSocket.setSoTimeout(listeningIntervalMS);
            System.out.println("Starting server at port = " + port);

            //while we don't close the Server we will continue get Clients
            while (!stop)
            {
                //if there will be problem with the client so the program will still continue .
                try {
                    // we wait to client to connect and till then we will print "Socket timeout"
                    Socket clientSocket = serverSocket.accept();//Connect to the client
                    System.out.println("Client accepted: " + clientSocket.toString());
                    //Need to use with ThreadPool.
                    threadPool.submit(()->ServerStrategy(clientSocket));




                } catch (SocketTimeoutException e){
                    //System.out.println("Socket timeout");
                }
            }
            //wait until all threads will finish and then close the threadpool
            serverSocket.close();
            threadPool.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        System.out.println("Stopping the Server.");
        stop = true;
    }
    public void ServerStrategy(Socket clientSocket )
    {
        try {
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Done with Client"+clientSocket );

    }


}
