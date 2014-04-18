/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.AbstractGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool;

/**
 * @author Matthias
 * 
 */
public class ScaleTool implements ITool {

	private DrawingEditorContext ctxt;
	private boolean mouseDown = false;
	private double startX;
	private double startY;

	public ScaleTool(DrawingEditorContext ctxt) {
		this.ctxt = ctxt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool
	 * #handleMouseDown
	 * (at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent)
	 */
	@Override
	public void handleMouseDown(ToolEvent e) {
		mouseDown = true;
		startX = e.getMouseEvent().getX();
		startY = e.getMouseEvent().getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool
	 * #handleMouseMove
	 * (at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent)
	 */
	@Override
	public void handleMouseMove(ToolEvent e) {
		if (mouseDown) {
			for (AbstractGraphicalElement elem : ctxt.getSelectedElements()) {
				elem.resize(startX, startY, e.getMouseEvent().getX(), e
						.getMouseEvent().getY());
			}
			ctxt.stateChanged();
			startX = e.getMouseEvent().getX();
			startY = e.getMouseEvent().getY();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool
	 * #handleMouseUp
	 * (at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent)
	 */
	@Override
	public void handleMouseUp(ToolEvent e) {
		mouseDown = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool
	 * #handleMouseClick
	 * (at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent)
	 */
	@Override
	public void handleMouseClick(ToolEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool
	 * #handleMouseDoubleClick
	 * (at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools.ToolEvent)
	 */
	@Override
	public void handleMouseDoubleClick(ToolEvent e) {
		// TODO Auto-generated method stub

	}

}
