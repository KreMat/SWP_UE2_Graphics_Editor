/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color;

/**
 * @author Matthias
 * 
 */
public interface DrawablePrototypeFactory {

	public Rectangle createRectangle(double x, double y, double width,
			double height, Color color, double lineThickness);

}
