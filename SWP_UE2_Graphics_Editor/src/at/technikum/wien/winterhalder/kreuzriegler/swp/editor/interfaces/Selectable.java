/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Bounds;

/**
 * @author Matthias
 * 
 */
public interface Selectable {

	public void drawBounds(IRenderer r);

	public Bounds getBounds();

}
