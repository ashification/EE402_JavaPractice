package ee402;

import java.awt.*;
import java.awt.event.*;

// Constructor 
public class Counter extends Frame implements ActionListener, WindowListener{
                private static final long serialVersionUID = 1L;
                private TextField t;
                private Button up, down;
                private int count=40;
              

                public Counter() {
                        super("EE402 Week 9 Counter Application");
                        this.setLayout(new FlowLayout());
                        this.addWindowListener(this);
                        
                        up = new Button ("Increment");
                        this.add(up);
                        up.addActionListener(this);
                        
                        t = new TextField(30);
                        t.setEditable(false);
                        this.add(t);
                        
                        down = new Button ("Decrement");
                        this.add(down);
                        down.addActionListener(this);

                        this.pack();
                        this.setVisible(true);
                        update();
                }
                


                public static void main(String[] args) {
                      Counter c = new Counter ();
                      

                }
                
                private void update() {
                   t.setText("Value is : " + count);
                   //this             
                }
                
                @Override
                public void actionPerformed(ActionEvent e) {
                                if (e.getSource().equals(down)) {
                                                System.out.print("Down\n");
                                                count--;
                                                
                                }
                                else if (e.getSource().equals(up)) {
                                                System.out.print("Up\n");
                                                count++;
                                }
                                update();
                                
                }

                @Override
                public void windowOpened(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                }

                @Override
                public void windowClosing(WindowEvent e) {
                                System.exit(0);
                                
                }

                @Override
                public void windowClosed(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                }

                @Override
                public void windowIconified(WindowEvent e) {
                                System.out.print("Window Minimised\n");
                                
                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                                System.out.print("Window Un-minimised\n");
                                
                }

                @Override
                public void windowActivated(WindowEvent e) {
                                System.out.print("Window maximised\n");
                                
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                                System.out.print("Window deactivated\n");
                                
                }

}
