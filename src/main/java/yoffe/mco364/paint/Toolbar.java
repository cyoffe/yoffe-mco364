package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

@Singleton
public class Toolbar extends Container implements ActionListener{

	private JButton color, undo, redo;
	private JButton lastUsed;
	private Canvas canvas;
	private PaintProperties properties;

	@Inject
	public Toolbar(final Canvas canvas, PaintProperties properties){


		this.canvas = canvas;
		this.properties = properties;

		setLayout(new GridLayout(1, 7));

		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new BucketTool(canvas.getBufferedImage(),
						properties), "/bucket.png"),
						new ToolButton(new OvalTool(properties), "/oval.png"),
						new ToolButton(new RecTool(properties), "/rectangle.png") };

		color = new JButton(new ImageIcon(getClass().getResource(
				"/color.png")));
		color.setBackground(Color.WHITE);
		color.addActionListener(this);

		lastUsed = buttons[1];

		JPanel undoRedo = new JPanel();
		undoRedo.setLayout(new GridLayout(2, 1));

		undo = new JButton();
		undo.setIcon(new ImageIcon(getClass().getResource("/undo.png")));
		undo.setBackground(Color.WHITE);

		redo = new JButton();
		redo.setIcon(new ImageIcon(getClass().getResource("/redo.png")));
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

		add(undoRedo);
		for (ToolButton b : buttons) {
			add(b);
			b.addActionListener(this);
		}
		add(color);

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
