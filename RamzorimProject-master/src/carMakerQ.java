import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import javax.swing.JPanel;

public class carMakerQ extends Thread{
		JPanel myPanel;
		private ShloshaAvot myRamzor;
		int key;
		Socket clientSocket;
		PrintWriter bufferSocketOut;
		String numberTraffic;
		List<Integer> listQ;
		public carMakerQ(JPanel myPanel,ShloshaAvot myRamzor, int key,String numberTraffic,List<Integer> listQ,Socket clientSocket, PrintWriter bufferSocketOut) 
		{
			this.myPanel=myPanel;
			this.myRamzor=myRamzor;
			this.key=key;
			this.numberTraffic=numberTraffic;
			this.listQ=listQ;
			this.clientSocket=clientSocket;
	        this.bufferSocketOut=bufferSocketOut;
			setDaemon(true);
			start();
		}

		public void run()
		{
			
			try {
				while (true)
				{
					sleep(1500);
					if ( !myRamzor.isStop()&& !listQ.isEmpty())
					{
						new CarMooving(myPanel,myRamzor,key,listQ.get(0),numberTraffic,clientSocket,bufferSocketOut);
						listQ.remove(listQ.get(0));
					
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}



