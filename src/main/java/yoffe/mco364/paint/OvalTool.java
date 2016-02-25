package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class OvalTool implements Tool {
	private int startX, startY, endX, endY;
	private int width, height;

	public void mousePressed(Graphics g, int x, int y, BufferedImage img) {
		startX = endX = x;
		startY = endY = y;
		width = height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.ORANGE);

		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
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
		g.setColor(Color.ORANGE);
		if (endX < startX && endY < startY) {
			g.drawOval(endX, endY, width, height);
			System.out.println("first");
		} else if (endX < startX) {
			g.drawOval(endX, startY, width, height);
			System.out.println("second");
		} else if (endY < startY) {
			g.drawOval(startX, endY, width, height);
			System.out.println("third");
		} else {
			g.drawOval(startX, startY, width, height);
			System.out.println("forth");
		}
	}

}

/*
 * import java.awt.Color; import java.awt.Graphics;
 * 
 * public class OvalTool implements Tool { private int endX, endY, startX,
 * startY; private int width, height;
 * 
 * public void mousePressed(Graphics g, int x, int y) { this.endX = x = startX;
 * this.endY = y = startY; width = height = 0; }
 * 
 * public void mouseReleased(Graphics g, int x, int y) { this.width = Math.abs(x
 * - startX); this.height = Math.abs(y - startY); endX = x; endY = y;
 * 
 * g.setColor(Color.BLACK); if (endX < startX && endY < startY) {
 * g.drawOval(endX, endY, width, height); } else if (endX < startX) {
 * g.drawOval(endX, startY, width, height); } else if (endY < startY) {
 * g.drawOval(startX, endY, width, height); } else { g.drawOval(startX, startY,
 * width, height); } }
 * 
 * public void mouseDragged(Graphics g, int x, int y) { this.width = Math.abs(x
 * - startX); this.height = Math.abs(y - startY); this.endX = x; this.endY = y;
 * 
 * }
 * 
 * public void drawPreview(Graphics g) { g.setColor(Color.BLACK); if (endX <
 * startX && endY < startY) { g.drawOval(endX, endY, width, height); } else if
 * (endX < startX) { g.drawOval(endX, startY, width, height); } else if (endY <
 * startY) { g.drawOval(startX, endY, width, height); } else {
 * g.drawOval(startX, startY, width, height); }
 * 
 * }
 * 
 * }
 */
