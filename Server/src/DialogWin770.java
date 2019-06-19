
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


//package Server770;

//File name DialogWin770.java


public class DialogWin770 extends JFrame implements ActionListener{
	JButton toState1,toState2,toState3,alltoState1,alltoState2,alltoState3,takeCover,removeCover,toShabat;
	JLabel title,junction;
	JComboBox<String> list = new JComboBox<String>();
	private static final long serialVersionUID = 1L;
    public Dialog770[] myDialog = new Dialog770[4];
    boolean[] takes = {false,false,false,false};
	String choose = "צומת 1";
	int place = 0;

    public DialogWin770()
    {
        super("Server of Ramzorim");
        setLayout(null);
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        title = new JLabel("מרכז שליטה");
        title.setBounds(200, 10, 214, 31);
        title.setFont(new Font("Segoe UI",Font.BOLD,26));
        add(title);
        junction = new JLabel("צומת:");
        junction.setBounds(442, 120, 80, 31);
        junction.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(junction);
        list.setBounds(143, 120, 280, 33);
        add(list);
        list.addActionListener(this);
        toState1 = new JButton("העבר למצב 1");
        toState1.setBounds(384, 202, 110, 35);
        toState1.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(toState1);
        toState1.addActionListener(this);
        toState2 = new JButton("העבר למצב 2");
        toState2.setBounds(384, 257, 110, 35);
        toState2.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(toState2);
        toState2.addActionListener(this);
        toState3 = new JButton("העבר למצב 3");
        toState3.setBounds(384, 320, 110, 35);
        toState3.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(toState3);
        toState3.addActionListener(this);
        alltoState1 = new JButton("כולם למצב 1");
        alltoState1.setBounds(217, 366, 105, 35);
        alltoState1.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(alltoState1);
        alltoState1.addActionListener(this);
        alltoState2 = new JButton("כולם למצב 2");
        alltoState2.setBounds(217, 422, 105, 35);
        alltoState2.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(alltoState2);
        alltoState2.addActionListener(this);
        alltoState3 = new JButton("כולם למצב 3");
        alltoState3.setBounds(217, 479, 105, 35);
        alltoState3.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(alltoState3);
        alltoState3.addActionListener(this);
        takeCover = new JButton("קח שליטה");
        takeCover.setBounds(57, 202, 105, 35);
        takeCover.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(takeCover);
        takeCover.addActionListener(this);
        removeCover = new JButton("הורד שליטה");
        removeCover.setBounds(57, 252, 105, 35);
        removeCover.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(removeCover);
        removeCover.addActionListener(this);
        toShabat = new JButton("העבר למצב שבת");
        toShabat.setBounds(220, 202, 130, 35);
        toShabat.setFont(new Font("Segoe UI",Font.BOLD,12));
        add(toShabat);
        toShabat.addActionListener(this);
       setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == list) {
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
			 choose = (String)cb.getSelectedItem();
			 switch (choose) {
				case "צומת 1":
					place = 0;
					break;
				case "צומת 2":
					place = 1;
					break;
				case "צומת 3":
					place = 2;
					break;
				case "צומת 4":
					place = 3;
					break;
				}
		}
		else if (((JButton) e.getSource()).getText().equals("העבר למצב 1")) {
			if(takes[place])
			myDialog[place].bufferSocketOut.println("העבר למצב 1");
		}
		else if (((JButton) e.getSource()).getText().equals("העבר למצב 2")) {
			if(takes[place])
				myDialog[place].bufferSocketOut.println("העבר למצב 2");

		}
		else if (((JButton) e.getSource()).getText().equals("העבר למצב 3")) {
			if(takes[place])
				myDialog[place].bufferSocketOut.println("העבר למצב 3");
        }
		else if (((JButton) e.getSource()).getText().equals("כולם למצב 1")) {
			for(int i = 0;i < 4;i++) {
        		if(takes[i])
    			myDialog[i].bufferSocketOut.println("העבר למצב 1");
            	}
        }
		else if (((JButton) e.getSource()).getText().equals("כולם למצב 2")) {
			for(int i = 0;i < 4;i++) {
        		if(takes[i])
    			myDialog[i].bufferSocketOut.println("העבר למצב 2");
            	}
        }
		else if (((JButton) e.getSource()).getText().equals("כולם למצב 3")) {
        	for(int i = 0;i < 4;i++) {
        		if(takes[i])
    			myDialog[i].bufferSocketOut.println("העבר למצב 3");
            	}
        }
		else if (((JButton) e.getSource()).getText().equals("קח שליטה")) {
			if(!takes[place])
			myDialog[place].bufferSocketOut.println("קח שליטה");
			switch (choose) {
			case "צומת 1":
				takes[0] =  true;
				break;
			case "צומת 2":
				takes[1] =  true;
				break;
			case "צומת 3":
				takes[2] =  true;
				break;
			case "צומת 4":
				takes[3] =  true;
				break;
			}
        }
		else if (((JButton) e.getSource()).getText().equals("הורד שליטה")) {
			if(takes[place])
			myDialog[place].bufferSocketOut.println("הורד שליטה");
			switch (choose) {
			case "צומת 1":
				takes[0] =  false;
				break;
			case "צומת 2":
				takes[1] =  false;
				break;
			case "צומת 3":
				takes[2] =  false;
				break;
			case "צומת 4":
				takes[3] =  false;
				break;
			}
        }
		else if (((JButton) e.getSource()).getText().equals("העבר למצב שבת")) {
        		if(takes[place])
    			myDialog[place].bufferSocketOut.println("העבר למצב שבת");
        }
		}
		
	public void send_car_moving(int place,String line)
	{
		myDialog[place].bufferSocketOut.println(line);

	}
	}

