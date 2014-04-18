/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.renderer;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Bounds;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author Matthias
 * 
 */
public class CanvasRenderer implements IRenderer {

	private static final int CORNER_SIZE = 6;
	private GraphicsContext gc;

	public CanvasRenderer(GraphicsContext gc) {
		this.gc = gc;
	}

	@Override
	public void drawRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c) {
		gc.setStroke(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.strokeRect(x, y, w, h);
	}

	@Override
	public void drawFilledRectangle(double x, double y, double w, double h,
			double lineThickness, RGBColor c) {
		gc.setFill(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.fillRect(x, y, w, h);
	}

	@Override
	public void drawBounds(Bounds bounds) {
		double x = bounds.getX();
		double y = bounds.getY();
		double w = bounds.getWidth();
		double h = bounds.getHeight();
		drawRectangle(x, y, w, h, 2.0d, new RGBColor(0.1d, 0.5d, 0.6d));

		gc.setFill(Color.color(0.1d, 0.5d, 0.6d));
		gc.fillRect(x - CORNER_SIZE / 2, y - CORNER_SIZE / 2, CORNER_SIZE,
				CORNER_SIZE);
		gc.fillRect(x + w - CORNER_SIZE / 2, y - CORNER_SIZE / 2, CORNER_SIZE,
				CORNER_SIZE);
		gc.fillRect(x - CORNER_SIZE / 2, y + h - CORNER_SIZE / 2, CORNER_SIZE,
				CORNER_SIZE);
		gc.fillRect(x + w - CORNER_SIZE / 2, y + h - CORNER_SIZE / 2,
				CORNER_SIZE, CORNER_SIZE);
	}

	@Override
	public void drawEllipse(double x, double y, double radiusX, double radiusY,
			double lineThickness, RGBColor c) {
		gc.setStroke(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.strokeOval(x, y, radiusX, radiusY);
	}

	@Override
	public void drawFilledEllipse(double x, double y, double radiusX,
			double radiusY, double lineThickness, RGBColor c) {
		gc.setFill(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.fillOval(x, y, radiusX, radiusY);
	}

	@Override
	public void drawTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c) {
		gc.setStroke(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.strokePolygon(new double[] { p1.getX(), p2.getX(), p3.getX() },
				new double[] { p1.getY(), p2.getY(), p3.getY() }, 3);
	}

	@Override
	public void drawFilledTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c) {
		gc.setFill(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		gc.fillPolygon(new double[] { p1.getX(), p2.getX(), p3.getX() },
				new double[] { p1.getY(), p2.getY(), p3.getY() }, 3);

	}

	@Override
	public void drawLine(List<Point> points, double lineThickness, RGBColor c) {
		gc.setStroke(Color.color(c.getR(), c.getG(), c.getB()));
		gc.setLineWidth(lineThickness);
		for (int i = 0; i < points.size() - 1; i++) {
			gc.strokeLine(points.get(i).getX(), points.get(i).getY(), points
					.get(i + 1).getX(), points.get(i + 1).getY());
		}
		// for (Point p : points) {
		// gc.fillOval(p.getX(), p.getY(), lineThickness, lineThickness);
		// }
	}

	@Override
	public void reset() {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas()
				.getHeight());
	}

}
