import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 * Created on Mimuna 5767  upDate on Addar 5772 
 */

/**
 * @author לויאן
 */
public class BuildTrafficLight
{
	Random rand = new Random();
	public void doit() {
		String SERVERHOST = "127.0.0.1";
	    int DEFAULT_PORT = 770;
	    Socket clientSocket = null;
	    BufferedReader bufferSocketIn = null;
	    PrintWriter bufferSocketOut = null;
	    String line;
	    List<Integer> listQ1 = new ArrayList<Integer>();
	    List<Integer> listQ2 = new ArrayList<Integer>();
	    List<Integer> listQ3 = new ArrayList<Integer>();
	    List<Integer> listQ4 = new ArrayList<Integer>();

       String number = JOptionPane.showInputDialog("שם הצומת");
	    
	    String name = "צומת " + number;
	    
	    try
        {
            // request to server
            clientSocket = new Socket(SERVERHOST, DEFAULT_PORT);

            // Init streams to read/write text in this socket
            bufferSocketIn = new BufferedReader(
                    new InputStreamReader(
                    clientSocket.getInputStream()));
            bufferSocketOut = new PrintWriter(
                    new BufferedWriter(
                    new OutputStreamWriter(
                    clientSocket.getOutputStream())), true);
            bufferSocketOut.println(name);
        
        
   } catch (IOException e)
   {
       System.err.println(e);
   }
	    
		final int numOfLights=4+12+1;
		ShloshaAvot listThree[] = new ShloshaAvot[4];
		ShneyLuchot listTwo[] = new ShneyLuchot[12];
		Controller controller;
		Ramzor ramzorim[]=new Ramzor[numOfLights];
		ramzorim[0]=new Ramzor(3,40,430,110,472,110,514,110);
		ramzorim[1]=new Ramzor(3,40,450,310,450,352,450,394);
		ramzorim[2]=new Ramzor(3,40,310,630,280,605,250,580);
		ramzorim[3]=new Ramzor(3,40,350,350,308,350,266,350); 
	
		ramzorim[4]=new Ramzor(2,20,600,18,600,40);
		ramzorim[5]=new Ramzor(2,20,600,227,600,205);
		ramzorim[6]=new Ramzor(2,20,600,255,600,277);
		ramzorim[7]=new Ramzor(2,20,600,455,600,433);
		ramzorim[8]=new Ramzor(2,20,575,475,553,475);
		ramzorim[9]=new Ramzor(2,20,140,608,150,590);
		ramzorim[10]=new Ramzor(2,20,205,475,193,490);
		ramzorim[11]=new Ramzor(2,20,230,475,250,475);
		ramzorim[12]=new Ramzor(2,20,200,453,200,433);
		ramzorim[13]=new Ramzor(2,20,200,255,200,277);
		ramzorim[14]=new Ramzor(2,20,200,227,200,205);
		ramzorim[15]=new Ramzor(2,20,200,18,200,40);

		ramzorim[16]=new Ramzor(1,30,555,645);

		TrafficLightFrame tlf=new TrafficLightFrame(name,ramzorim);
		 
	     
			listThree[0] = new ShloshaAvot(ramzorim[0],tlf.myPanel,0+1, number,listQ1,clientSocket,bufferSocketOut,listQ4);
			listThree[1] = new ShloshaAvot(ramzorim[1],tlf.myPanel,1+1, number,listQ1,clientSocket,bufferSocketOut,listQ4);
			listThree[2] = new ShloshaAvot(ramzorim[2],tlf.myPanel,2+1, number,listQ2,clientSocket,bufferSocketOut,listQ4);
			listThree[3] = new ShloshaAvot(ramzorim[3],tlf.myPanel,3+1, number,listQ3,clientSocket,bufferSocketOut,listQ4);
			

		

		for (int i = 0; i<12 ; i++) {
			listTwo[i] = new ShneyLuchot(ramzorim[i+4],tlf.myPanel);
		}
		
		new Echad(ramzorim[16],tlf.myPanel);

		MyActionListener myListener=new MyActionListener();

		JRadioButton butt[]=new JRadioButton[13]; 

		for (int i=0;i<butt.length-1;i++) 
		{
			butt[i]  =new JRadioButton();
			butt[i].setName(Integer.toString(i+4));
			butt[i].setOpaque(false);
			butt[i].addActionListener(myListener);
			tlf.myPanel.add(butt[i]);
		}
		butt[0].setBounds(620, 30, 18, 18);
		butt[1].setBounds(620, 218, 18, 18);
		butt[2].setBounds(620, 267, 18, 18);
		butt[3].setBounds(620, 447, 18, 18);
		butt[4].setBounds(566, 495, 18, 18);
		butt[5].setBounds(162,608, 18, 18);
		butt[6].setBounds(213,495, 18, 18);
		butt[7].setBounds(240,457, 18, 18);
		butt[8].setBounds(220,443, 18, 18);
		butt[9].setBounds(220,267, 18, 18);
		butt[10].setBounds(220,218, 18, 18);
		butt[11].setBounds(220,30, 18, 18);

		butt[12]  =new JRadioButton();
		butt[12].setName(Integer.toString(16));
		butt[12].setBounds(50,30, 55, 20);
		butt[12].setText("שבת");
		butt[12].setOpaque(false);
		butt[12].addActionListener(myListener);
		tlf.myPanel.add(butt[12]);
		controller = new Controller(listThree,listTwo,myListener);
	        try
	        {
	         
	            while (true)
	            {
	                line = bufferSocketIn.readLine(); // reads a line from the server
	            
	                
                	int rando = rand.nextInt(2);
	                switch(line) {
	                case "העבר למצב 1":
	                	controller.toState1();
	                	break;
	                case "העבר למצב 2":
	                	controller.toState2();
	                	break;
	                case "העבר למצב 3":
	                	controller.toState3();
	                	break;
	                case "קח שליטה":
	                	controller.ChangeToRole();
	                	break;
	                case "הורד שליטה":
	                	controller.ChangeToRole();
	                	break;
	                case "העבר למצב שבת":
	                	break;
	                case "מכונית לשמאל 1":
	                	listQ1.add(1);
	                	break;
	                case "מכונית לשמאל 2":
	                	listQ1.add(2);
	                	break;
	                case "מכונית לשמאל 3":
	                	listQ1.add(3);
	                	break;
	                case "מכונית לשמאל 4":
	                	listQ1.add(4);
	                	break;
	                case "מכונית לשמאל 5":
	                	listQ1.add(5);
	                	break;
	                case "מכונית לשמאל1 1":
	                	listQ4.add(1);
	                	break;
	                case "מכונית לשמאל1 2":
	                	listQ4.add(2);
	                	break;
	                case "מכונית לשמאל1 3":
	                	listQ4.add(3);
	                	break;
	                case "מכונית לשמאל1 4":
	                	listQ4.add(4);
	                	break;
	                case "מכונית לשמאל1 5":
	                	listQ4.add(5);
	                	break;
	                case "מכונית לימין 1":
	                	if(rando == 0)
	                		listQ2.add(1);	     
	                	else
	                		listQ3.add(1);
	                	break;
	                case "מכונית לימין 2":
	                	if(rando == 0)
	                		listQ2.add(2);	     
	                	else
	                		listQ3.add(2);
	                	break;
	                case "מכונית לימין 3":
	                	if(rando == 0)
	                		listQ2.add(3);	     
	                	else
	                		listQ3.add(3);
	                	break;
	                case "מכונית לימין 4":
	                	if(rando == 0)
	                		listQ2.add(4);	     
	                	else
	                		listQ3.add(4);
	                	break;
	                case "מכונית לימין 5":
	                	if(rando == 0)
	                		listQ2.add(5);	     
	                	else
	                		listQ3.add(5);
	                	break;
	                }
	            }
	        } catch (IOException e)
	        {
	            System.err.println(e);
	        } finally
	        {
	            try
	            {
	                if (clientSocket != null)
	                {
	                    clientSocket.close();
	                }
	            } catch (IOException e2)
	            {
	            }
	        }
	}
    public static void main(String[] args)
    {
    	BuildTrafficLight client = new BuildTrafficLight();
        client.doit();
    }

}
