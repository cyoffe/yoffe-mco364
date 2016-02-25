package yoffe.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);
	
	void drawPreview(Graphics g);

	void mousePressed(Graphics graphics, int x, int y, BufferedImage bufferedImage);

}
