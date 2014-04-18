/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor;

import java.util.ArrayList;
import java.util.List;

import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IGraphicalElement;
import at.technikum.wien.winterhalder.kreuzriegler.swp.editor.interfaces.IRenderer;

/**
 * @author richie
 *
 */
public class DrawingEditorContext {
	private List<IGraphicalElement> elements = new ArrayList<IGraphicalElement>();
	private List<IGraphicalElement> selectedElements = new ArrayList<IGraphicalElement>();
	private List<IRenderer> renderer = new ArrayList<IRenderer>();
	
	
	public void render(){
		
	}
	
	public void groupElements(){
		
	}
	
	public void ungroupElements(){
		
	}
	
	public void selectElement(double x, double y, double w, double h){
		
	}
	
	public void stateChanged(){
		
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

	/**
	 * @return the renderer
	 */
	public List<IRenderer> getRenderer() {
		return renderer;
	}

	/**
	 * @param renderer the renderer to set
	 */
	public void setRenderer(List<IRenderer> renderer) {
		this.renderer = renderer;
	}
	
}
