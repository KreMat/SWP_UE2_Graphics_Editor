/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

/**
 * @author richie
 * 
 */
public interface IGraphicalElement extends Drawable, Movable, Resizable,
		Cloneable {

	public boolean isWithinSelection(double x, double y, double width,
			double height);

	public Object clone() throws CloneNotSupportedException;
}
