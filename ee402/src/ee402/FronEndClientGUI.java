package ee402;

import java.awt.*;
import java.awt.event.*;
import javax.accessibility.Accessible;

// Constructor 
public class FronEndClientGUI extends Frame implements ActionListener, WindowListener, Accessible, AdjustmentListener{
    private static final long serialVersionUID = 1L;
    private TextField centrestatus, speedvalue,stattablerow1,stattablerow2,stattablerow3;
    private Button ClockWise, AntiClock, upbutton,downbutton,leftbutton,rightbutton; 
    int x_coord = 0,y_coord = 0, last_x_coord = 0, previous_x_coord = 0, last_y_coord = 0, previous_y_coord = 0, movingspeedval= 100;
    private int framewidth = 600 , frameheight = 700, heightbuffer = 20, widthbuffer = 20, canvaswidth,canvasheight;
    private MyCanvas displaycanvas;
    private Scrollbar speedcontrol;
    private String direction="null", movingspeed = "null",  last_direction = "null", previous_direction = "null", robotstatus = "null",last_robotstatus = "null",previous_robotstatus = "null", proximity ="null", last_proximity = "null", previous_proximity ="null";
    
    public FronEndClientGUI() {
		super("Fron End Client GUI"); 
        this.setLayout(new FlowLayout());
        this.addWindowListener(this);
        
        //////////////////////////////////////
	    /* Configure Direction Controllers  */
	    //////////////////////////////////////
	    Label directiontionlabel; 
	    directiontionlabel=new Label("Movement Controls");  
	    directiontionlabel.setBounds(widthbuffer+30,frameheight-(heightbuffer+200),100,30); 
	    add(directiontionlabel);
	    
	    Label controllinglabel; 
	    controllinglabel=new Label("Direction");  
	    controllinglabel.setBounds(widthbuffer+47,frameheight-(heightbuffer+98),50,20);
	    add(controllinglabel);
        
        centrestatus = new TextField(30);
        centrestatus.setEditable(false);
        centrestatus.setBounds(widthbuffer+50,frameheight-(heightbuffer+78),45,20);
        add(centrestatus);
        
        upbutton=new Button("UP");  // up
	    upbutton.setBounds(widthbuffer+50,frameheight-(heightbuffer+150),45,45);  
	    add(upbutton);
	    upbutton.addActionListener(this);
	                            	    
	    
	    leftbutton=new Button("LEFT");  // left
	    leftbutton.setBounds(widthbuffer,frameheight-(heightbuffer+100),45,45);
	    add(leftbutton);
	    leftbutton.addActionListener(this);
	                       	    
	    rightbutton=new Button("RIGHT");  // right
	    rightbutton.setBounds(widthbuffer+100,frameheight-(heightbuffer+100),45,45);  
	    add(rightbutton); 
	    rightbutton.addActionListener(this);
	    

	    downbutton=new Button("DOWN");  // down
	    downbutton.setBounds(widthbuffer+50,frameheight-(heightbuffer+50),45,45);                           	      
	    add(downbutton);
	    downbutton.addActionListener(this);  
	     
	    
        ////////////////////////////////////////
	    /* Configure Orientation Controllers  */
	    ////////////////////////////////////////
	    /*
	    Label orientationlabeltop; 
	    orientationlabeltop=new Label("Change");  
	    orientationlabeltop.setBounds(widthbuffer+310,frameheight-(heightbuffer+200),100,30); 
	    add(orientationlabeltop);
	    
	    Label orientationlabelbtm; 
	    orientationlabelbtm=new Label("Orientation");  
	    orientationlabelbtm.setBounds(widthbuffer+305,frameheight-(heightbuffer+180),100,30); 
	    add(orientationlabelbtm);
	    
	    ClockWise=new Button("ClockWise");  // up
	    ClockWise.setBounds(widthbuffer+300,frameheight-(heightbuffer+120),70,50);  
	    add(ClockWise); 
	    ClockWise.addActionListener(this);
	     
	    
	    AntiClock=new Button("AntiClock");  // down
	    AntiClock.setBounds(widthbuffer+300,frameheight-(heightbuffer+70),70,50);                           	      
	    add(AntiClock);
	    AntiClock.addActionListener(this);  
	    */
	    
	    
        ////////////////////////////
	    /* Configure Robot Speed  */
	    ////////////////////////////
	    Label robotspeedcontrollabel; 
	    robotspeedcontrollabel=new Label("Speed");  
	    robotspeedcontrollabel.setBounds(widthbuffer+195,frameheight-(heightbuffer+200),100,30); 
	    add(robotspeedcontrollabel);
	    
	    speedvalue = new TextField(30);
	    speedvalue.setEditable(false);
	    speedvalue.setBounds(widthbuffer+202,frameheight-(heightbuffer+170),28,20); 
	    speedvalue.setText("100");
        add(speedvalue);
        movingspeed = "100";
        
        Label speedlabeltop1; 
        speedlabeltop1=new Label("Max");  
        speedlabeltop1.setBounds(widthbuffer+230,frameheight-(heightbuffer+150),50,20); 
	    add(speedlabeltop1);
	    
        Label speedlabeltop2; 
        speedlabeltop2=new Label("100%");  
        speedlabeltop2.setBounds(widthbuffer+230,frameheight-(heightbuffer+135),50,20); 
	    add(speedlabeltop2);
	    
	    speedcontrol = new Scrollbar();
	    speedcontrol.setBounds(widthbuffer+200,frameheight-(heightbuffer+150), 30,145);  	
	    add(speedcontrol);
	    speedcontrol.addAdjustmentListener(this); 
	    
	    Label speedlabelbtm1; 
	    speedlabelbtm1=new Label("10%");  
	    speedlabelbtm1.setBounds(widthbuffer+230,frameheight-(heightbuffer+40),50,20); 
	    add(speedlabelbtm1);
	    
	    Label speedlabelbtm2; 
	    speedlabelbtm2=new Label("Min");  
	    speedlabelbtm2.setBounds(widthbuffer+230,frameheight-(heightbuffer+25),50,20); 
	    add(speedlabelbtm2);
	    
	    
	    
        ///////////////////////
	    /* Configure Canvas  */
	    ///////////////////////
	    
		 
		 canvaswidth = framewidth - (2*widthbuffer);
		 canvasheight = frameheight - 300;
		 displaycanvas = new MyCanvas(framewidth,frameheight,heightbuffer, widthbuffer,canvaswidth,canvasheight);
		 displaycanvas.setBounds(widthbuffer,heightbuffer+20,canvaswidth,canvasheight);
		 displaycanvas.setBackground(Color.WHITE);
   		 add(displaycanvas);
	    
        ////////////////////////////
	    /* Configure Robot Stats  */
	    ////////////////////////////
   		 
 	    Label stattableheader; 
 	    stattableheader=new Label("Robot Status Table");  
 	    stattableheader.setBounds(widthbuffer+300,frameheight-(heightbuffer+200),300,30); 
 	    add(stattableheader);
 	    
 	    Label stattablesubheader; 
 	    stattablesubheader=new Label(" ID | X  |  Y |   ORI  | Status | Proximity ");  
 	    stattablesubheader.setBounds(widthbuffer+300,frameheight-(heightbuffer+170),300,30); 
 	    add(stattablesubheader);
 	  
 	   		 
 	    stattablerow1 = new TextField(30);
 	    stattablerow1.setEditable(false);
 	    stattablerow1.setBounds(widthbuffer+300,frameheight-(heightbuffer+135),250,20); 
 	    stattablerow1.setText("");
        add(stattablerow1);
        
 	    stattablerow2 = new TextField(30);
 	    stattablerow2.setEditable(false);
 	   	stattablerow2.setBounds(widthbuffer+300,frameheight-(heightbuffer+115),250,20); 
 	  	stattablerow2.setText("");
        add(stattablerow2);
        
 	    stattablerow3 = new TextField(30);
 	    stattablerow3.setEditable(false);
 	    stattablerow3.setBounds(widthbuffer+300,frameheight-(heightbuffer+95),250,20); 
 	    stattablerow3.setText("");
        add(stattablerow3);
	    
	    //////////////////////
	    /* Configure Frame  */
	    //////////////////////
	    setSize(framewidth,frameheight);
	    setBackground(Color.GRAY);
	    setLayout(null);  
	    setVisible(true);  
	    
        ////////////////////////////
	    /* Frame Orientation  */
	    ////////////////////////////
        
        //this.pack();
        //this.setVisible(true);
	    update();
    }

    
	public static void main(String[] args) {  
	    new FronEndClientGUI();  
	}
    
