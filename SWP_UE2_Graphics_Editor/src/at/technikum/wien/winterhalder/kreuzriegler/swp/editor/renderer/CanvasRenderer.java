/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.renderer;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer
	 * #drawRectangle(double, double, double, double, double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color)
	 */
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
	public void drawBounds(double x, double y, double w, double h) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer
	 * #drawCircle(double, double, double, double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color)
	 */
	@Override
	public void drawCircle(double x, double y, double radius,
			double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer
	 * #drawElipse(double, double, double, double, double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color)
	 */
	@Override
	public void drawElipse(double x, double y, double radiusX, double radiusY,
			double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer
	 * #
	 * drawTriangle(at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements
	 * .Point,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point,
	 * double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color)
	 */
	@Override
	public void drawTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer
	 * #drawLine(java.util.List, double,
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color)
	 */
	@Override
	public void drawLine(List<Point> points, double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFilledCircle(double x, double y, double radius,
			double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFilledElipse(double x, double y, double radiusX,
			double radiusY, double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFilledTriangle(Point p1, Point p2, Point p3,
			double lineThickness, RGBColor c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas()
				.getHeight());
	}

}
