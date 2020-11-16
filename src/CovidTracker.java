//import java.awt.Color;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class CovidTracker extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//vars
	final static int rowCol = 30;
	int number = 1;
	
	public CovidTracker() {
		int xnum = 0;
		int ynum = 1;
		String xCoord;
		String yCoord;
		final JFrame f = new JFrame("Covid Tester");
        JPanel panel = new JPanel(new GridLayout(rowCol+1, rowCol+1,1,1)); //num of rows, cols, spacing pixels 
        JLabel[][] grid = new JLabel[rowCol+1][rowCol+1];
  
        for(int i = 0; i < rowCol+1; i++) {
        	for(int j = 0; j < rowCol+1; j++) {
        		
        		if(i == 0) {
        			xCoord = Integer.toString(xnum);
        			grid[i][j] = new JLabel(xCoord, JLabel.CENTER);
        			xnum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black,1));
                    panel.add(grid[i][j]);
        		}
        		else if(j == 0) {
        			yCoord = Integer.toString(ynum);
        			grid[i][j] = new JLabel(yCoord, JLabel.CENTER);
        			ynum++;
        			grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                    panel.add(grid[i][j]);
        		}
        		else if(i!=0 && j!=0) {
        			grid[i][j] = new JLabel("-", JLabel.CENTER);
        			grid[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                    panel.add(grid[i][j]);
        		}
//        		 if(i == 15 && j ==15)
//        			 grid[i][j].setBackground(Color.RED);
        	}
        }

        f.setContentPane(panel);
        f.setSize(900, 900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
	
	public static void main(String[] args) {
		SliderWindow sw = new SliderWindow();
	}
}
