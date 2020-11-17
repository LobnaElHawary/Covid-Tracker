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
        System.out.println (slide.covidPercent); 
        //add(new CovidTracker(slide.covidPercent));

        setLayout(new BorderLayout());
        add(new CovidTracker(slide.covidPercent));
        setResizable(true);
        pack();
        this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
        this.pack();
        setTitle("Zssignment 3 - Tank Attack");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public static void main(String[] args) {
        slide = new SliderWindow();
    }
}