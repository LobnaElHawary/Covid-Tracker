import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CovidTracker extends JPanel{

	//to do: Timer that runs code for x amount
	//random generated arrays that are passed when making threads
	//synchronize 

	private static final long serialVersionUID = 1L;
	private final int minTime, maxTime,xCoord,yCoord;
	JLabel[][] grid;
	int randomGeneratedX[]; 
	int randomGeneratedY[];
	int randomX, randomY;
	//private  int index = 0;
	 
	public CovidTracker(int xCoord, int yCoord,  int nodesNum, int covidPercent, int walkLenght, int minWaitTime, int maxWaitTime,
			int moveDistance, int safeDistance, int infectionTime) {
		
		this.minTime = minWaitTime;
		this.maxTime = maxWaitTime;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		//		System.out.println("Min time "+ minTime);  
		randomGeneratedX = new int[nodesNum];
		randomGeneratedY = new int[nodesNum];
		
		InitializeUI(xCoord,yCoord); //create xCoord x yCoord empty board
		CreateThreads(nodesNum);
		
    }

	public void InitializeUI(int xCoord, int yCoord) {
		
		int xnum = 0;
		int ynum = 1;
	
		setLayout(new GridLayout(xCoord+1 /*num rows*/, yCoord+1/*num cols*/)); 
	    grid = new JLabel[xCoord+1][yCoord+1];
	    
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
		Random random = new Random();
    	int randomX = random.nextInt(xCoord) + 1; //generate random num in range of 1 - xcoord
    	int randomY = random.nextInt(yCoord) + 1; //generate random num in range of 1 - ycoord
	    public void run() 
	    { 
	    	
        	int randomSleep = random.nextInt(maxTime + 1 - minTime) + minTime; //generate random num in range
        	
	        try
	        { 
	        	  // Displaying the thread that is running 
	            System.out.println ("Thread " + 
	                  Thread.currentThread().getId() + " with name " 
	            	+ Thread.currentThread().getName()+
	                  " is running"); 
	        
	            
	        	System.out.println("random X "+ randomX);  
	        	System.out.println("random Y "+ randomY);  
	        	PlaceThread(randomX,randomY,Thread.currentThread().getName()); //move thread to random positions
	        	
	            Thread.sleep(10000);
	            
	            Random random = new Random();
	    		float stepx =random.nextInt(3) - 1; //num from -1 to 0 
	            float stepy = random.nextInt(3) - 1;//num from -1 to 0
	            randomX += stepx;
	            randomY += stepy;
	            if((randomX <= 30)&&(randomX >= 1)&&(randomY <= 30)&&(randomY >= 1))
	            	PlaceThread(randomX,randomY,Thread.currentThread().getName());
	  
	        } 
	        catch (InterruptedException e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Interrupted exception"); 
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
        for (int i = 0; i < 30; i++) 
        { 
            Threads object = new Threads(); 
            object.setName(Integer.toString(i)); //give each thread a unique name (nums from 0-n)
            object.start();
        } 
	}
	
	
	public synchronized void PlaceThread(int xPosition, int yPosition,String threadName) {
		//randomly generate 
		
		//check if there will be collision
		
		//placethread
		grid[xPosition][yPosition].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		grid[xPosition][yPosition].setText(threadName); //update the content 
		//grid[xPosition][yPosition].setForeground(Color.RED);
	}
	    

}
