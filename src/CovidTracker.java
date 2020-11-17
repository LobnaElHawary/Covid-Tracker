import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CovidTracker extends JPanel{
	
	private static final long serialVersionUID = 1L;
	//vars
	final static int rowCol = 30;
	int number = 1;
	
	public CovidTracker(int xCoord, int yCoord,  int nodesNum, int covidPercent, int walkLenght, int waitTime, int moveDistance, 
			int safeDistance, int infectionTime) {
		
		InitializeUI(xCoord,yCoord); //create xCoord x yCoord empty board
		CreateThreads(nodesNum);
    }

	public void InitializeUI(int xCoord, int yCoord) {
		
		int xnum = 0;
		int ynum = 1;
	
        setLayout(new GridLayout(xCoord+1 /*num rows*/, yCoord+1/*num cols*/)); 
        JLabel[][] grid = new JLabel[xCoord+1][yCoord+1];
        
        for(int i = 0; i < xCoord+1; i++) {
        	for(int j = 0; j < yCoord+1; j++) {
        		
        		if(i == 0) {
        			grid[i][j] = new JLabel(Integer.toString(xnum), JLabel.CENTER);
        			xnum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black,1));
                    add(grid[i][j]);
        		}
        		else if(j == 0) {
        			grid[i][j] = new JLabel(Integer.toString(ynum), JLabel.CENTER);
        			ynum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                    add(grid[i][j]);
        		}
        		 if(i!=0 && j!=0) {
        			grid[i][j] = new JLabel("-", JLabel.CENTER);
        			grid[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                    add(grid[i][j]);
        		}
////        		 if(i == 15 && j ==15)
////        			 grid[i][j].setBackground(Color.RED);
        	}
        }
        
        setVisible(true);
	}
	
	class Threads extends Thread 
	{ 
	    public void run() 
	    { 
	        try
	        { 
	            // Displaying the thread that is running 
	            System.out.println ("Thread " + 
	                  Thread.currentThread().getId() + " with name " 
	            	+ Thread.currentThread().getName()+
	                  " is running"); 
	  
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Exception is caught"); 
	        } 
	    } 
	}
	
	public void CreateThreads(int nodesNum) {
		//create nodesNum threads
        for (int i = 0; i < nodesNum; i++) 
        { 
            Threads object = new Threads(); 
            object.setName( Integer.toString(i)); //give each thread a unique name (nums from 0-n)
            object.start(); 
        } 
	}

}
