package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private InetAddress serverIP;//IP of the Server
    private int serverPort;//Port of the server
    private IClientStrategy strategy;//what the Client send to the Server

    // create new Client by the IP of the server and the Port of the server
    public Client(InetAddress serverIP, int serverPort, IClientStrategy strategy) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.strategy = strategy;
    }

    public void start()
    {
        //searching the Server and ask to connect to the Server and the Server get it in the accept method
        try(Socket serverSocket = new Socket(serverIP, serverPort))
        {
            System.out.println("connected to server - IP = " + serverIP + ", Port = " + serverPort);
            strategy.clientStrategy(serverSocket.getInputStream(), serverSocket.getOutputStream());
        } catch (IOException e) //if there is no Server that has this port so there will be exception
        {
            e.printStackTrace();
        }
    }

    public void communicateWithServer() {
    }
}