package yoffe.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame implements ActionListener {
	private JButton line, pencil, bucket, oval, rectangle, color, undo, redo,
	lastUsed;
	private final Canvas canvas;
	private Color newColor;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		newColor = Color.BLACK;
		canvas = new Canvas();

		JPanel tools = new JPanel();
		tools.setLayout(new GridLayout(1, 7));

		line = new JButton();
		line.addActionListener(this);
		line.setIcon(new ImageIcon(new ImageIcon("./line.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		line.setBackground(Color.WHITE);

		pencil = new JButton();
		pencil.addActionListener(this);
		pencil.setIcon(new ImageIcon(new ImageIcon("./pencil.jpg").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		pencil.setBackground(Color.WHITE);

		bucket = new JButton();
		bucket.addActionListener(this);
		bucket.setIcon(new ImageIcon(new ImageIcon("./bucket.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		bucket.setBackground(Color.WHITE);

		oval = new JButton();
		oval.addActionListener(this);
		oval.setIcon(new ImageIcon(new ImageIcon("./oval.jpg").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		oval.setBackground(Color.WHITE);

		rectangle = new JButton();
		rectangle.addActionListener(this);
		rectangle.setIcon(new ImageIcon(new ImageIcon("./rectangle.jpg")
		.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		rectangle.setBackground(Color.WHITE);

		color = new JButton();
		color.setBackground(newColor);
		color.addActionListener(this);

		lastUsed = pencil;

		JPanel undoRedo = new JPanel();
		undoRedo.setLayout(new GridLayout(2, 1));

		undo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon("./undo.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		undo.setBackground(Color.WHITE);

		redo = new JButton();
		redo.setIcon(new ImageIcon(new ImageIcon("./redo.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		redo.setBackground(Color.WHITE);

		undoRedo.add(undo);
		undoRedo.add(redo);

		undo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.undo();

			}

		});

		redo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				canvas.redo();

			}

		});

		tools.add(undoRedo);
		tools.add(line);
		tools.add(pencil);
		tools.add(oval);
		tools.add(rectangle);
		tools.add(bucket);
		tools.add(color);

		container.add(canvas, BorderLayout.CENTER);
		container.add(tools, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		source.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		lastUsed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		if (source == color) {
			newColor = JColorChooser
					.showDialog(this, "Color Chooser", newColor);
			if (newColor != null) {
				color.setBackground(newColor);
				canvas.setColor(newColor);
			}
			color.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			setTool(lastUsed);
			lastUsed.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		} else {
			setTool(source);
		}

	}

	public void setTool(JButton button) {
		if (button == line) {
			canvas.setTool(new LineTool(newColor));
			lastUsed = line;
		} else if (button == pencil) {
			canvas.setTool(new PencilTool(newColor));
			lastUsed = pencil;
		} else if (button == oval) {
			canvas.setTool(new OvalTool(newColor));
			lastUsed = oval;
		} else if (button == rectangle) {
			canvas.setTool(new RecTool(newColor));
			lastUsed = rectangle;
		} else if (button == bucket) {
			canvas.setTool(new BucketTool(canvas.getBufferedImage(), newColor));
			lastUsed = bucket;
		}
	}
}
