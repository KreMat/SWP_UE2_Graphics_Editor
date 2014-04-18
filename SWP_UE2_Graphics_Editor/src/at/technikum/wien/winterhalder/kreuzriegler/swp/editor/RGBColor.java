/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor;

/**
 * @author Matthias
 * 
 */
public class RGBColor {

	private double r;
	private double g;
	private double b;

	public RGBColor(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @param r
	 *            the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}

	/**
	 * @return the g
	 */
	public double getG() {
		return g;
	}

	/**
	 * @param g
	 *            the g to set
	 */
	public void setG(double g) {
		this.g = g;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}

}
