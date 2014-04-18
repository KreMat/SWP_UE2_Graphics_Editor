package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Bounds;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;

public interface IRenderer {

	public void drawRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c);

	public void drawFilledRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c);

	public void drawEllipse(double x, double y, double radiusX, double radiusY,
			double lineThickness, RGBColor c);

	public void drawFilledEllipse(double x, double y, double radiusX,
			double radiusY, double lineThickness, RGBColor c);

	public void drawTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c);

	public void drawFilledTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c);

	public void drawLine(List<Point> points, double lineThickness, RGBColor c);

	public void drawBounds(Bounds b);

	public void reset();
}
