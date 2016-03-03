package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {
	private int startX, startY, endX, endY;
	private int width, height;
	private Color color;

	public OvalTool(Color color){
		this.color = color;
	}
	
	public void mousePressed(Graphics g, int x, int y) {
		startX = endX = x;
		startY = endY = y;
		width = height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {		
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
		
		g.setColor(color);
		if (x < startX && y < startY) {
			g.drawOval(x, y, width, height);
		} else if (x < startX) {
			g.drawOval(x, startY, width, height);
		} else if (y < startY) {
			g.drawOval(startX, y, width, height);
		} else {
			g.drawOval(startX, startY, width, height);
		}
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
		this.endX = x;
		this.endY = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(color);
		if (endX < startX && endY < startY) {
			g.drawOval(endX, endY, width, height);
		} else if (endX < startX) {
			g.drawOval(endX, startY, width, height);
		} else if (endY < startY) {
			g.drawOval(startX, endY, width, height);
		} else {
			g.drawOval(startX, startY, width, height);
		}
	}

}
