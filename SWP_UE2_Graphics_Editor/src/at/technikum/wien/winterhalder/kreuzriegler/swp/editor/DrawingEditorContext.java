/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.AbstractGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements.GroupComposite;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author richie
 * 
 */
public class DrawingEditorContext {
	private List<AbstractGraphicalElement> elements = new ArrayList<AbstractGraphicalElement>();
	private List<AbstractGraphicalElement> selectedElements = new ArrayList<AbstractGraphicalElement>();
	private List<IRenderer> renderer = new ArrayList<IRenderer>();

	/**
	 * Renders all elements in all {@link IRenderer}
	 */
	public void render() {
		for (IRenderer r : renderer) {
			r.reset();
			for (AbstractGraphicalElement elem : elements) {
				elem.draw(r);
				if (selectedElements.contains(elem)) {
					elem.drawBounds(r);
				}
			}
		}
	}

	/**
	 * Group all selected elements
	 */
	public void groupElements() {
		GroupComposite newGroup = GroupComposite.fromElements(selectedElements);
		elements.removeAll(selectedElements);
		elements.add(newGroup);
		selectedElements.clear();
		selectedElements.add(newGroup);
	}

	/**
	 * Ungroup all selected elements
	 */
	public void ungroupElements() {
		for (AbstractGraphicalElement elem : selectedElements) {
			if (elem instanceof GroupComposite) {
				elements.remove(elem);
				selectedElements.remove(elem);
				for (AbstractGraphicalElement groupElem : ((GroupComposite) elem)
						.getElements()) {
					elements.add(groupElem);
					selectedElements.add(groupElem);
				}
			}
		}
	}

	public void selectElement(double x, double y, double w, double h) {
		selectedElements.clear();
		for (AbstractGraphicalElement elem : elements) {
			if (elem.isWithinSelection(x, y, w, h)) {
				selectedElements.add(elem);
			}
		}
	}

	/**
	 * if state has changed render all elements again
	 */
	public void stateChanged() {
		render();
	}

	/**
	 * @return the elements
	 */
	public List<AbstractGraphicalElement> getElements() {
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(List<AbstractGraphicalElement> elements) {
		this.elements = elements;
	}

	/**
	 * @return the renderer
	 */
	public List<IRenderer> getRenderer() {
		return renderer;
	}

	/**
	 * @param renderer
	 *            the renderer to set
	 */
	public void setRenderer(List<IRenderer> renderer) {
		this.renderer = renderer;
	}

	/**
	 * @return the selectedElements
	 */
	public List<AbstractGraphicalElement> getSelectedElements() {
		return selectedElements;
	}

	/**
	 * @param selectedElements
	 *            the selectedElements to set
	 */
	public void setSelectedElements(List<AbstractGraphicalElement> selectedElements) {
		this.selectedElements = selectedElements;
	}

}
