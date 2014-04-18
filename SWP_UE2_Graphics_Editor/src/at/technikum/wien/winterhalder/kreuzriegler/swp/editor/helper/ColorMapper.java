/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.helper;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color;

/**
 * @author Matthias
 * 
 */
public class ColorMapper {

	public javafx.scene.paint.Color mapColorToJavaFxColor(Color c) {
		return javafx.scene.paint.Color.valueOf(c.name());
	}
}
