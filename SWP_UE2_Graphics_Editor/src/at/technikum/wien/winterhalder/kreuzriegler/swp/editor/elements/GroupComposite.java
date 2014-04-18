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
public class GroupComposite implements IGraphicalElement{
	
	private List<IGraphicalElement> elements = new ArrayList<IGraphicalElement>();

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
	public void resize(double fromX, double fromY, double toX, double toY) {
		for (IGraphicalElement element : elements) {
			element.resize(fromX, fromY, toX, toY);
		}
	}
	
	public static GroupComposite fromElements(List<IGraphicalElement> elements){
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
	 * @param elements the elements to set
	 */
	public void setElements(List<IGraphicalElement> elements) {
		this.elements = elements;
	}
}
