package yoffe.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {
	private int width;
	private int height;
	private Color color;
	private BasicStroke weight;
	private boolean fill;
	private BufferedImage image;

	public PaintProperties(){
		this.width = 800;
		this.height = 600;
		this.color = Color.BLACK;
		this.weight = new BasicStroke(3);
		this.fill = false;
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
	}

	public PaintProperties(int width, int height, BufferedImage image, Color color, BasicStroke weight, boolean fill){
		this.width = width;
		this.height = height;
		this.color = color;
		this.weight = weight;
		this.fill = fill;
		this.image = image;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setStroke(int weight) {
		this.weight = new BasicStroke(weight);
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}
	public BasicStroke getStroke() {
		return weight;
	}
	public boolean isFill() {
		return fill;
	}
	public BufferedImage getImage() {
		return image;
	}


}
