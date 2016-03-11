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

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class PaintFrame extends JFrame implements ActionListener {
	private JButton color, undo, redo, lastUsed;
	private final Canvas canvas;
	private PaintProperties properties;

	@Inject
	public PaintFrame(PaintProperties properties) {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		this.properties = properties;
		canvas = new Canvas(properties);

		JPanel tools = new JPanel();
		tools.setLayout(new GridLayout(1, 7));

		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new PencilTool(properties), "/pencil.jpg"),
				new ToolButton(new BucketTool(canvas.getBufferedImage(),
						properties), "/bucket.png"),
						new ToolButton(new OvalTool(properties), "/oval.jpg"),
						new ToolButton(new RecTool(properties), "/rectangle.jpg") };

		color = new JButton(new ImageIcon(new ImageIcon(getClass().getResource(
				"/color.png")).getImage().getScaledInstance(125, 100,
						Image.SCALE_SMOOTH)));
		color.setBackground(Color.WHITE);
		color.addActionListener(this);

		lastUsed = buttons[1];

		JPanel undoRedo = new JPanel();
		undoRedo.setLayout(new GridLayout(2, 1));

		undo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon("undo.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		undo.setBackground(Color.WHITE);

		redo = new JButton();
		redo.setIcon(new ImageIcon(new ImageIcon("redo.png").getImage()
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
		for (ToolButton b : buttons) {
			tools.add(b);
			b.addActionListener(this);
		}
		tools.add(color);

		container.add(canvas, BorderLayout.CENTER);
		container.add(tools, BorderLayout.NORTH);

	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		source.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		lastUsed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		if (source == color) {
			properties.setColor(JColorChooser.showDialog(this, "Color Chooser",
					properties.getColor()));
			if (properties.getColor() != null) {
				color.setBackground(properties.getColor());
				canvas.setColor(properties.getColor());
			}
			color.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			canvas.setTool(((ToolButton) lastUsed).getTool());

			lastUsed.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		} else {
			canvas.setTool(((ToolButton) source).getTool());
			lastUsed = source;
		}

	}

}
