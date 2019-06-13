//package Server770;

//file name: Dialog770.java
//Iyar 5770
//Levian Yehonatan
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Dialog770 extends Thread // parallel dialogs on the same socket
{

    Socket client;
    Server770 myServer;
    BufferedReader bufferSocketIn;
    PrintWriter bufferSocketOut;
    
    
    public Dialog770(Socket clientSocket, Server770 myServer) throws IOException
    {
        client = clientSocket;
        this.myServer = myServer;
        try
        {
            // Init streams to read/write text in this socket
            bufferSocketIn = new BufferedReader(
                    new InputStreamReader(
                    clientSocket.getInputStream()));
            bufferSocketOut = new PrintWriter(
                    new BufferedWriter(
                    new OutputStreamWriter(
                    clientSocket.getOutputStream())), true);
        } catch (IOException e)
        {
            try
            {
                client.close();
            } catch (IOException e2)
            {
            }
            System.err.println("server:Exception when opening sockets: " + e);
            return;
        }
        start();
    }

    public void run()
    {
        String line;
        @SuppressWarnings("unused")
		boolean stop=false;
        try
        {
            while (true)
            {
                line = bufferSocketIn.readLine();
                myServer.myOutput.list.addItem(line);
            }
        } catch (IOException e)
        {
        } finally
        {
            try
            {
                client.close();
            } catch (IOException e2)
            {
            }
        }


    }

    void exit()
    {
            try
            {
                client.close();
            } catch (IOException e2)
            {
            }
    }
}
