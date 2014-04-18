/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.renderer;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.helper.ColorMapper;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author Matthias
 * 
 */
public class CanvasRenderer implements IRenderer {

	private GraphicsContext gc;
	private ColorMapper colorMapper;

	public CanvasRenderer(GraphicsContext gc) {
		this.gc = gc;
		colorMapper = new ColorMapper();
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
			double lineThickness, Color c) {
		gc.setFill(colorMapper.mapColorToJavaFxColor(c));
		gc.setLineWidth(lineThickness);
		gc.fillRect(x, y, w, h);
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
			double lineThickness, Color c) {
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
			double lineThickness, Color c) {
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
			double lineThickness, Color c) {
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
	public void drawLine(List<Point> points, double lineThickness, Color c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas()
				.getHeight());
	}

}
