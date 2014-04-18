/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.factory;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IGraphicalElement;

/**
 * @author Matthias
 * 
 */
public class DrawablePrototypeFactoryImpl implements DrawablePrototypeFactory {

	private Map<Class<?>, IGraphicalElement> prototypes = new HashMap<Class<?>, IGraphicalElement>();

	public DrawablePrototypeFactoryImpl() {
		prototypes.put(Rectangle.class, new Rectangle());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.
	 * DrawablePrototypeFactory#createRectangle(double, double, double, double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color,
	 * double)
	 */
	@Override
	public Rectangle createRectangle(double x, double y, double width,
			double height, RGBColor color, double lineThickness, boolean filled) {
		Rectangle rectangle;
		try {
			rectangle = (Rectangle) prototypes.get(Rectangle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		rectangle.setX(x);
		rectangle.setY(y);
		rectangle.setWidth(width);
		rectangle.setHeight(height);
		rectangle.setColor(color);
		rectangle.setThickness(lineThickness);
		rectangle.setFilled(filled);
		return rectangle;
	}

}
