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
	
	public CovidTracker(int coidPercent) {
		
		int xnum = 0;
		int ynum = 1;
		String xCoord;
		String yCoord;
		
		new GridLayout(rowCol+1, rowCol+1); //num of rows, cols, spacing pixels 
        JLabel[][] grid = new JLabel[rowCol+1][rowCol+1];
        //JFrame f = new JFrame();
        
        //f.setTitle("Covid Tracker");
        
//        int n = 8; // Number of threads 
//        for (int i=0; i<n; i++) 
//        { 
//            Threads object = new Threads(); 
//            object.start(); 
//        } 
//        
        for(int i = 0; i < rowCol+1; i++) {
        	for(int j = 0; j < rowCol+1; j++) {
        		
        		if(i == 0) {
        			xCoord = Integer.toString(xnum);
        			grid[i][j] = new JLabel(xCoord, JLabel.CENTER);
        			xnum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black,1));
                    add(grid[i][j]);
        		}
        		else if(j == 0) {
        			yCoord = Integer.toString(ynum);
        			grid[i][j] = new JLabel(yCoord, JLabel.CENTER);
        			ynum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                    add(grid[i][j]);
        		}
        		 if(i!=0 && j!=0) {
        			grid[i][j] = new JLabel("-", JLabel.CENTER);
        			grid[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                    add(grid[i][j]);
        		}
//        		 if(i == 15 && j ==15)
//        			 grid[i][j].setBackground(Color.RED);
        	}
        }

        //f.setContentPane(panel);
        setSize(300, 300);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	                  Thread.currentThread().getId() + 
	                  " is running"); 
	  
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Exception is caught"); 
	        } 
	    } 
	} 

}
