/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author richie
 * 
 */
public class GroupComposite extends AbstractGraphicalElement {

	private List<AbstractGraphicalElement> elements = new ArrayList<AbstractGraphicalElement>();

	@Override
	public boolean isWithinSelection(double x, double y, double width,
			double height) {
		for (AbstractGraphicalElement elem : elements) {
			if (elem.isWithinSelection(x, y, width, height)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(IRenderer r) {
		for (AbstractGraphicalElement element : elements) {
			element.draw(r);
		}
	}

	@Override
	public void move(double offsetX, double offsetY) {
		for (AbstractGraphicalElement element : elements) {
			element.move(offsetX, offsetY);
		}
	}

	@Override
	public void drawBounds(IRenderer r) {
		r.drawBounds(getBounds());
	}

	@Override
	public Bounds getBounds() {
		double x = 0d;
		double tempX = 0d;
		double y = 0d;
		double tempY = 0d;
		for (AbstractGraphicalElement elem : elements) {
			Bounds bounds = elem.getBounds();
			if (x == 0 || x > bounds.getX()) {
				x = bounds.getX();
			}
			if (y == 0 || y > bounds.getY()) {
				y = bounds.getY();
			}
			if (tempX == 0 || tempX < bounds.getWidth() + bounds.getX()) {
				tempX = bounds.getWidth() + bounds.getX();
			}
			if (tempY == 0 || tempY < bounds.getHeight() + bounds.getY()) {
				tempY = bounds.getHeight() + bounds.getY();
			}
		}
		return new Bounds(x, y, tempX - x, tempY - y);
	}

	@Override
	public void resize(double fromX, double fromY, double toX, double toY) {
		for (AbstractGraphicalElement element : elements) {
			element.resize(fromX, fromY, toX, toY);
		}
	}

	public static GroupComposite fromElements(
			List<AbstractGraphicalElement> elements) {
		GroupComposite gc = new GroupComposite();
		gc.getElements().addAll(elements);
		return gc;
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

	@Override
	public Object clone() throws CloneNotSupportedException {
		GroupComposite clone = (GroupComposite) super.clone();
		for (AbstractGraphicalElement elem : elements) {
			clone.getElements().add((AbstractGraphicalElement) elem.clone());
		}
		return clone;
	}

}
