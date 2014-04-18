/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

/**
 * @author Matthias
 * 
 */
public class Circle extends Ellipse {

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
		setWidth(getWidth() * sX);
	}

	/**
	 * @param width
	 *            the width to set
	 */
	@Override
	public void setWidth(double width) {
		this.width = width;
		this.height = width;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	@Override
	public void setHeight(double height) {
		this.height = height;
		this.width = height;
	}

}
