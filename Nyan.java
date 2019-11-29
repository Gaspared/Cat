package cat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Nyan extends JFrame{

		Container c;
		JLabel lab;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int lifecounter = 7;
		int speed = 1;
		Icon pic;
		String text;
	
		public Nyan() {
			c = getContentPane();
			
			//transparent
			setUndecorated(true);
			setBackground(new Color(0,0,0,0));
			
			//size
			setSize(400,400);
			
			//label
			pic = new ImageIcon("nyan.gif");
			lab = new JLabel(text,pic,JLabel.CENTER);
			lab.setFont(new Font("Monospaced", Font.BOLD, 55));
			lab.setHorizontalTextPosition(JLabel.CENTER);
			
			//add listener
			lab.addMouseListener(new MListener());
			
			//add label to container
			c.add(lab);	
			
		}
		
		// Mouse Listener
		public class MListener extends MouseAdapter{
			public void mousePressed(MouseEvent e) {
				lab.setText(lifecounter-- +" ");
				speed +=2;
			}
		}
	
	
		public void run() throws Exception {
			
			//start location
			int y = 300;
			int x = 500;
			boolean yb = false;
			boolean xb = false;
			
			//loop for the steps
			while (lifecounter >= 0) {
				Thread.sleep(10);
				setLocation(x,y);
				
				// direction
				if (y >= dim.getHeight() - 200) {
					yb = true;
				}else if (y <= -200) {
					yb = false;
				}
				
				if (x >= dim.getWidth() - 200) {
					xb = true;
				}else if(x <= -200) {
					xb = false;
				}
				
				if (yb) {
					y -= speed;
				} else {
					y += speed;
				}
				
				if (xb) {
					x -= speed;
				}else {
					x += speed;
				}
				
				
			}
				
				lab.setText(" ");
				lab.setIcon(new ImageIcon("ex.gif"));
				//wait for 1.8 seconds
				Thread.sleep(1800);
				System.exit(0);
				
		}
	
	
	
	//main
	public static void main(String[] args) {
		
		Nyan frame = new Nyan();
		frame.setVisible(true);
		
		try {
			frame.run();
		} catch (Exception e) {
		}
		
	}

}
