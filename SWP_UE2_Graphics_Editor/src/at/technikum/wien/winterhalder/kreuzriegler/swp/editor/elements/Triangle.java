/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Colored;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.HasThickness;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author Matthias
 * 
 */
public class Triangle extends AbstractGraphicalElement implements Colored,
		HasThickness {

	private Point p1;
	private Point p2;
	private Point p3;
	private RGBColor color;
	private double thickness;
	private boolean filled = false;;

	@Override
	public boolean isWithinSelection(double x, double y, double width,
			double height) {
		if (!isWithinSelection(p1, x, y, width, height)) {
			return false;
		}
		if (!isWithinSelection(p2, x, y, width, height)) {
			return false;
		}
		if (!isWithinSelection(p3, x, y, width, height)) {
			return false;
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
		if (filled) {
			r.drawFilledTriangle(p1, p2, p3, thickness, color);
		} else {
			r.drawTriangle(p1, p2, p3, thickness, color);
		}
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
		p1.setX(p1.getX() + offsetX);
		p1.setY(p1.getY() + offsetY);

		p2.setX(p2.getX() + offsetX);
		p2.setY(p2.getY() + offsetY);

		p3.setX(p3.getX() + offsetX);
		p3.setY(p3.getY() + offsetY);
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
		// calculate scaleFactors
		double sX = toX / fromX;
		double sY = toY / fromY;

		p1.setX(p1.getX() * sX);
		p1.setY(p1.getY() * sY);

		p2.setX(p2.getX() * sX);
		p2.setY(p2.getY() * sY);

		p3.setX(p3.getX() * sX);
		p3.setY(p3.getY() * sY);
	}

	@Override
	public void drawBounds(IRenderer r) {
		r.drawBounds(getBounds());
	}

	@Override
	public Bounds getBounds() {
		double x = 0;
		double y = 0;
		double tempX = 0;
		double tempY = 0;

		for (Point p : new Point[] { p1, p2, p3 }) {
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

	/**
	 * @return the color
	 */
	@Override
	public RGBColor getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	@Override
	public void setColor(RGBColor color) {
		this.color = color;
	}

	/**
	 * @return the thickness
	 */
	@Override
	public double getThickness() {
		return thickness;
	}

	/**
	 * @param thickness
	 *            the thickness to set
	 */
	@Override
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	/**
	 * @return the filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * @param filled
	 *            the filled to set
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * @return the p1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * @param p1
	 *            the p1 to set
	 */
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * @param p2
	 *            the p2 to set
	 */
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	/**
	 * @return the p3
	 */
	public Point getP3() {
		return p3;
	}

	/**
	 * @param p3
	 *            the p3 to set
	 */
	public void setP3(Point p3) {
		this.p3 = p3;
	}

}
