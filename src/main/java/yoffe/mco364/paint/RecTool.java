package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class RecTool implements Tool {
	private int endX, endY, startX, startY;
	private int width, height;

	public void mousePressed(Graphics g, int x, int y, BufferedImage img) {
		this.startX = endX = x;
		this.startY = endY = y;
		this.width = this.height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {

		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
		endX = x;
		endY = y;

		g.setColor(Color.RED);
		if (endX < startX && endY < startY) {
			g.drawRect(endX, endY, width, height);
		} else if (endX < startX) {
			g.drawRect(endX, startY, width, height);
		} else if (endY < startY) {
			g.drawRect(startX, endY, width, height);
		} else {
			g.drawRect(startX, startY, width, height);
		}
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.endX = x;
		this.endY = y;
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.RED);

		if (endX < startX && endY < startY) {
			g.drawRect(endX, endY, width, height);
		} else if (endX < startX) {
			g.drawRect(endX, startY, width, height);
		} else if (endY < startY) {
			g.drawRect(startX, endY, width, height);
		} else {
			g.drawRect(startX, startY, width, height);
		}
	}
}
