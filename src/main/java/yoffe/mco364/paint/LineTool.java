package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LineTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;

	public LineTool(Color color){
		this.color = color;
	}
	
	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(color);
		g.drawLine(x1, y1, x, y);
	}

	
	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	
	public void drawPreview(Graphics g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
}
