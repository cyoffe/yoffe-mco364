package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {
	private int width;
	private int height;
	private Color color;
	private int weight;
	private boolean fill;
	private BufferedImage image;

	public PaintProperties(){
		this.width = 800;
		this.height = 600;
		this.color = Color.BLACK;
		this.weight = 1;
		this.fill = false;
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
	}

	public PaintProperties(int width, int height, BufferedImage image, Color color, int weight, boolean fill){
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
	public void setWeight(int weight) {
		this.weight = weight;
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
	public int getWeight() {
		return weight;
	}
	public boolean isFill() {
		return fill;
	}
	public BufferedImage getImage() {
		return image;
	}


}
