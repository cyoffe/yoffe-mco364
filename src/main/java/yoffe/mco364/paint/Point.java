package yoffe.mco364.paint;

public class Point {
	private int x;
	private int y;
	private boolean visited;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setVisited(){
		visited = true;
	}
}
