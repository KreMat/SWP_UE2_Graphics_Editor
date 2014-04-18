/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.DrawingEditorContext;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.DrawablePrototypeFactory;

/**
 * @author Matthias
 * 
 */
public class ToolRepository {

	private DrawRectangleTool rectangleTool;

	private SelectionTool selectionTool;

	private MoveTool moveTool;

	private ScaleTool scaleTool;

	public ToolRepository(DrawingEditorContext ctxt,
			DrawablePrototypeFactory factory) {
		setRectangleTool(new DrawRectangleTool(ctxt, factory));
		setSelectionTool(new SelectionTool(ctxt, factory));
		setMoveTool(new MoveTool(ctxt));
		setScaleTool(new ScaleTool(ctxt));
	}

	/**
	 * @return the rectangleTool
	 */
	public DrawRectangleTool getRectangleTool() {
		return rectangleTool;
	}

	/**
	 * @param rectangleTool
	 *            the rectangleTool to set
	 */
	public void setRectangleTool(DrawRectangleTool rectangleTool) {
		this.rectangleTool = rectangleTool;
	}

	/**
	 * @return the selectionTool
	 */
	public SelectionTool getSelectionTool() {
		return selectionTool;
	}

	/**
	 * @param selectionTool
	 *            the selectionTool to set
	 */
	public void setSelectionTool(SelectionTool selectionTool) {
		this.selectionTool = selectionTool;
	}

	/**
	 * @return the moveTool
	 */
	public MoveTool getMoveTool() {
		return moveTool;
	}

	/**
	 * @param moveTool
	 *            the moveTool to set
	 */
	public void setMoveTool(MoveTool moveTool) {
		this.moveTool = moveTool;
	}

	/**
	 * @return the scaleTool
	 */
	public ScaleTool getScaleTool() {
		return scaleTool;
	}

	/**
	 * @param scaleTool
	 *            the scaleTool to set
	 */
	public void setScaleTool(ScaleTool scaleTool) {
		this.scaleTool = scaleTool;
	}

}
