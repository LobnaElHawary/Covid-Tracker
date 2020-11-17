import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
/* Input Paremeters:
- The X and Y coordinate of the space.
- The number of nodes in the space.
- The percentage of nodes that are COVID positive.
- The total length of the walk.
- The range of time to randomly wait (min milliseconds to max milliseconds)
- The distance to move each time.
- The safe social distance.
- The amount of time to remain in the unsafe social distance to be infected.
*/
public class SliderWindow
{
	JSlider covidPercentSlider = new JSlider();
	public int xCoordinate;
	public int yCoordinate;
	public int numNodes;
	public int covidPercent;
	public int walkLength = 0;
	public int waitTime = 0; 
	public int moveDistance = 0; 
	public int safeDistance = 0; 
	public int infectionTime = 0; 
	
   SliderWindow() 
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
            	Slider frame = new Slider();
                JButton button = new JButton();
                
                button.setVisible(true);
                button.setText("Set Parameters");
                button.setBackground(Color.RED);
                frame.add(button, BorderLayout.SOUTH);
             
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
						frame.dispose();
						EventQueue.invokeLater(() -> {
						Main cd = new Main();
						cd.setVisible(true);
						});
                    }
                });
                
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
               
            }
         });
   }


class Slider extends JFrame
{
	private static final long serialVersionUID = -1020563893718121461L;

