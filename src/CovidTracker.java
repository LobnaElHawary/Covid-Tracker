//import java.awt.Color;
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
		
		final JFrame f = new JFrame("Covid Tester");
        JPanel panel = new JPanel(new GridLayout(rowCol, rowCol,1,1)); //num of rows, cols, spacing pixels 
        JLabel[][] grid= new JLabel[rowCol][rowCol];
        
        for(int i =0;i<rowCol;i++) {
        	for(int j=0;j<rowCol;j++) {
        		
        		 grid[i][j] = new JLabel("-", JLabel.CENTER);
//        		 if(i == 15 && j ==15)
//        			 grid[i][j].setBackground(Color.RED);
        		 grid[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                 panel.add(grid[i][j]);
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
