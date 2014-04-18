/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Line;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Point;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool;

/**
 * @author Matthias
 * 
 */
public class DrawLineTool implements ITool {

	private DrawingEditorContext ctxt;
	private DrawablePrototypeFactory factory;
	private boolean mouseDown = false;
	private Line line;

	public DrawLineTool(DrawingEditorContext ctxt,
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
		line = factory.createLine(e.getMouseEvent().getX(), e.getMouseEvent()
				.getY(), e.getSelectedColor(), e.getSelectedThickness());
		ctxt.getElements().add(line);
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
			line.getPoints().add(
					new Point(e.getMouseEvent().getX(), e.getMouseEvent()
							.getY()));
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
