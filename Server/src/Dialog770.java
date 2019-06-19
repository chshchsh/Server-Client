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
                switch(line)
                {
                case "left 1 1":
                	myServer.myOutput.send_car_moving(2,"מכונית לשמאל 1");
                	break;
                case "left 1 2":
                	myServer.myOutput.send_car_moving(2,"מכונית לשמאל 2");
                	break;
                case "left 1 3":
                	myServer.myOutput.send_car_moving(2,"מכונית לשמאל 3");
                	break;
                case "left 1 4":
                	myServer.myOutput.send_car_moving(2,"מכונית לשמאל 4");
                	break;
                case "left 1 5":
                	myServer.myOutput.send_car_moving(2,"מכונית לשמאל 5");
                	break;
                case "left 2 1":
                	myServer.myOutput.send_car_moving(3,"מכונית לשמאל 1");
                	break;
                case "left 2 2":
                	myServer.myOutput.send_car_moving(3,"מכונית לשמאל 2");
                	break;
                case "left 2 3":
                	myServer.myOutput.send_car_moving(3,"מכונית לשמאל 3");
                	break;
                case "left 2 4":
                	myServer.myOutput.send_car_moving(3,"מכונית לשמאל 4");
                	break;
                case "left 2 5":
                	myServer.myOutput.send_car_moving(3,"מכונית לשמאל 5");
                	break;
                case "left 3 1":
                	myServer.myOutput.send_car_moving(4,"מכונית לשמאל 1");
                	break;
                case "left 3 2":
                	myServer.myOutput.send_car_moving(4,"מכונית לשמאל 2");
                	break;
                case "left 3 3":
                	myServer.myOutput.send_car_moving(4,"מכונית לשמאל 3");
                	break;
                case "left 3 4":
                	myServer.myOutput.send_car_moving(4,"מכונית לשמאל 4");
                	break;
                case "left 3 5":
                	myServer.myOutput.send_car_moving(4,"מכונית לשמאל 5");
                case "left 4 1":
                	break;
                case "left 4 2":
                	break;
                case "left 4 3":
                	break;
                case "left 4 4":
                	break;
                case "left 4 5":
                	break;
                case "right 4 1":
                	myServer.myOutput.send_car_moving(3,"מכונית לימין 1");
                	break;
                case "right 4 2":
                	myServer.myOutput.send_car_moving(3,"מכונית לימין 2");
                	break;
                case "right 4 3":
                	myServer.myOutput.send_car_moving(3,"מכונית לימין 3");
                	break;
                case "right 4 4":
                	myServer.myOutput.send_car_moving(3,"מכונית לימין 4");
                	break;
                case "right 4 5":
                	myServer.myOutput.send_car_moving(3,"מכונית לימין 5");
                	break;
                case "right 2 1":
                	myServer.myOutput.send_car_moving(1,"מכונית לימין 1");
                	break;
                case "right 2 2":
                	myServer.myOutput.send_car_moving(1,"מכונית לימין 2");
                	break;
                case "right 2 3":
                	myServer.myOutput.send_car_moving(1,"מכונית לימין 3");
                	break;
                case "right 2 4":
                	myServer.myOutput.send_car_moving(1,"מכונית לימין 4");
                	break;
                case "right 2 5":
                	myServer.myOutput.send_car_moving(1,"מכונית לימין 5");
                	break;
                case "right 3 1":
                	myServer.myOutput.send_car_moving(2,"מכונית לימין 1");
                	break;
                case "right 3 2":
                	myServer.myOutput.send_car_moving(2,"מכונית לימין 2");
                	break;
                case "right 3 3":
                	myServer.myOutput.send_car_moving(2,"מכונית לימין 3");
                	break;
                case "right 3 4":
                	myServer.myOutput.send_car_moving(2,"מכונית לימין 4");
                	break;
                case "right 3 5":
                	myServer.myOutput.send_car_moving(2,"מכונית לימין 5");
                case "right 1 1":
                	break;
                case "right 1 2":
                	break;
                case "right 1 3":
                	break;
                case "right 1 4":
                	break;
                case "right 1 5":
                	break;
                	
                 default:
                	 myServer.myOutput.list.addItem(line);
                }
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
