/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Square;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool;

/**
 * @author Matthias
 * 
 */
public class DrawSquareTool implements ITool {

	private DrawingEditorContext ctxt;
	private DrawablePrototypeFactory factory;
	private boolean mouseDown = false;
	private Square square;

	public DrawSquareTool(DrawingEditorContext ctxt,
			DrawablePrototypeFactory factory) {
		this.ctxt = ctxt;
		this.factory = factory;
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
		square = factory.createSquare(e.getMouseEvent().getX(), e
				.getMouseEvent().getY(), 1, e.getSelectedColor(), e
				.getSelectedThickness(), e.isSelectedFilled());
		ctxt.getElements().add(square);
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
			double width = e.getMouseEvent().getX() - square.getX();
			square.setWidth(width);
			ctxt.stateChanged();
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
	}

}
