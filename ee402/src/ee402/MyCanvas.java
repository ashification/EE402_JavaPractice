package ee402;

import java.awt.*;

public class MyCanvas extends Canvas {
	
	private int feguiframewidth , feguiframeheight, feguiheightbuffer, feguiwidthbuffer,feguicanvaswidth,feguicanvasheight ;
	private int x_coord=200,y_coord=200, last_x_coord=150,previous_x_coord=150, last_y_coord=100, previous_y_coord=100,colour=255;
	
	public MyCanvas(int framewidth, int frameheight, int heightbuffer, int widthbuffer, int canvaswidth, int canvasheight) {
		feguiframewidth = framewidth; 
		feguiframeheight = frameheight; 
		feguiheightbuffer = heightbuffer;
		feguiwidthbuffer = widthbuffer;
		feguicanvaswidth =  canvaswidth;
		feguicanvasheight = canvasheight;
		//this.setPreferredSize(new Dimension(300,300));
	}
	
	public void setCircleSize(int x_coord,int y_coord, int last_x_coord, int previous_x_coord, int last_y_coord, int previous_y_coord) {
		this.x_coord = x_coord;
		this.last_x_coord = last_x_coord;
		this.previous_x_coord =previous_x_coord ;
        
		this.y_coord = y_coord;
		this.last_y_coord = last_y_coord ;
		this.previous_y_coord = previous_y_coord ;
		
		colour=0;
		
		this.repaint();
	}
	
	public void paint(Graphics g){
		g.setColor(new Color(0,0,0));
   		g.drawLine(0 ,feguiframeheight - 301, feguiframewidth,feguiframeheight - 301);
   		
   		
   		//North Arrow
   		g.drawLine(feguicanvaswidth-30 ,10, feguicanvaswidth-40,40);
   		g.drawLine(feguicanvaswidth-30 ,10, feguicanvaswidth-20,40);
   		g.drawLine(feguicanvaswidth-30,10,feguicanvaswidth-30 ,70);
   		// North Letter
   		g.drawLine(feguicanvaswidth-50 ,80, feguicanvaswidth-50,140);
   		g.drawLine(feguicanvaswidth-50 ,80, feguicanvaswidth-10,140);
   		g.drawLine(feguicanvaswidth-10 ,80, feguicanvaswidth-10,140);
   				
     		   				
   		//Red
   		g.setColor(new Color(255,0,0));
		g.drawOval(x_coord,y_coord,40,40);
		
		//Blue
		g.setColor(new Color(colour,colour,255));
		g.drawOval(previous_x_coord,previous_y_coord,35,35);
		
		//Green
		g.setColor(new Color(colour,255,colour));
		g.drawOval(last_x_coord,last_y_coord,30,30);
		

    }
}