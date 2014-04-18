package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color;

public interface IRenderer {
	
	public void drawRectangle(double x, double y, double w, double h, double lineThickness, Color c);
	public void drawCircle(double x, double y, double radius, double lineThickness, Color c);
	public void drawElipse(double x, double y, double radiusX, double radiusY, double lineThickness, Color c);
	public void drawTriangle(Point p1, Point p2, Point p3, double lineThickness, Color c);
	public void drawLine(List<Point> points, double lineThickness, Color c);
}
