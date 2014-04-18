/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.enums.Color;

/**
 * @author richie
 * 
 */
public class ToolEvent {

	private Color selectedColor;
	private double thickness;
	private MouseEvent mouseEvent;

	/**
	 * @return the selectedColor
	 */
	public Color getSelectedColor() {
		return selectedColor;
	}

	/**
	 * @param selectedColor
	 *            the selectedColor to set
	 */
	public void setSelectedColor(Color selectedColor) {
		this.selectedColor = selectedColor;
	}

	/**
	 * @return the thickness
	 */
	public double getThickness() {
		return thickness;
	}

	/**
	 * @param thickness
	 *            the thickness to set
	 */
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	/**
	 * @return the mouseEvent
	 */
	public MouseEvent getMouseEvent() {
		return mouseEvent;
	}

	/**
	 * @param mouseEvent
	 *            the mouseEvent to set
	 */
	public void setMouseEvent(MouseEvent mouseEvent) {
		this.mouseEvent = mouseEvent;
	}

}
