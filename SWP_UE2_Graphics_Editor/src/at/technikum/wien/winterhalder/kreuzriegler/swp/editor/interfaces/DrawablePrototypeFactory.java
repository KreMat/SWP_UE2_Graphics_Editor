/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Circle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Ellipse;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Line;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Square;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Triangle;

/**
 * @author Matthias
 * 
 */
public interface DrawablePrototypeFactory {

	public Rectangle createRectangle(double x, double y, double width,
			double height, RGBColor color, double lineThickness, boolean filled);

	public Square createSquare(double x, double y, double length,
			RGBColor color, double lineThickness, boolean filled);

	public Line createLine(double x, double y, RGBColor color, double thickness);

	public Ellipse createEllipse(double x, double y, double width,
			double height, RGBColor color, double lineThickness, boolean filled);

	public Circle createCircle(double x, double y, double radius,
			RGBColor color, double lineThickness, boolean filled);

	public Triangle createTriangle(Point p1, Point p2, Point p3,
			RGBColor color, double lineThickness, boolean filled);

}
