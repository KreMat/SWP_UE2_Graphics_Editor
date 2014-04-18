/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.tools;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.RGBColor;

/**
 * @author richie
 * 
 */
public class ToolEvent {

	private RGBColor selectedColor;
	private double selectedThickness;
	private boolean selectedFilled;
	private MouseEvent mouseEvent;

	public ToolEvent(boolean filled, RGBColor selectedColor,
			double selectedThickness, double sceneX, double sceneY) {
		this.selectedFilled = filled;
		this.selectedColor = selectedColor;
		this.selectedThickness = selectedThickness;
		mouseEvent = new MouseEvent(sceneX, sceneY);
	}

	/**
	 * @return the selectedColor
	 */
	public RGBColor getSelectedColor() {
		return selectedColor;
	}

	/**
	 * @param selectedColor
	 *            the selectedColor to set
	 */
	public void setSelectedColor(RGBColor selectedColor) {
		this.selectedColor = selectedColor;
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

	/**
	 * @return the selectedThickness
	 */
	public double getSelectedThickness() {
		return selectedThickness;
	}

	/**
	 * @param selectedThickness
	 *            the selectedThickness to set
	 */
	public void setSelectedThickness(double selectedThickness) {
		this.selectedThickness = selectedThickness;
	}

	/**
	 * @return the selectedFilled
	 */
	public boolean isSelectedFilled() {
		return selectedFilled;
	}

	/**
	 * @param selectedFilled
	 *            the selectedFilled to set
	 */
	public void setSelectedFilled(boolean selectedFilled) {
		this.selectedFilled = selectedFilled;
	}

}
