/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.factory;

import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.AbstractGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Circle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Ellipse;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Line;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Square;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Triangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;

/**
 * @author Matthias
 * 
 */
public class DrawablePrototypeFactoryImpl implements DrawablePrototypeFactory {

	private Map<Class<?>, AbstractGraphicalElement> prototypes = new HashMap<Class<?>, AbstractGraphicalElement>();

	public DrawablePrototypeFactoryImpl() {
		prototypes.put(Rectangle.class, new Rectangle());
		prototypes.put(Square.class, new Square());
		prototypes.put(Line.class, new Line());
		prototypes.put(Ellipse.class, new Ellipse());
		prototypes.put(Circle.class, new Circle());
		prototypes.put(Triangle.class, new Triangle());
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

	@Override
	public Line createLine(double x, double y, RGBColor color, double thickness) {
		Line line;
		try {
			line = (Line) prototypes.get(Line.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		line.getPoints().add(new Point(x, y));
		line.setColor(color);
		line.setThickness(thickness);
		return line;
	}

	@Override
	public Square createSquare(double x, double y, double length,
			RGBColor color, double lineThickness, boolean filled) {
		Square square;
		try {
			square = (Square) prototypes.get(Square.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		square.setX(x);
		square.setY(y);
		square.setWidth(length);
		square.setHeight(length);
		square.setColor(color);
		square.setThickness(lineThickness);
		square.setFilled(filled);
		return square;
	}

	@Override
	public Ellipse createEllipse(double x, double y, double width,
			double height, RGBColor color, double lineThickness, boolean filled) {
		Ellipse ellipse;
		try {
			ellipse = (Ellipse) prototypes.get(Ellipse.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		ellipse.setX(x);
		ellipse.setY(y);
		ellipse.setWidth(width);
		ellipse.setHeight(height);
		ellipse.setColor(color);
		ellipse.setThickness(lineThickness);
		ellipse.setFilled(filled);
		return ellipse;
	}

	@Override
	public Circle createCircle(double x, double y, double radius,
			RGBColor color, double lineThickness, boolean filled) {
		Circle circle;
		try {
			circle = (Circle) prototypes.get(Circle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		circle.setX(x);
		circle.setY(y);
		circle.setWidth(radius);
		circle.setHeight(radius);
		circle.setColor(color);
		circle.setThickness(lineThickness);
		circle.setFilled(filled);
		return circle;
	}

	@Override
	public Triangle createTriangle(Point p1, Point p2, Point p3,
			RGBColor color, double lineThickness, boolean filled) {
		Triangle triangle;
		try {
			triangle = (Triangle) prototypes.get(Triangle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		triangle.setP1(p1);
		triangle.setP2(p2);
		triangle.setP3(p3);
		triangle.setColor(color);
		triangle.setThickness(lineThickness);
		triangle.setFilled(filled);
		return triangle;
	}

}
