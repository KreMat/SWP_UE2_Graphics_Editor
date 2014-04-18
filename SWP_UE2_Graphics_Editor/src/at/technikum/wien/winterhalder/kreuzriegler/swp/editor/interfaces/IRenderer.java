package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;

public interface IRenderer {

	public void drawRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c);

	public void drawFilledRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c);

	public void drawCircle(double x, double y, double radius,
			double lineThickness, RGBColor c);

	public void drawFilledCircle(double x, double y, double radius,
			double lineThickness, RGBColor c);

	public void drawElipse(double x, double y, double radiusX, double radiusY,
			double lineThickness, RGBColor c);

	public void drawFilledElipse(double x, double y, double radiusX,
			double radiusY, double lineThickness, RGBColor c);

	public void drawTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c);

	public void drawFilledTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c);

	public void drawLine(List<Point> points, double lineThickness, RGBColor c);

	public void drawBounds(double x, double y, double w, double h);

	public void reset();
}
