package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CanvasGood extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage bufferedImage;
	private Tool tool;

	public CanvasGood() {
		this.tool = new BucketTool();
		bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				tool.mousePressed(bufferedImage.getGraphics(), e.getX(),
						e.getY(), bufferedImage);
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				addMouseMotionListener(new MouseMotionListener() {

					public void mouseDragged(MouseEvent e) {
						tool.mouseDragged(bufferedImage.getGraphics(),
								e.getX(), e.getY());
						repaint();
					}

					public void mouseMoved(MouseEvent e) {
						
					}
				});

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bufferedImage, 0, 0, null);
		tool.drawPreview(g);

	}
}
