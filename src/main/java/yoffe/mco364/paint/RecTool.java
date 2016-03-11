package yoffe.mco364.paint;

import java.awt.Graphics;

public class RecTool extends Tool {


	private int endX, endY, startX, startY;
	private int width, height;
	private PaintProperties properties;

	public RecTool(PaintProperties properties) {
		super(properties);
		this.properties = properties;
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		this.startX = endX = x;
		this.startY = endY = y;
		this.width = this.height = 0;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {

		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
		endX = x;
		endY = y;

		g.setColor(properties.getColor());
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

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		this.endX = x;
		this.endY = y;
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(properties.getColor());

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
