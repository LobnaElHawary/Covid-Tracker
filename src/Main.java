import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends JFrame{
    private static final long serialVersionUID = 1L;
    static SliderWindow slide;

    public Main() {
        UI();
    }

    private void UI() {
    	
        setLayout(new BorderLayout());
        add(new CovidTracker(slide.xCoordinate,slide.yCoordinate,slide.numNodes,slide.covidPercent,slide.walkLength,
        		slide.minWaitTime,slide.maxWaitTime,slide.moveDistance,slide.safeDistance,slide.infectionTime));

    	
        setResizable(true);
        pack();
//        setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        setUndecorated(true);
//        setVisible(true);
        this.getContentPane().setPreferredSize(new Dimension(1400, 1400));
        this.pack();
        setTitle("Covid Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public static void main(String[] args) {
        slide = new SliderWindow();
    }
}
