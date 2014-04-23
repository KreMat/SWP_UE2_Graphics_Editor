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

	private static final double SELECTION_THICKNESS = 0.3d;
	private static final RGBColor SELECTION_COLOR = new RGBColor(0, 0, 0);

	private Map<Class<?>, AbstractGraphicalElement> prototypes = new HashMap<Class<?>, AbstractGraphicalElement>();

	public DrawablePrototypeFactoryImpl() {
		Rectangle rect = new Rectangle();
		rect.setFilled(false);
		rect.setColor(SELECTION_COLOR);
		rect.setHeight(1);
		rect.setWidth(1);
		rect.setThickness(SELECTION_THICKNESS);
		prototypes.put(Rectangle.class, rect);

		Square square = new Square();
		square.setWidth(1);
		square.setHeight(1);
		prototypes.put(Square.class, square);

		prototypes.put(Line.class, new Line());

		Ellipse ell = new Ellipse();
		ell.setHeight(1);
		ell.setWidth(1);
		prototypes.put(Ellipse.class, ell);

		Circle c = new Circle();
		c.setHeight(1);
		c.setWidth(1);
		prototypes.put(Circle.class, c);

		Triangle t = new Triangle();
		t.setP1(new Point(0, 0));
		t.setP2(new Point(1, 1));
		t.setP3(new Point(1, 1));
		prototypes.put(Triangle.class, t);
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
	public Rectangle createRectangle(double x, double y) {
		Rectangle rectangle;
		try {
			rectangle = (Rectangle) prototypes.get(Rectangle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		rectangle.setX(x);
		rectangle.setY(y);
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
	public Square createSquare(double x, double y, RGBColor color,
			double lineThickness, boolean filled) {
		Square square;
		try {
			square = (Square) prototypes.get(Square.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		square.setX(x);
		square.setY(y);
		square.setColor(color);
		square.setThickness(lineThickness);
		square.setFilled(filled);
		return square;
	}

	@Override
	public Ellipse createEllipse(double x, double y, RGBColor color,
			double lineThickness, boolean filled) {
		Ellipse ellipse;
		try {
			ellipse = (Ellipse) prototypes.get(Ellipse.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		ellipse.setX(x);
		ellipse.setY(y);
		ellipse.setColor(color);
		ellipse.setThickness(lineThickness);
		ellipse.setFilled(filled);
		return ellipse;
	}

	@Override
	public Circle createCircle(double x, double y, RGBColor color,
			double lineThickness, boolean filled) {
		Circle circle;
		try {
			circle = (Circle) prototypes.get(Circle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		circle.setX(x);
		circle.setY(y);
		circle.setColor(color);
		circle.setThickness(lineThickness);
		circle.setFilled(filled);
		return circle;
	}

	@Override
	public Triangle createTriangle(Point p1, RGBColor color,
			double lineThickness, boolean filled) {
		Triangle triangle;
		try {
			triangle = (Triangle) prototypes.get(Triangle.class).clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
		triangle.setP1(p1);
		triangle.setColor(color);
		triangle.setThickness(lineThickness);
		triangle.setFilled(filled);
		return triangle;
	}

}
