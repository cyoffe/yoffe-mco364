package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener,
		MouseMotionListener {

	private int x;
	private int y;
	private int oldX;
	private int oldY;
	private BufferedImage bfrImage;
	private boolean dragging;

	public Canvas() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		bfrImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {

		Graphics g = bfrImage.getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval(e.getX(), e.getY(), 2, 2);
		dragging = true;
		oldX = e.getX();
		oldY = e.getY();
		repaint();

	}

	public void mouseReleased(MouseEvent arg0) {
		dragging = false;
	}

	public void mouseDragged(MouseEvent e) {
		if (dragging) {
			Graphics g = bfrImage.getGraphics();
			g.setColor(Color.BLUE);
			g.drawLine(oldX, oldY, e.getX(), e.getY());

			oldX = e.getX();
			oldY = e.getY();
			repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bfrImage, 0, 0, null);

	}
}
