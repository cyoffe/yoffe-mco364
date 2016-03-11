package yoffe.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {

	private BufferedImage image;

	public BucketTool(BufferedImage image, PaintProperties properties) {
		super(properties);
		this.image = image;
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {

		fill(x, y, image.getRGB(x, y), properties.getColor().getRGB(), image);

	}

	private void fill(int x1, int y1, int oldColor, int newColor,
			BufferedImage img) {
		Queue<Point> queue = new LinkedList<Point>();
		if(img.getRGB(x1, y1) == newColor){
			return;
		}
		queue.add(new Point(x1, y1));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.getX();
			int y = p.getY();
			int width = img.getWidth();
			int height = img.getHeight();
			if (x > 0 && y > 0 && x < width && y < height) {

				if (img.getRGB(x, y) == oldColor) {

					img.setRGB(x, y, newColor);
					queue.add(new Point(x - 1, y));
					queue.add(new Point(x + 1, y));
					queue.add(new Point(x, y - 1));
					queue.add(new Point(x, y + 1));
				}
			}
		}
	}

	public boolean isEmpty(BufferedImage image, int posX, int posY) {
		int color = image.getRGB(posX, posY);
		return color == 0;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
