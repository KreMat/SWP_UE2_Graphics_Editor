/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Colored;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.HasThickness;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author Matthias
 * 
 */
public class Rectangle implements IGraphicalElement, Colored, HasThickness {

	private double x;
	private double y;
	private double width;
	private double height;
	private RGBColor color;
	private double thickness;
	private boolean filled = false;;

	@Override
	public boolean isWithinSelection(double x, double y, double width,
			double height) {
		if (this.x < x) {
			return false;
		}

		if (this.y < y) {
			return false;
		}

		if (this.x + this.width > x + width) {
			return false;
		}

		if (this.y + this.height > y + height) {
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
			r.drawFilledRectangle(x, y, width, height, thickness, color);
		} else {
			r.drawRectangle(x, y, width, height, thickness, color);
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
		x += offsetX;
		y += offsetY;
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

		x *= sX;
		y *= sY;
		width *= sX;
		height *= sY;
	}

	@Override
	public void drawBounds(IRenderer r) {
		r.drawBounds(x, y, width, height);
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(x, y, width, height);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
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

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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

}
