package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	public void mousePressed(Graphics g, int x, int y, BufferedImage img) {

		fill(x, y, img.getRGB(x, y), Color.MAGENTA.getRGB(), img);

	}

	private void fill(int x1, int y1, int oldColor, int newColor,
			BufferedImage img) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x1, y1));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.getX();
			int y = p.getY();
			if (x > 0 && y > 0 && x < img.getWidth() && y < img.getHeight()
					&& img.getRGB(x, y) == oldColor) {

				img.setRGB(x, y, newColor);
				System.out.println(x + "   " + y);

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}
	}

	public boolean isEmpty(BufferedImage image, int posX, int posY) {
		int color = image.getRGB(posX, posY);
		System.out.println(color);
		return color == 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
