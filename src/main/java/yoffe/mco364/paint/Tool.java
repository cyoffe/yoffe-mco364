package yoffe.mco364.paint;

import java.awt.Graphics;

public abstract class Tool {

	protected PaintProperties properties;

	public Tool(PaintProperties properties2) {
		this.properties = properties2;
	}

	abstract void mouseReleased(Graphics g, int x, int y);

	abstract void mouseDragged(Graphics g, int x, int y);

	abstract void drawPreview(Graphics g);

	abstract void mousePressed(Graphics graphics, int x, int y);

}
