/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Square;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.factory.DrawablePrototypeFactoryImpl;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;

/**
 * @author Matthias
 * 
 */
public class DrawablePrototypeFactoryTest extends Assert {

	private DrawablePrototypeFactory drawablePrototypeFactory;

	@Before
	public void setUp() {
		drawablePrototypeFactory = new DrawablePrototypeFactoryImpl();
	}

	@Test
	public void testCreateRectangle() {
		RGBColor color = new RGBColor(1, 2, 3);
		Rectangle rectangle = drawablePrototypeFactory.createRectangle(1, 2, 3,
				4, color, 5, true);
		assertEquals(color, rectangle.getColor());
		assertEquals(1.0, rectangle.getX());
		assertEquals(2.0, rectangle.getY());
		assertEquals(3.0, rectangle.getWidth());
		assertEquals(4.0, rectangle.getHeight());
		assertEquals(5.0, rectangle.getThickness());
		assertTrue(rectangle.isFilled());
	}

	@Test
	public void testCreateSquare() {
		RGBColor color = new RGBColor(1, 2, 3);
		Square square = drawablePrototypeFactory.createSquare(1, 2, 3, color,
				4, false);
		assertEquals(color, square.getColor());
		assertEquals(1.0, square.getX());
		assertEquals(2.0, square.getY());
		assertEquals(3.0, square.getWidth());
		assertEquals(3.0, square.getHeight());
		assertEquals(4.0, square.getThickness());
		assertFalse(square.isFilled());
	}
}
