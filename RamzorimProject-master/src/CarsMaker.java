import javax.swing.JPanel;

/*
 * Created on Tevet 5770 
 */

/**
 * @author לויאן
 */

public class CarsMaker extends Thread
{
	JPanel myPanel;
	private ShloshaAvot myRamzor;
	int key;
	int num;
	String numberTraffic;
	public CarsMaker(JPanel myPanel,ShloshaAvot myRamzor, int key,String numberTraffic) 
	{
		this.myPanel=myPanel;
		this.myRamzor=myRamzor;
		this.key=key;
		this.numberTraffic=numberTraffic;
		setDaemon(true);
		start();
	}

	public void run()
	{
		num=1;
		try {
			while (true)
			{
				sleep(1500);
				if (!myRamzor.isStop())
				{
					new CarMooving(myPanel,myRamzor,key,num,numberTraffic);
					if(num == 1)
					{
						num = 1;
					}
					else
						num++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
