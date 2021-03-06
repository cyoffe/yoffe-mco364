package yoffe.mco364.paint;

import java.awt.Graphics2D;

public abstract class Tool {

	protected PaintProperties properties;

	public Tool(PaintProperties properties2) {
		this.properties = properties2;
	}

	abstract void mouseReleased(Graphics2D g, int x, int y);

	abstract void mouseDragged(Graphics2D g, int x, int y);

	abstract void drawPreview(Graphics2D g);

	abstract void mousePressed(Graphics2D graphics, int x, int y);

}
