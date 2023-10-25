import javax.swing.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;


public class MyPanel extends JPanel implements ActionListener {

	final int PANEL_WIDTH = 600;
	final int PANEL_HEIGHT = 375;
	int x = 0;
	int y = 0;
	int xVelocity = 2;
	int yVelocity = 1;
	Timer timer;
	Image enemy;
	Image bgImage;
	
	MyPanel(){
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH , PANEL_HEIGHT));
		enemy = new ImageIcon("petuh.png").getImage();
		bgImage = new ImageIcon("bang.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
		
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);//paint bg
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(bgImage, 0, 0, null);
		g2D.drawImage(enemy,x, y, null);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
			
			xVelocity *= -1;
		}
		
		x = x + xVelocity;
		
		if (y >= PANEL_HEIGHT - enemy.getHeight(null) || x < 0) {
			
			yVelocity *= -1;
		}
		
		y = y + yVelocity;
		repaint();
	}

}
