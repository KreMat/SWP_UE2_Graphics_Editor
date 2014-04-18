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

	private DrawEllipseTool ellipseTool;

	private DrawCircleTool circleTool;

	private DrawSquareTool squareTool;

	private DrawTriangleTool triangleTool;

	private DrawLineTool lineTool;

	private SelectionTool selectionTool;

	private MoveTool moveTool;

	private ScaleTool scaleTool;

	public ToolRepository(DrawingEditorContext ctxt,
			DrawablePrototypeFactory factory) {
		setRectangleTool(new DrawRectangleTool(ctxt, factory));
		setSelectionTool(new SelectionTool(ctxt, factory));
		setMoveTool(new MoveTool(ctxt));
		setScaleTool(new ScaleTool(ctxt));
		setLineTool(new DrawLineTool(ctxt, factory));
		setSquareTool(new DrawSquareTool(ctxt, factory));
		setEllipseTool(new DrawEllipseTool(ctxt, factory));
		setCircleTool(new DrawCircleTool(ctxt, factory));
		setTriangleTool(new DrawTriangleTool(ctxt, factory));
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

	/**
	 * @return the lineTool
	 */
	public DrawLineTool getLineTool() {
		return lineTool;
	}

	/**
	 * @param lineTool
	 *            the lineTool to set
	 */
	public void setLineTool(DrawLineTool lineTool) {
		this.lineTool = lineTool;
	}

	/**
	 * @return the squareTool
	 */
	public DrawSquareTool getSquareTool() {
		return squareTool;
	}

	/**
	 * @param squareTool
	 *            the squareTool to set
	 */
	public void setSquareTool(DrawSquareTool squareTool) {
		this.squareTool = squareTool;
	}

	/**
	 * @return the ellipseTool
	 */
	public DrawEllipseTool getEllipseTool() {
		return ellipseTool;
	}

	/**
	 * @param ellipseTool
	 *            the ellipseTool to set
	 */
	public void setEllipseTool(DrawEllipseTool ellipseTool) {
		this.ellipseTool = ellipseTool;
	}

	/**
	 * @return the circleTool
	 */
	public DrawCircleTool getCircleTool() {
		return circleTool;
	}

	/**
	 * @param circleTool
	 *            the circleTool to set
	 */
	public void setCircleTool(DrawCircleTool circleTool) {
		this.circleTool = circleTool;
	}

	/**
	 * @return the triangleTool
	 */
	public DrawTriangleTool getTriangleTool() {
		return triangleTool;
	}

	/**
	 * @param triangleTool
	 *            the triangleTool to set
	 */
	public void setTriangleTool(DrawTriangleTool triangleTool) {
		this.triangleTool = triangleTool;
	}

}
