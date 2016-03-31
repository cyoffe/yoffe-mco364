package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private static final long serialVersionUID = 1L;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;
	private Stack<BufferedImage> undo, redo;
	private PaintProperties properties;

	@Inject
	public Canvas(PaintProperties properties2) {

		setBackground(Color.WHITE);
		buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		properties = properties2;
		color = Color.BLACK;
		tool = new PencilTool(properties);

		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent event) {
				undo.push(new BufferedImage(buffer.getColorModel(), buffer
						.copyData(null), buffer.isAlphaPremultiplied(), null));
				tool.mousePressed(buffer.createGraphics(), event.getX(),
						event.getY());
				repaint();

			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.createGraphics(), event.getX(),
						event.getY());
				repaint();
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.createGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		});

	}

	public void setTool(Tool t) {
		tool = t;
	}

	public BufferedImage getBufferedImage() {
		return buffer;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;		
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g2);

	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(buffer);
			buffer = undo.pop();
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(buffer);
			buffer = redo.pop();
			repaint();
		}
	}

	public void setColor(Color newColor) {
		this.color = newColor;

	}

	public Tool getTool() {
		return tool;
	}
}