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

	public Rectangle createRectangle(double x, double y);

	public Square createSquare(double x, double y, RGBColor color,
			double lineThickness, boolean filled);

	public Line createLine(double x, double y, RGBColor color, double thickness);

	public Ellipse createEllipse(double x, double y, RGBColor color,
			double lineThickness, boolean filled);

	public Circle createCircle(double x, double y, RGBColor color,
			double lineThickness, boolean filled);

	public Triangle createTriangle(Point p1, RGBColor color,
			double lineThickness, boolean filled);

}
