import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CovidTracker extends JPanel{

	private static final long serialVersionUID = 1L;
	private final int xCoord,yCoord,minTime, maxTime,moveDistance;
	JLabel[][] grid;
	int randomGeneratedX[]; 
	int randomGeneratedY[];
	boolean covidStatus[]; 
	 
	public CovidTracker(int xCoord, int yCoord,  int nodesNum, int covidPercent, int walkLength, int minWaitTime, int maxWaitTime,
			int moveDistance, int safeDistance, int infectionTime) {
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.minTime = minWaitTime;
		this.maxTime = maxWaitTime;
		this.moveDistance = moveDistance;
		
		randomGeneratedX = new int[nodesNum];
		randomGeneratedY = new int[nodesNum];
		covidStatus = new boolean[nodesNum];
		
		InitializeUI(xCoord,yCoord); //create xCoord x yCoord empty board
		GenerateRandom(nodesNum); //generate random x and y coords for threads
		InitialCovidStatus(nodesNum,covidPercent); //generate initial states of threads (covid -ve or +ve)
		CreateThreads(nodesNum); //place threads in these random coords
		
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
	    public void run() 
	    { 
	    	//Random random = new Random();
        	//int randomSleep = random.nextInt(maxTime + 1 - minTime) + minTime; //generate random num in range
        	
	        try
	        { 
	        	  // Displaying the thread that is running 
	            System.out.println ("Thread " + 
	                  Thread.currentThread().getId() + " with name " 
	            	+ Thread.currentThread().getName()+
	                  " is running"); 
	               	
	            Thread.sleep(3000);
	            ReplaceThread();
	            
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
	
	//generates random postions of threads
	public void GenerateRandom(int nodesNum) {
		Random random = new Random();
		int randx, randy;
		boolean exists = false;
		int arrayindex = 0;
		//initialize with -1
		Arrays.fill(randomGeneratedX, -1);
		Arrays.fill(randomGeneratedY, -1);
		
		for(int i = 0; i<nodesNum;i++) {
			do {
				randx = random.nextInt(xCoord) + 1; 
				randy = random.nextInt(yCoord) + 1; 
				
				for(int j = 0; j < nodesNum;j++) {
					if((randomGeneratedX[i] == randx)&&(randomGeneratedY[i] == randy)) 
						exists = true;
				}
			}while(exists);
			
			randomGeneratedX[arrayindex]=randx;
			randomGeneratedY[arrayindex]=randy;
			arrayindex++;
		}
	}
	
	public void InitialCovidStatus(int nodesNum,int covidPercent) {
		//make covidPercent of threads covid positive
		int haveCovid = (int) Math.round(nodesNum * (covidPercent/(double)100));
		
		for(int i = 0; i < nodesNum - haveCovid; i++) {
			covidStatus[i] = false;
		}
		for(int i = nodesNum - haveCovid; i < nodesNum; i++) {
			covidStatus[i] = true;
		}
		Collections.shuffle(Arrays.asList(covidStatus)); //shuffle array randomly
	}
	
	public void CreateThreads(int nodesNum) {
		//create nodesNum threads
        for (int i = 0; i < nodesNum; i++) 
        { 
        	grid[randomGeneratedX[i]][randomGeneratedY[i]].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        	grid[randomGeneratedX[i]][randomGeneratedY[i]].setText(Integer.toString(i));
        	if(covidStatus[i]) //if has covid
        		grid[randomGeneratedX[i]][randomGeneratedY[i]].setForeground(Color.RED);
            Threads object = new Threads(); 
            object.setName(Integer.toString(i)); //give each thread a unique name (nums from 0-n)
            object.start();
            
        } 
	}
	
	public synchronized void ReplaceThread() {
		
		boolean collision = false;
		int posX = 0, posY = 0;
		int Array [] = new int[3]; Array[0] = -moveDistance; Array[1] = 0; Array[2] = moveDistance;
		
		
		//find what position current thread is in
		for(int i = 1; i < xCoord+1; i++) {
			for(int j = 1; j < yCoord+1; j++) {
				if(grid[i][j].getText().equals(Thread.currentThread().getName())){ 
					posX = i;
					posY = j;
				}
			}
		}
		//randomly generate 
		Random random = new Random();
		float stepx = Array[random.nextInt(3)]; //num from -1 to 1
        float stepy = Array[random.nextInt(3)];//num from -1 to 1
        
        posX += stepx;
        posY += stepy;
        
        if((stepx != 0)||(stepy !=0)) { //if not staying still
	        //if new position is within bounds, check for collision
	        if((posX <= xCoord) && (posX >= 1)&&(posY <= yCoord)&&(posY >= 1)) {
	        	//collision
		        if(!grid[posX][posY].getText().equals("-"))
		        	collision = true;
		       
		        if(!collision) {
		        	grid[posX][posY].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		    		grid[posX][posY].setText(Thread.currentThread().getName()); //update the content 
		    		if(covidStatus[Integer.valueOf(Thread.currentThread().getName())])
		    			grid[posX][posY].setForeground(Color.RED);
		        }
	        }
      }
	}
	    

}
