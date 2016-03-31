package yoffe.mco364.paint;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {
	/*
	 * learning how to test things that seem untestable.
	 * 
	 * even if tests have common code- DON'T MAKE MEMBER VARIABLES OF TEST CLASS
	 */
	@Test
	public void testMouseReleased() {

		// mockito - can mock any class so makes a similar class to the mock up
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		LineTool tool = new LineTool(properties);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		// create a fake Graphics2D object
		Graphics2D g = Mockito.mock(Graphics2D.class);

		tool.mousePressed(g, 5, 5);
		tool.mouseReleased(g, 10, 10);

		Mockito.verify(g).setColor(Color.RED); // if call a method of a mock, it
		// does nothing
		// a method would return a default value

		// check to make sure that g.drawLine(5,5,10,10) was called
		// anti-aliasing is used to smooth something out
		Mockito.verify(g).drawLine(5, 5, 10, 10);

	}

	@Test
	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		LineTool tool = new LineTool(properties);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics2D g = Mockito.mock(Graphics2D.class);

		tool.mousePressed(g, 6, 5);
		tool.mouseDragged(g, 9, 7);
		tool.drawPreview(g);

		Mockito.verify(g).drawLine(6, 5, 9, 7);
		Mockito.verify(g).setColor(Color.RED);

	}
}
