/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;

/**
 * @author Matthias
 * 
 */
public interface DrawablePrototypeFactory {

	public Rectangle createRectangle(double x, double y, double width,
			double height, RGBColor color, double lineThickness, boolean filled);

}
