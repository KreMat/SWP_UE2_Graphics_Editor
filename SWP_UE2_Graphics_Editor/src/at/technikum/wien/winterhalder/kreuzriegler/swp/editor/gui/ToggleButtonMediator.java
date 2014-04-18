/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

/**
 * @author Matthias
 * 
 */
public class ToggleButtonMediator {

	private List<ToggleButton> buttons = new ArrayList<ToggleButton>();

	public void registerButton(final ToggleButton btn) {
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						toggle(btn);
					}
				});
		buttons.add(btn);
	}

	public void unregisterButton(ToggleButton btn) {
		buttons.remove(btn);
	}

	public void toggle(ToggleButton btn) {
		for (ToggleButton button : buttons) {
			button.setSelected(false);
		}
		btn.setSelected(true);
	}
}
