/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Drawable;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Movable;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Resizable;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.Selectable;

/**
 * @author richie
 * 
 */
public abstract class AbstractGraphicalElement implements Drawable, Movable,
		Resizable, Selectable, Cloneable {

	public abstract boolean isWithinSelection(double x, double y, double width,
			double height);

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
