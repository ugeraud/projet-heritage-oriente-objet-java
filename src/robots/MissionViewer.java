package robots;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utilitaires.Reader;
/**
 * This class simulates the motion of points.
 * Do not modify it.
 *
 */
public class MissionViewer extends JPanel {
	private static final long serialVersionUID = 1L;
	protected Reader reader;
	protected boolean colored;
	protected static final int SPEED=200; // 200 ms
	protected static final int WIDTH=800, HEIGHT=800;
    protected static final float saturation = (float) 0.90, brightness = (float) 0.70;
    
	        public MissionViewer(String filename, boolean colored) {
	        	this.colored=colored;
	        	reader=new Reader(filename,'\t');
	            Timer timer = new Timer(SPEED, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    repaint();
	                }
	            });
	            timer.start();
	        }

	        @Override
	        public Dimension getPreferredSize() {
	            return new Dimension(WIDTH, HEIGHT);
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            if (!colored)
	            	g.setColor(Color.BLUE);
	            boolean done;
	            double[]line;
	            boolean end=false;
	            do {
	            	line=reader.readLine();
	            	done=(line==null);
	            	if (done)end=true;
	            	if ((!done)&&(line[0]==-1)) done=true;
	            	if (!done){
	            		int id=(int)line[0];
	            		double x=line[1];
	            		int xp=(int)(x*WIDTH*0.99);
	            		double y=line[2];
	            		int yp=(int)(y*HEIGHT*0.99);
	            		if (colored){
	            			if ((id<0)||(id>255)){
	            		          System.err.println("The color index must be in [0,255]: "+id);
	            		          System.exit(-1);
	            			}	
		            		float hue = (float)((255-id)/360.0);
	            			int rgb=Color.HSBtoRGB(hue, saturation, brightness);
	            			Color c=new Color((int)rgb);
	            			g.setColor(c);
	            		}
	            		g.fillOval(xp,yp,8,8);
	            		end=false;
	            	}
	            }while(!done);
	          if (end) reader=new Reader(reader.getFilename(),'\t');
       
	        }
	        public static void display(){
	        	display(false);
	        }
	        public static void display(boolean colored){
	            JFrame frame = new JFrame("Mission Viewer");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setLayout(new BorderLayout());
	            frame.add(new MissionViewer("data/BasicMission.txt",colored));
	            frame.pack();
	            frame.setVisible(true);
	        }
	    }