    private void update() {
    	//centrestatus.setText("X:" + x_coord + " Y:" + y_coord );
    	System.out.print("Move at " + movingspeedval + "% " + direction + " Current Location X:" + x_coord + " Y:" + y_coord + "\n");
    	centrestatus.setText(direction);
    	speedvalue.setText(movingspeed); 
    	
    	stattablerow1.setText(" ID | "+ x_coord + "  |  " + y_coord + " |   " + direction + " | " + robotstatus + " | " + proximity);
    	stattablerow2.setText(" ID | "+ previous_x_coord + "  |  " + previous_y_coord + " |   " + previous_direction + " | " + previous_robotstatus + " | " + previous_proximity);
    	stattablerow3.setText(" ID | "+ last_x_coord + "  |  " + last_y_coord + " |   " + last_direction + " | " + last_robotstatus + " | " + last_proximity);
    	
    	displaycanvas.setCircleSize(x_coord,y_coord, last_x_coord, previous_x_coord, last_y_coord, previous_y_coord);
    }
    
    private void storevalues() {
    	
    	 last_x_coord = previous_x_coord;
         previous_x_coord = x_coord;

         last_y_coord = previous_y_coord;
         previous_y_coord = y_coord;
         
         last_direction = previous_direction;
         previous_direction = direction;
    	
         last_robotstatus = previous_robotstatus; 
         previous_robotstatus = robotstatus;
         
         last_proximity = previous_proximity;
         previous_proximity = proximity;
    }
    
    
    
    public void adjustmentValueChanged(AdjustmentEvent e) {  
    	movingspeedval = 100 - speedcontrol.getValue();
    	movingspeed = ""+ movingspeedval; 
    	update();
    }
    
    public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(downbutton)) {
            	storevalues();
                direction="South";
                y_coord = y_coord + movingspeedval;
            }
            else if (e.getSource().equals(upbutton)) {
            	storevalues();
                direction="North";
                y_coord = y_coord - movingspeedval;
            }
            
            else if (e.getSource().equals(leftbutton)) {
            	storevalues();
                direction="West";                
                x_coord = x_coord - movingspeedval;
	        }
	        else if (e.getSource().equals(rightbutton)) {
	        	storevalues();
                direction="East";                
                x_coord = x_coord + movingspeedval;
	        }
            update();
                    
    }

     public void windowClosing(WindowEvent e) { 
    	System.out.print("Window Closed\n"); 
    	System.exit(0);        
    }

    public void windowOpened(WindowEvent e) { System.out.print("Window Initialised\n");}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {System.out.print("Window Minimised\n");}
    public void windowDeiconified(WindowEvent e) {System.out.print("Window Activated\n");}
    public void windowActivated(WindowEvent e) { System.out.print("Window Opened\n");}
    public void windowDeactivated(WindowEvent e) {System.out.print("Window deactivated\n");}                 

}
