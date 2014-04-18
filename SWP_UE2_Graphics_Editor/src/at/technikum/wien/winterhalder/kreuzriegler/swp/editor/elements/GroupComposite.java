/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.elements;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author richie
 * 
 */
public class GroupComposite implements IGraphicalElement {

	private List<IGraphicalElement> elements = new ArrayList<IGraphicalElement>();

	@Override
	public boolean isWithinSelection(double x, double y, double width,
			double height) {
		for (IGraphicalElement elem : elements) {
			if (elem.isWithinSelection(x, y, width, height)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(IRenderer r) {
		for (IGraphicalElement element : elements) {
			element.draw(r);
		}
	}

	@Override
	public void move(double offsetX, double offsetY) {
		for (IGraphicalElement element : elements) {
			element.move(offsetX, offsetY);
		}
	}

	@Override
	public void drawBounds(IRenderer r) {
		Bounds b = getBounds();
		r.drawBounds(b.getX(), b.getY(), b.getWidth(), b.getHeight());
	}

	@Override
	public Bounds getBounds() {
		double x = 0d;
		double tempX = 0d;
		double y = 0d;
		double tempY = 0d;
		for (IGraphicalElement elem : elements) {
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
		for (IGraphicalElement element : elements) {
			element.resize(fromX, fromY, toX, toY);
		}
	}

	public static GroupComposite fromElements(List<IGraphicalElement> elements) {
		GroupComposite gc = new GroupComposite();
		gc.getElements().addAll(elements);
		return gc;
	}

	/**
	 * @return the elements
	 */
	public List<IGraphicalElement> getElements() {
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(List<IGraphicalElement> elements) {
		this.elements = elements;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		GroupComposite clone = (GroupComposite) super.clone();
		for (IGraphicalElement elem : elements) {
			clone.getElements().add((IGraphicalElement) elem.clone());
		}
		return clone;
	}

}
