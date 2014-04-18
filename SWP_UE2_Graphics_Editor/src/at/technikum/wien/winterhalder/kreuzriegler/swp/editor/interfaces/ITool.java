/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent;

/**
 * @author richie
 *
 */
public interface ITool {
	
	public void handleMouseDown(ToolEvent e);
	public void handleMouseMove(ToolEvent e);
	public void handleMouseUp(ToolEvent e);
	public void handleMouseClick(ToolEvent e);
	public void handleMouseDoubleClick(ToolEvent e);
}
