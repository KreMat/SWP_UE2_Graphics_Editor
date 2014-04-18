/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Colored;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.HasThickness;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author Matthias
 * 
 */
public class Line extends AbstractGraphicalElement implements Colored,
		HasThickness {

	private List<Point> points = new ArrayList<Point>();
	private RGBColor color;
	private double thickness;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Drawable
	 * #draw(at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.
	 * IRenderer)
	 */
	@Override
	public void draw(IRenderer r) {
		r.drawLine(points, thickness, color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Movable
	 * #move(double, double)
	 */
	@Override
	public void move(double offsetX, double offsetY) {
		for (Point p : points) {
			p.setX(p.getX() + offsetX);
			p.setY(p.getY() + offsetY);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Resizable
	 * #resize(double, double, double, double)
	 */
	@Override
	public void resize(double fromX, double fromY, double toX, double toY) {
		// Do Nothing -> Line isn't resizable

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Selectable
	 * #
	 * drawBounds(at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces
	 * .IRenderer)
	 */
	@Override
	public void drawBounds(IRenderer r) {
		r.drawBounds(getBounds());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Selectable
	 * #getBounds()
	 */
	@Override
	public Bounds getBounds() {
		double x = 0;
		double y = 0;
		double tempX = 0;
		double tempY = 0;

		for (Point p : points) {
			if (x == 0 || x > p.getX()) {
				x = p.getX();
			}
			if (y == 0 || y > p.getY()) {
				y = p.getY();
			}
			if (tempX == 0 || tempX < p.getX()) {
				tempX = p.getX();
			}
			if (tempY == 0 || tempY < p.getY()) {
				tempY = p.getY();
			}
		}
		return new Bounds(x, y, tempX - x, tempY - y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.
	 * IGraphicalElement#isWithinSelection(double, double, double, double)
	 */
	@Override
	public boolean isWithinSelection(double x, double y, double width,
			double height) {
		for (Point p : points) {
			if (!isWithinSelection(p, x, y, width, height)) {
				return false;
			}
		}
		return true;
	}

	private boolean isWithinSelection(Point p, double x, double y,
			double width, double height) {
		if (x > p.getX()) {
			return false;
		}
		if (y > p.getY()) {
			return false;
		}
		if (x + width < p.getX()) {
			return false;
		}
		if (y + height < p.getY()) {
			return false;
		}
		return true;
	}

	@Override
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	@Override
	public double getThickness() {
		return thickness;
	}

	@Override
	public void setColor(RGBColor c) {
		this.color = c;
	}

	@Override
	public RGBColor getColor() {
		return color;
	}

	/**
	 * @return the points
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Line clone = (Line) super.clone();
		clone.setPoints(new ArrayList<Point>());
		for (Point elem : points) {
			clone.getPoints().add(new Point(elem.getX(), elem.getY()));
		}
		return clone;
	}

}