	public Slider()
   {
      setTitle("Input Parameters");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      sliderPanel = new JPanel();
      sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
         

      //---------ADD X COORDINATE SLIDER-----------
      JSlider xCoordSlider = new JSlider(0, 2, 0);
      xCoordSlider.setPaintTicks(true);
      xCoordSlider.setSnapToTicks(true);
      xCoordSlider.setPaintLabels(true);
      xCoordSlider.setMinorTickSpacing(1);
      addSlider(xCoordSlider, "X coordinate");
      
      Dictionary<Integer, Component> xCoordHash = new Hashtable<Integer, Component>();
      xCoordHash.put(0, new JLabel("30"));
      xCoordHash.put(1, new JLabel("40"));
      xCoordHash.put(2, new JLabel("50"));
      
      xCoordSlider.setLabelTable(xCoordHash);
      
      //xCoord Listener
      xCoordSlider.addChangeListener((ChangeEvent event) -> {
    	  yCoordinate = xCoordSlider.getValue();
      });
      
    //---------ADD Y COORDINATE SLIDER-----------
      JSlider yCoordSlider = new JSlider(0, 2, 0);
      yCoordSlider.setPaintTicks(true);
      yCoordSlider.setSnapToTicks(true);
      yCoordSlider.setPaintLabels(true);
      yCoordSlider.setMinorTickSpacing(1);
      addSlider(yCoordSlider, "Y coordinate");
      
      Dictionary<Integer, Component> yCoordHash = new Hashtable<Integer, Component>();
      yCoordHash.put(0, new JLabel("30"));
      yCoordHash.put(1, new JLabel("40"));
      yCoordHash.put(2, new JLabel("50"));
      
      yCoordSlider.setLabelTable(yCoordHash);
      
      //yCoord Listener
      yCoordSlider.addChangeListener((ChangeEvent event) -> {
    	  yCoordinate = yCoordSlider.getValue();
      });
      
      //---------ADD NUM NODES SLIDER-----------
      JSlider numNodesSlider = new JSlider(0, 2, 0);
      numNodesSlider.setPaintLabels(true);
      numNodesSlider.setPaintTicks(true);
      numNodesSlider.setSnapToTicks(true);
      numNodesSlider.setMajorTickSpacing(1);
      numNodesSlider.setMinorTickSpacing(1);
      addSlider(numNodesSlider, "Number of Nodes");
      
      Dictionary<Integer, Component> numNodesHash = new Hashtable<Integer, Component>();
      numNodesHash.put(0, new JLabel("30"));
      numNodesHash.put(1, new JLabel("40"));
      numNodesHash.put(2, new JLabel("50"));

      numNodesSlider.setLabelTable(numNodesHash);
      
     
     //num node Listener
      numNodesSlider.addChangeListener((ChangeEvent event) -> {
    	  numNodes = numNodesSlider.getValue();
      });
      
      //---------ADD COVID PERCENT SLIDER-----------
     
     // JSlider covidPercentSlider = new JSlider();
      covidPercentSlider.setPaintTicks(true);
      covidPercentSlider.setPaintLabels(true);
      covidPercentSlider.setSnapToTicks(true);
      covidPercentSlider.setMajorTickSpacing(20);
      covidPercentSlider.setMinorTickSpacing(10);
      covidPercentSlider.setMinimum(10);
      addSlider(covidPercentSlider, "Covid Percentage");
      
      //covid percent Listener
      covidPercentSlider.addChangeListener((ChangeEvent event) -> {
    	  covidPercent = covidPercentSlider.getValue();
    	  //System.out.println(covidPercent);  
      });
     // System.out.println(covidPercent);  
      
      //---------ADD WALK LENGTH SLIDER-----------
      JSlider walkLengthSlider = new JSlider(60,100);
      walkLengthSlider.setPaintTicks(true);
      walkLengthSlider.setPaintLabels(true);
      walkLengthSlider.setSnapToTicks(true);
      walkLengthSlider.setMajorTickSpacing(10);
      walkLengthSlider.setMinorTickSpacing(1);
      addSlider(walkLengthSlider, "Walk Length");
      
     
     //walk length Listener
      walkLengthSlider.addChangeListener((ChangeEvent event) -> {
    	  walkLength = walkLengthSlider.getValue();
      });
      
      //---------ADD WAIT TIME SLIDER-----------
      JSlider waitTimeSlider = new JSlider(500,1000);
      waitTimeSlider.setPaintLabels(true);
      waitTimeSlider.setPaintTicks(true);
      waitTimeSlider.setSnapToTicks(true);
      waitTimeSlider.setMajorTickSpacing(100);
      waitTimeSlider.setMinorTickSpacing(100);
      addSlider(waitTimeSlider, "Wait time (ms)");
      
     
     //walk length Listener
      waitTimeSlider.addChangeListener((ChangeEvent event) -> {
    	  waitTime = waitTimeSlider.getValue();
      });
      
      //---------ADD MOVE DISTANCE SLIDER-----------
      JSlider moveDistanceSlider = new JSlider(1, 3);
      moveDistanceSlider.setPaintLabels(true);
      moveDistanceSlider.setPaintTicks(true);
      moveDistanceSlider.setSnapToTicks(true);
      moveDistanceSlider.setMajorTickSpacing(1);
      moveDistanceSlider.setMinorTickSpacing(1);
      addSlider(moveDistanceSlider, "Moving distance");
     
     //move distances Listener
      moveDistanceSlider.addChangeListener((ChangeEvent event) -> {
    	  moveDistance = moveDistanceSlider.getValue();
      });
      
      //---------ADD SAFE DISTANCE SLIDER-----------
      JSlider safeDistanceSlider = new JSlider(1, 3);
      safeDistanceSlider.setPaintLabels(true);
      safeDistanceSlider.setPaintTicks(true);
      safeDistanceSlider.setSnapToTicks(true);
      safeDistanceSlider.setMajorTickSpacing(1);
      safeDistanceSlider.setMinorTickSpacing(1);
      addSlider(safeDistanceSlider, "Safe Distance");
     
     //safe distances Listener
      safeDistanceSlider.addChangeListener((ChangeEvent event) -> {
    	  safeDistance = safeDistanceSlider.getValue();
      });
      
      //---------ADD INFECTION TIME SLIDER-----------
      JSlider infectionTimeSlider = new JSlider(2, 4);
      infectionTimeSlider.setPaintLabels(true);
      infectionTimeSlider.setPaintTicks(true);
      infectionTimeSlider.setSnapToTicks(true);
      infectionTimeSlider.setMajorTickSpacing(1);
      infectionTimeSlider.setMinorTickSpacing(1);
      addSlider(infectionTimeSlider, "Infection time (sec)");
      
     //safe distances Listener
      infectionTimeSlider.addChangeListener((ChangeEvent event) -> {
    	  infectionTime = infectionTimeSlider.getValue();
      });
     
      add(sliderPanel, BorderLayout.CENTER);
   
   }
   public void addSlider(JSlider s, String description)
   {
//      s.addChangeListener(listener);
      JPanel panel = new JPanel();
      panel.add(s);
      panel.add(new JLabel(description));
      sliderPanel.add(panel);
   }

   public static final int DEFAULT_WIDTH = 350;
   public static final int DEFAULT_HEIGHT = 900;

   private JPanel sliderPanel;
   public int value;
}


}