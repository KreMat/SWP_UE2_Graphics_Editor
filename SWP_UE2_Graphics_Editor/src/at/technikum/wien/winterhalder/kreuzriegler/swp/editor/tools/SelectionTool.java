/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.Rectangle;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.ITool;

/**
 * @author Matthias
 * 
 */
public class SelectionTool implements ITool {

	private DrawingEditorContext ctxt;
	private DrawablePrototypeFactory factory;
	private boolean mouseDown = false;
	private Rectangle rectangle;

	public SelectionTool(DrawingEditorContext ctxt,
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
		rectangle = factory.createRectangle(e.getMouseEvent().getX(), e
				.getMouseEvent().getY());
		ctxt.getElements().add(rectangle);
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
			double width = e.getMouseEvent().getX() - rectangle.getX();
			double height = e.getMouseEvent().getY() - rectangle.getY();
			rectangle.setWidth(width);
			rectangle.setHeight(height);
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
		ctxt.selectElement(rectangle.getX(), rectangle.getY(),
				rectangle.getWidth(), rectangle.getHeight());
		ctxt.getElements().remove(rectangle);
		ctxt.getSelectedElements().remove(rectangle);
		ctxt.stateChanged();
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
