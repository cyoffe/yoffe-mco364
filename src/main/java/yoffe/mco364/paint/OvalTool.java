package yoffe.mco364.paint;

import java.awt.Graphics2D;

public class OvalTool extends Tool {


	private int startX, startY, endX, endY;
	private int width, height;

	public OvalTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		startX = endX = x;
		startY = endY = y;
		width = height = 0;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {		
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);

		g.setColor(properties.getColor());
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

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.width = Math.abs(x - startX);
		this.height = Math.abs(y - startY);
		this.endX = x;
		this.endY = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
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
